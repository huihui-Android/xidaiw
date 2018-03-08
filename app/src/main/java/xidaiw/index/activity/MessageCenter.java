package xidaiw.index.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

import xidaiw.index.frag.MessageCenterFragment1;
import xidaiw.index.frag.MessageCenterFragment2;

public class MessageCenter extends AppCompatActivity {
    private List<Fragment> list=null;
    private ViewPager container;
    private TextView tvHeader,tvMessage1,tvMessage2;
    private ImageView ivBack,ivMessage1,ivMessage2;
    private LinearLayout llMessage1,llMessage2;
    private MyOnclickListener listener;
    private MessageCenterFragment1 messageCenterFragment1;
    private MessageCenterFragment2 messageCenterFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_message_center);
        initViews();
        tvHeader.setText("消息中心");
        listener = new MyOnclickListener();
        bindEvents();
        messageCenterFragment1 = new MessageCenterFragment1();
        messageCenterFragment2 = new MessageCenterFragment2();
        list=new ArrayList<>(2);
        list.add(messageCenterFragment1);
        list.add(messageCenterFragment2);
        container.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        container.setCurrentItem(0);
        container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch(position){
                    case 0:
                        showMessage1();
                        break;
                    case 1:
                        showMessage2();
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void bindEvents() {
        ivBack.setOnClickListener(listener);
        llMessage1.setOnClickListener(listener);
        llMessage2.setOnClickListener(listener);
    }

    private void initViews() {
        container = (ViewPager) findViewById(R.id.vp_container);
        tvHeader = (TextView) findViewById(R.id.tv_header);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        llMessage1= (LinearLayout) findViewById(R.id.ll_message1);
        llMessage2= (LinearLayout) findViewById(R.id.ll_message2);
        tvMessage1= (TextView) findViewById(R.id.tv_message1);
        tvMessage2= (TextView) findViewById(R.id.tv_message2);
        ivMessage1= (ImageView) findViewById(R.id.iv_message1);
        ivMessage2= (ImageView) findViewById(R.id.iv_message2);
    }
    private class MyOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.ll_message1:
                    showMessage1();
                    container.setCurrentItem(0);
                    break;
                case R.id.ll_message2:
                    container.setCurrentItem(1);
                    showMessage2();
                    break;
            }
        }
    }

    private void showMessage1() {
        tvMessage1.setTextColor(Color.parseColor("#eb5c62"));
        ivMessage1.setVisibility(View.VISIBLE);
        tvMessage2.setTextColor(Color.parseColor("#707070"));
        ivMessage2.setVisibility(View.INVISIBLE);
    }
    private void showMessage2() {
        tvMessage2.setTextColor(Color.parseColor("#eb5c62"));
        ivMessage2.setVisibility(View.VISIBLE);
        tvMessage1.setTextColor(Color.parseColor("#707070"));
        ivMessage1.setVisibility(View.INVISIBLE);
    }
    public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
