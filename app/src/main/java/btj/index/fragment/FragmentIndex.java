package btj.index.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

import btj.index.activity.BannerViewActivity;
import btj.index.activity.InviteAwardActivity;
import btj.index.activity.MessageCenter;
import btj.index.activity.NewhandGuideActivity;
import btj.index.activity.SiginActivity;
import btj.index.entity.BannerListBean;
import btj.index.entity.DataBean;
import btj.index.entity.ProductBean;
import btj.index.entity.adapter.BannerPageAdapter2;
import btj.util.HttpClient;
import btj.util.Urls;
import btj.widget.AutoScrollViewPager;
import btj.widget.BannerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentIndex extends Fragment {
    //轮播图和点
    private AutoScrollViewPager autoScrollViewPager;
    private LinearLayout llDot;
    private List<BannerListBean> bannerList=new ArrayList<BannerListBean>();
    private ProductBean product;
    private static final String TAG="FragmentIndex";
    //推荐标的信息
    private TextView productTitle;
    private TextView productLimit;
    private TextView productInterest1;
    private TextView productInterest2;
    //新手指引 邀请有礼 消息中心 签到
    private ImageView ivNewhandGuide;
    private ImageView ivInvite;
    private ImageView ivMessageCenter;
    private ImageView ivSigin;
    public FragmentIndex() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_index, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化view
        initViews();
        //ImageLoader在使用之前必须先初始化一次,否则就会报错!!!
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getActivity()).build();
        ImageLoader.getInstance().init(configuration);
        queryIndexData();
        //绑定点击事件
        IndexOnclickListener listener=new IndexOnclickListener();
        ivNewhandGuide.setOnClickListener(listener);
        ivInvite.setOnClickListener(listener);
        ivMessageCenter.setOnClickListener(listener);
        ivSigin.setOnClickListener(listener);
    }

    private void initViews() {
        autoScrollViewPager=getActivity().findViewById(R.id.asvp);
        productTitle=getActivity().findViewById(R.id.productTitle);
        productInterest1=getActivity().findViewById(R.id.productInterest1);
        productInterest2=getActivity().findViewById(R.id.productInterest2);
        productLimit=getActivity().findViewById(R.id.productLimit);
        llDot=getActivity().findViewById(R.id.ll_dot);
        ivNewhandGuide=getActivity().findViewById(R.id.iv_newhandGuide);
        ivInvite=getActivity().findViewById(R.id.iv_invite);
        ivMessageCenter=getActivity().findViewById(R.id.iv_messageCenter);
        ivSigin=getActivity().findViewById(R.id.iv_sigin);
    }

    public void queryIndexData(){
        Activity activity = this.getActivity();//获取该fragment所在的Activity实例
        //TODO 获取bannelList轮播图的加载
        HttpClient.get(activity, Urls.getBannerList(), new BanneAsyncHttpResponseHandler());
        Log.i("FragmentIndex",Urls.getBannerList()+"");
    }
    private class BanneAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
        public void onSuccess(int arg0, String json) {
            super.onSuccess(arg0, json);
            BannerPageAdapter2 bannerPageAdapter = JSON.parseObject(json,BannerPageAdapter2.class);
            //Log.i("FragmentIndex",json);
            DataBean dataBean = bannerPageAdapter.getData();
            bannerList = dataBean.getBannerList();
            product = dataBean.getProduct();
            String productName = product.getProductName();
            double interest = product.getInterest();
            String str=interest+"";
            str.substring(0,str.indexOf("."));
            String maturityDuration = product.getMaturityDuration();
            productTitle.setText(productName);
            productInterest1.setText(str.substring(0,str.indexOf(".")));
            productInterest2.setText(str.substring(str.indexOf("."))+"%");
            productLimit.setText(maturityDuration);
            Log.i("FragmentIndex", bannerList.toString());
            if(bannerList !=null){
                BannerAdapter bannerAdapter = new BannerAdapter(getActivity().getLayoutInflater(), bannerList);
                autoScrollViewPager.setAdapter(bannerAdapter);//利用适配器进行数据的绑定
                autoScrollViewPager.setScrollFactor(bannerList.size());
                autoScrollViewPager.setOffscreenPageLimit(bannerList.size()-1);//缓存4个
                autoScrollViewPager.startAutoScroll(3000);//3秒自动翻转

                //初始化点
                for (int i = 0; i < bannerList.size(); i++){
                    ImageView image =  new ImageView(getActivity());
                    LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    margin.setMargins(6, 0, 0, 0);
                    image.setLayoutParams(new ViewGroup.LayoutParams(2, 2));
                    if (i == 0){
                        //image.setBackgroundResource(R.mipmap.toggle_off);
                        image.setBackgroundResource(R.drawable.viewpager_dot_able);
                    }else{
                        //image.setBackgroundResource(R.mipmap.toggle_on);
                        image.setBackgroundResource(R.drawable.viewpager_dot_enable);
                    }
                    llDot.addView(image, margin);
                }
                //图片切换时改变点的显示效果
                autoScrollViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    public void onPageSelected(int index) {
                        for(int i = 0; i< bannerList.size(); i++){
                            if(index == i){
                                //llDot.getChildAt(i).setBackgroundResource(R.mipmap.toggle_on);
                                llDot.getChildAt(i).setBackgroundResource(R.drawable.viewpager_dot_able);
                            }else{
                                llDot.getChildAt(i).setBackgroundResource(R.drawable.viewpager_dot_enable);
                                //llDot.getChildAt(i).setBackgroundResource(R.mipmap.toggle_off);
                            }
                        }
                    }
                    @Override
                    public void onPageScrollStateChanged(int arg0) {
                    }
                    @Override
                    public void onPageScrolled(int arg0, float arg1, int arg2) {

                    }
                });
                //设置每个图片的点击跳转
                autoScrollViewPager.setOnPageClickListener(new AutoScrollViewPager.OnPageClickListener(){
                    public void onPageClick(AutoScrollViewPager autoScrollPager, int position) {
                        /** 暂时去掉轮播图跳转*/
                        String url = bannerList.get(position).getHtmlURL();//获取跳转链接
                        Intent intent=new Intent(getActivity(), BannerViewActivity.class);
                        intent.putExtra("url",url);
                        startActivity(intent);
                    }
                });
            }
        }
    }
    public class IndexOnclickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_newhandGuide:
                    Intent intent1=new Intent(getActivity(),NewhandGuideActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.iv_invite:
                    Intent intent2=new Intent(getActivity(),InviteAwardActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.iv_messageCenter:
                    Intent intent3=new Intent(getActivity(),MessageCenter.class);
                    startActivity(intent3);
                    break;
                case R.id.iv_sigin:
                    Intent intent4=new Intent(getActivity(),SiginActivity.class);
                    startActivity(intent4);
                    break;
            }
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        autoScrollViewPager.stopAutoScroll();//当页面进入后天时,轮播图停止滚动,这样可以节省手机资源和省电
    }

    @Override
    public void onResume() {
        super.onResume();
        autoScrollViewPager.startAutoScroll(3000);//当页面进入前台时,轮播图继续开始滚动
    }
}
