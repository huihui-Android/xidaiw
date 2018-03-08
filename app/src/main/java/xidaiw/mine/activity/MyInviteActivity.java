package xidaiw.mine.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

import xidaiw.mine.frag.InviteYtzFragment;
import xidaiw.mine.frag.InviteYzcFragment;

public class MyInviteActivity extends AppCompatActivity {
    private ImageView ivBack,ivYzc,ivYtz;
    private TextView tvYzc,tvYtz,tvHeader;
    private RelativeLayout rlYzc,rlYtz;
    private ViewPager vp;
    private List<Fragment> frameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_invite);
        initView();
        tvHeader.setText("我的邀请");
        bindView();
        frameList=new ArrayList<>(2);
        frameList.add(new InviteYzcFragment());
        frameList.add(new InviteYtzFragment());
        vp.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
        vp.setOffscreenPageLimit(0);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        showYzc();
                        break;
                    case 1:
                        showYtz();
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

    private void bindView() {
        MyOnclickListener listener=new MyOnclickListener();
        ivBack.setOnClickListener(listener);
        rlYzc.setOnClickListener(listener);
        rlYtz.setOnClickListener(listener);
    }

    private void initView() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        ivYtz= (ImageView) findViewById(R.id.iv_ytz);
        ivYzc= (ImageView) findViewById(R.id.iv_yzc);
        tvYtz= (TextView) findViewById(R.id.tv_ytz);
        tvYzc= (TextView) findViewById(R.id.tv_yzc);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        rlYtz= (RelativeLayout) findViewById(R.id.rl_ytz);
        rlYzc= (RelativeLayout) findViewById(R.id.rl_yzc);
        vp= (ViewPager) findViewById(R.id.vp);
    }
    private class MyOnclickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.rl_ytz:
                    showYtz();
                    vp.setCurrentItem(1);
                    break;
                case R.id.rl_yzc:
                    showYzc();
                    vp.setCurrentItem(0);
                    break;
            }
        }
    }
    private void showYtz(){
        tvYtz.setTextColor(Color.parseColor("#eb5c62"));
        tvYzc.setTextColor(Color.parseColor("#898989"));
        ivYtz.setVisibility(View.VISIBLE);
        ivYzc.setVisibility(View.INVISIBLE);
    }
    private void showYzc(){
        tvYzc.setTextColor(Color.parseColor("#eb5c62"));
        tvYtz.setTextColor(Color.parseColor("#898989"));
        ivYzc.setVisibility(View.VISIBLE);
        ivYtz.setVisibility(View.INVISIBLE);
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
}
