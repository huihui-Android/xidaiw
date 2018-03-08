package xidaiw.mine.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

import xidaiw.mine.entity.InvestRecordGoingInfo;
import xidaiw.mine.frag.InvestRecordGoingFragment;
import xidaiw.mine.frag.InvestRecordGoneFragment;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

public class InvestRecordActivity extends AppCompatActivity {
    private ImageView ivBack;
    private TextView tvGoing,tvGone,tvDhk,tvCapital,tvInterests;
    private ViewPager vp;
    private List<Fragment> frameList;
    private static final String TAG = "InvestRecordActivity";
    private double dhk=0.00,capital=0.00,interest=0.00;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest_record);
        initViews();
        bindViews();
        frameList=new ArrayList<>();
        frameList.add(new InvestRecordGoingFragment());
        frameList.add(new InvestRecordGoneFragment());
        vp.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        tvGoing.setTextColor(Color.parseColor("#eb5c62"));
                        tvGone.setTextColor(Color.parseColor("#a0a0a0"));
                        break;
                    case 1:
                        tvGoing.setTextColor(Color.parseColor("#a0a0a0"));
                        tvGone.setTextColor(Color.parseColor("#eb5c62"));
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        HttpClient.get(this, Urls.getHost()+"/mycurrPlan1?showNav=0",new InvestRecordGoingResponseHanlder());
    }

    private void bindViews() {
        MyOnclickListener listener=new MyOnclickListener();
        ivBack.setOnClickListener(listener);
        tvGoing.setOnClickListener(listener);
        tvGone.setOnClickListener(listener);
    }

    private void initViews() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvGoing= (TextView) findViewById(R.id.tv_going);
        tvGone= (TextView) findViewById(R.id.tv_gone);
        tvDhk= (TextView) findViewById(R.id.tv_dhk);
        tvCapital= (TextView) findViewById(R.id.tv_capital);
        tvInterests= (TextView) findViewById(R.id.tv_interests);
        vp= (ViewPager) findViewById(R.id.vp);
    }
    private class MyOnclickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.tv_going:
                    tvGoing.setTextColor(Color.parseColor("#eb5c62"));
                    tvGone.setTextColor(Color.parseColor("#a0a0a0"));
                    vp.setCurrentItem(0);
                    break;
                case R.id.tv_gone:
                    tvGoing.setTextColor(Color.parseColor("#a0a0a0"));
                    tvGone.setTextColor(Color.parseColor("#eb5c62"));
                    vp.setCurrentItem(1);
                    break;
            }
        }
    }
    private class MyFragmentPagerAdapter extends FragmentPagerAdapter{

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return frameList.get(position);
        }

        @Override
        public int getCount() {
            return frameList.size();
        }
    }

    private class InvestRecordGoingResponseHanlder extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int j, String s) {
            super.onSuccess(j, s);
            Log.i(TAG, "onSuccess: "+s);
            InvestRecordGoingInfo investRecordGoingInfo = JSON.parseObject(s, InvestRecordGoingInfo.class);
            if (investRecordGoingInfo.isSuccess()){
                if (investRecordGoingInfo==null){
                    tvDhk.setText("0");
                    tvInterests.setText("0");
                    tvCapital.setText("0");
                }else{
                    List<InvestRecordGoingInfo.DataBean.ProductAccountListBean> list = investRecordGoingInfo.getData().getProductAccountList();
                    for (int i=0;i<list.size();i++){
                        capital+=list.get(i).getTotalBuyAmount();
                        if (list.get(i).getRemainingDay()>=0){
                            interest+=list.get(i).getTodayTotalEarnings()*(Math.ceil(list.get(i).getTotalEarnings()/list.get(i).getTodayTotalEarnings()+list.get(i).getRemainingDay()));
                        }
                    }
                    dhk=capital+interest;
                    tvDhk.setText(dhk+"");
                    tvInterests.setText(interest+"");
                    tvCapital.setText(capital+"");
                }
            }
        }
    }
}
