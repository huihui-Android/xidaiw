package xidaiw.index.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

import xidaiw.index.activity.BannerViewActivity;
import xidaiw.index.activity.InviteAwardActivity;
import xidaiw.index.activity.MessageCenter;
import xidaiw.index.activity.NewhandGuideActivity;
import xidaiw.index.entity.IndexRecommendInfo;
import xidaiw.index.entity.ProductBean;
import xidaiw.licai.activity.LoanDetailActivity;
import xidaiw.licai.bean.LoanPageAdapter;
import xidaiw.util.DensityUtil;
import xidaiw.util.GlobalUtils;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;
import xidaiw.widget.AutoScrollViewPager;
import xidaiw.widget.BannerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentIndex extends Fragment {
    //轮播图和点
    private AutoScrollViewPager autoScrollViewPager;
    private LinearLayout llDot;
    private ProductBean product;
    private static final String TAG="FragmentIndex";
    //推荐标的信息
    private LinearLayout llRecommendBid;
    private TextView productTitle;
    private TextView productLimit;
    private TextView productInterest1;
    private TextView productInterest2;
    //新手指引 邀请有礼 消息中心 签到
    private ImageView ivNewhandGuide;
    private ImageView ivInvite;
    private ImageView ivMessageCenter;
    private ImageView ivSigin;
    private TextView tvNewhandInterest,tvNewhandDuration,tvNewhandRemain;
    private Button btnBuyNow,btnBuyNewhand;
    private TextView tvTransactionAmount,tvUnpayCapital,tvSafeManageDays;
    private List<IndexRecommendInfo.DataBean.BannerListBean> bannerList;

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
        newHandData();
        recommend180Bid();
        //绑定点击事件
        IndexOnclickListener listener=new IndexOnclickListener();
        ivNewhandGuide.setOnClickListener(listener);
        ivInvite.setOnClickListener(listener);
        ivMessageCenter.setOnClickListener(listener);
        ivSigin.setOnClickListener(listener);
        btnBuyNow.setOnClickListener(listener);
    }

    private void recommend180Bid() {
        RequestParams params=new RequestParams();
        params.put("productChannelId","2");
        params.put("pageNow","1");
        params.put("pageSize","20");
        HttpClient.post(getActivity(),Urls.getHost()+"/product/list",params,new RecommendBidResponseHandler());
    }

    private void newHandData() {
        RequestParams params=new RequestParams();
        params.put("productChannelId","2");
        params.put("pageNow","1");
        params.put("pageSize","10");
        HttpClient.post(getActivity(),Urls.getHost()+"/product/list",params,new NewhandAsyncHttpResponse());
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
        tvNewhandDuration=getActivity().findViewById(R.id.tv_newhand_duration);
        tvNewhandInterest=getActivity().findViewById(R.id.tv_newhand_interest);
        tvNewhandRemain=getActivity().findViewById(R.id.tv_newhand_remain);
        btnBuyNow=getActivity().findViewById(R.id.btn_buyNow);
        tvTransactionAmount=getActivity().findViewById(R.id.tv_Transaction_amount);
        tvUnpayCapital=getActivity().findViewById(R.id.tv_unpay_capital);
        tvSafeManageDays=getActivity().findViewById(R.id.tv_safe_manage);
        btnBuyNewhand=getActivity().findViewById(R.id.btn_buy_newhand);
        llRecommendBid=getActivity().findViewById(R.id.ll_recommend_bid);
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
            Log.i("FragmentIndex",json);
            IndexRecommendInfo indexRecommendInfo = JSON.parseObject(json, IndexRecommendInfo.class);
            IndexRecommendInfo.DataBean data = indexRecommendInfo.getData();
            bannerList = data.getBannerList();
            double nowInverstPoint = data.getNowInverstPoint();//待收金额
            int registerStaistices = data.getRegisterStaistices();//交易总额
            int day = data.getDay();//安全运营天数
            tvTransactionAmount.setText(GlobalUtils.NumberFormatTranferTwo(registerStaistices+""));
            tvUnpayCapital.setText(GlobalUtils.NumberFormatTranferTwo(nowInverstPoint+""));
            tvSafeManageDays.setText(day+"天");
            if(bannerList !=null){
                BannerAdapter bannerAdapter = new BannerAdapter(getActivity().getLayoutInflater(), FragmentIndex.this.bannerList);
                autoScrollViewPager.setAdapter(bannerAdapter);//利用适配器进行数据的绑定
                autoScrollViewPager.setScrollFactor(FragmentIndex.this.bannerList.size());
                autoScrollViewPager.setOffscreenPageLimit(FragmentIndex.this.bannerList.size()-1);//缓存4个
                autoScrollViewPager.startAutoScroll(3000);//3秒自动翻转
                //初始化点
                for (int i = 0; i < FragmentIndex.this.bannerList.size(); i++){
                    ImageView image =  new ImageView(getActivity());
                    LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    margin.setMargins(DensityUtil.dip2px(getActivity(),5), 0, 0, 0);
                    image.setLayoutParams(new ViewGroup.LayoutParams(2, 2));
                    if (i == 0){
                        image.setBackgroundResource(R.drawable.viewpager_dot_able);
                    }else{
                        image.setBackgroundResource(R.drawable.viewpager_dot_enable);
                    }
                    llDot.addView(image, margin);
                }
                //图片切换时改变点的显示效果
                autoScrollViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    public void onPageSelected(int index) {
                        for(int i = 0; i< FragmentIndex.this.bannerList.size(); i++){
                            if(index == i){
                                llDot.getChildAt(i).setBackgroundResource(R.drawable.viewpager_dot_able);
                            }else{
                                llDot.getChildAt(i).setBackgroundResource(R.drawable.viewpager_dot_enable);
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
                        String url = FragmentIndex.this.bannerList.get(position).getHtmlURL();//获取跳转链接
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
                    AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
                    dialog.setMessage("暂未开通...");
                    dialog.setPositiveButton("确定",null);
                    dialog.show();
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

    private class NewhandAsyncHttpResponse extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "onSuccess:新手标信息===== "+s);
            LoanPageAdapter loanPageAdapter = JSON.parseObject(s, LoanPageAdapter.class);
            if (loanPageAdapter.isSuccess()){
                LoanPageAdapter.DataBean data = loanPageAdapter.getData();
                final ArrayList<LoanPageAdapter.DataBean.ListBean> list = data.getList();
                for (int j = 0; j <list.size(); j++) {
                    if ("短期体验产品".equals(list.get(j).getProductTypeName()) && list.get(j).getRemainingAmount()>0){
                        tvNewhandInterest.setText(GlobalUtils.NumberFormatTranferTwo(list.get(j).getInterest()+""));
                        tvNewhandDuration.setText(list.get(j).getMaturityDuration());
                        tvNewhandRemain.setText("剩余"+ GlobalUtils.NumberFormatTransfer(list.get(j).getRemainingAmount()*100+"")+"元");
                        final int id=j;
                        btnBuyNewhand.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent=new Intent(getActivity(), LoanDetailActivity.class);
                                intent.putExtra("productId",list.get(id).getId()+"");
                                startActivity(intent);
                            }
                        });
                        break;
                    }
                }
            }
        }
    }

    private class RecommendBidResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.d(TAG, "onSuccess: "+s);
            LoanPageAdapter loanPageAdapter = JSON.parseObject(s, LoanPageAdapter.class);
            if (loanPageAdapter.isSuccess()){
                final List<LoanPageAdapter.DataBean.List1Bean> list1 = loanPageAdapter.getData().getList1();
                for (int j=0;j<=15;j++){
                    if(list1.get(j).getMaturityDuration().equals("180天")&&list1.get(j).getProductStatus().equals("SALES")){
                        llRecommendBid.setVisibility(View.VISIBLE);
                        final int id=j;
                        productTitle.setText(list1.get(j).getProductName());
                        productLimit.setText(list1.get(j).getMaturityDuration());
                        String interest = list1.get(j).getInterest() + "";
                        if (interest.indexOf(".")!=-1){
                            productInterest1.setText(interest.substring(0,interest.indexOf(".")));
                            productInterest2.setText(interest.substring(interest.indexOf("."))+"%");
                        }else {
                            productInterest1.setText(interest);
                            productInterest2.setText("%");
                        }
                        btnBuyNow.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent=new Intent(getActivity(),LoanDetailActivity.class);
                                intent.putExtra("productId",list1.get(id).getId()+"");
                                startActivity(intent);
                            }
                        });
                        return;
                    }
                }
            }

        }
    }
}
