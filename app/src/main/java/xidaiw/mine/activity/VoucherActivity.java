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
import android.widget.TextView;

import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

import xidaiw.mine.frag.VoucherUsableFragment;
import xidaiw.mine.frag.VoucherUsedFragment;

public class VoucherActivity extends AppCompatActivity {

    private VoucherUsableFragment voucherUsableFragment;
    private VoucherUsedFragment voucherUsedFragment;
    private List<Fragment> frameList;
    private TextView tvUsable,tvUsed;
    private ViewPager vp;
    private ImageView ivBack;
    private static final String TAG = "VoucherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        initViews();
        bindViews();
        voucherUsableFragment = new VoucherUsableFragment();
        voucherUsedFragment = new VoucherUsedFragment();
        frameList =new ArrayList<>();
        frameList.add(voucherUsableFragment);
        frameList.add(voucherUsedFragment);
        vp.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        tvUsable.setTextColor(Color.WHITE);
                        tvUsed.setTextColor(Color.parseColor("#eb5c62"));
                        tvUsable.setBackgroundResource(R.drawable.header_button_text_red_bg1);
                        tvUsed.setBackgroundResource(R.drawable.header_button_text_white_bg2);
                        break;
                    case 1:
                        tvUsed.setTextColor(Color.WHITE);
                        tvUsable.setTextColor(Color.parseColor("#eb5c62"));
                        tvUsed.setBackgroundResource(R.drawable.header_button_text_red_bg2);
                        tvUsable.setBackgroundResource(R.drawable.header_button_text_white_bg1);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void bindViews() {
        MyOnclickListener listener=new MyOnclickListener();
        ivBack.setOnClickListener(listener);
        tvUsable.setOnClickListener(listener);
        tvUsed.setOnClickListener(listener);
    }

    private void initViews() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvUsable= (TextView) findViewById(R.id.tv_usable);
        tvUsed= (TextView) findViewById(R.id.tv_used);
        vp= (ViewPager) findViewById(R.id.vp);
    }
    private class MyOnclickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.tv_usable:
                    tvUsable.setTextColor(Color.WHITE);
                    tvUsed.setTextColor(Color.parseColor("#eb5c62"));
                    tvUsable.setBackgroundResource(R.drawable.header_button_text_red_bg1);
                    tvUsed.setBackgroundResource(R.drawable.header_button_text_white_bg2);
                    vp.setCurrentItem(0);
                    break;
                case R.id.tv_used:
                    tvUsed.setTextColor(Color.WHITE);
                    tvUsable.setTextColor(Color.parseColor("#eb5c62"));
                    tvUsed.setBackgroundResource(R.drawable.header_button_text_red_bg2);
                    tvUsable.setBackgroundResource(R.drawable.header_button_text_white_bg1);
                    vp.setCurrentItem(1);
                    break;
            }
        }
    }
    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

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
