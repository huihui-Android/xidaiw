package xidaiw.index.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

import xidaiw.index.frag.AwardFragment1;
import xidaiw.index.frag.AwardFragment2;
import xidaiw.index.frag.AwardFragment3;

public class AwardDetailActivity extends FragmentActivity implements View.OnClickListener{
    private int item;
    private TextView tvTitle;
    private ImageView ivBack;
    private FrameLayout flAwardContainer;
    private ViewPager vp;
    private ImageView ivInviteToLeft;
    private ImageView ivInviteToRight;
    //用list存放三个fragment页面
    private List<Fragment> list;
    //找到三个fragment页面
    private AwardFragment1 awardFragment1;
    private AwardFragment2 awardFragment2;
    private AwardFragment3 awardFragment3;
    private int currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_award_detail);
        tvTitle=findViewById(R.id.tv_header);
        vp=findViewById(R.id.vp_award_detail);
        ivInviteToLeft=findViewById(R.id.invite_to_left);
        ivInviteToRight=findViewById(R.id.invite_to_right);
        ivBack=findViewById(R.id.iv_back);
        tvTitle.setText("邀请有礼");
        ivBack.setImageResource(R.mipmap.back_left);
        list=new ArrayList<Fragment>(3);
        //实例化三个fragment页面
        awardFragment1=new AwardFragment1();
        awardFragment2=new AwardFragment2();
        awardFragment3=new AwardFragment3();
        list.add(awardFragment1);
        list.add(awardFragment2);
        list.add(awardFragment3);
        //viewpager全部预加载
        vp.setOffscreenPageLimit(2);//缓存两个页面
        //将三个fragment中的数据绑定到viewPage容器
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            public Fragment getItem(int position) {
                return list.get(position);
            }
            public int getCount() {
                return list==null?0:list.size();
            }
        });
        //给两个ivInviteToLeft和ivInviteToRight设置动画
        //给ivInviteToLeft添加动画
        ObjectAnimator animatorLeft = ObjectAnimator.ofFloat(ivInviteToLeft, "translationX", 0, 5);
        animatorLeft.setDuration(800);
        animatorLeft.setRepeatCount(ObjectAnimator.INFINITE);
        animatorLeft.setRepeatMode(ObjectAnimator.RESTART);
        animatorLeft.start();
        //给ivInviteToRight添加动画
        ObjectAnimator animatorRight = ObjectAnimator.ofFloat(ivInviteToRight, "translationX", 5, 0);
        animatorRight.setDuration(800);
        animatorRight.setRepeatCount(ObjectAnimator.INFINITE);
        animatorRight.setRepeatMode(ObjectAnimator.RESTART);
        animatorRight.start();
        //通过Intent传值确定调到对应的viewPager的相应页面
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("awardExtra",0);
        vp.setCurrentItem(intExtra);
        currentItem = vp.getCurrentItem();
        item=currentItem;
        if (currentItem==0){
            ivInviteToLeft.setVisibility(View.INVISIBLE);
        }
        if (currentItem==2){
            ivInviteToRight.setVisibility(View.INVISIBLE);
        }
        ivBack.setOnClickListener(this);
        ivInviteToLeft.setOnClickListener(this);
        ivInviteToRight.setOnClickListener(this);
        //给vp设置监听,根据页面的切换控制左右箭头的显示与否
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    ivInviteToRight.setVisibility(View.VISIBLE);
                    ivInviteToLeft.setVisibility(View.INVISIBLE);
                }else if (position==1){
                    ivInviteToRight.setVisibility(View.VISIBLE);
                    ivInviteToLeft.setVisibility(View.VISIBLE);
                }else if (position==2){
                    ivInviteToRight.setVisibility(View.INVISIBLE);
                    ivInviteToLeft.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.invite_to_left:
                --item;
                if (item<=0){
                    vp.setCurrentItem(0);
                    ivInviteToRight.setVisibility(View.VISIBLE);
                    ivInviteToLeft.setVisibility(View.INVISIBLE);
                }else if (item==1){
                    vp.setCurrentItem(1);
                    ivInviteToRight.setVisibility(View.VISIBLE);
                    ivInviteToLeft.setVisibility(View.VISIBLE);
                }else if (item==2){
                    vp.setCurrentItem(2);
                    ivInviteToRight.setVisibility(View.INVISIBLE);
                    ivInviteToLeft.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.invite_to_right:
                ++item;
                if (item==0){
                    vp.setCurrentItem(0);
                    ivInviteToRight.setVisibility(View.VISIBLE);
                    ivInviteToLeft.setVisibility(View.INVISIBLE);
                }else if (item==1){
                    vp.setCurrentItem(1);
                    ivInviteToRight.setVisibility(View.VISIBLE);
                    ivInviteToLeft.setVisibility(View.VISIBLE);
                }else if (item==2){
                    vp.setCurrentItem(2);
                    ivInviteToRight.setVisibility(View.INVISIBLE);
                    ivInviteToLeft.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
