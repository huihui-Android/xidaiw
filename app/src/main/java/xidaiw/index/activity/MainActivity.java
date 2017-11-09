package xidaiw.index.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.xidaiw.btj.R;

import java.io.IOException;

import xidaiw.index.fragment.FragmentFind;
import xidaiw.index.fragment.FragmentIndex;
import xidaiw.index.fragment.FragmentLoans;
import xidaiw.index.fragment.FragmentMine;
import xidaiw.mine.activity.LoginActivity;
import xidaiw.util.GlobalUtils;
import xidaiw.util.Urls;

public class MainActivity extends SlidingFragmentActivity implements View.OnClickListener{
    //frame容
    private FrameLayout fl_container;
    //底部四个线性布局
    private LinearLayout ll_index;
    private LinearLayout ll_licai;
    private LinearLayout ll_account;
    private LinearLayout ll_more;
   //底部四个文字
    private TextView tv_index;
    private TextView tv_licai;
    private TextView tv_account;
    private TextView tv_more;
    //底部四个图片
    private ImageView iv_index;
    private ImageView iv_licai;
    private ImageView iv_account;
    private ImageView iv_more;
    //四个来回切换的fragement
    private FragmentIndex indexFragment;
    private FragmentLoans loansFragment;
    private FragmentMine mineFragment;
    private FragmentFind findFragment;
    private String fileName;
    private String key;
    //侧滑菜单的布局的控件
    private RelativeLayout rlHelp;
    private RelativeLayout rlYjfk;
    private RelativeLayout rlAboutUS;
    private RelativeLayout rlCache;
    private RelativeLayout rlHead;
    private com.jeremyfeinstein.slidingmenu.lib.SlidingMenu menu;
    private TextView tvLogout;//安全退出
    //打开侧滑的头
    private ImageView ivAvanty;
    private TextView tvPhone;
    private ImageView ivHelp;
    //广播接收器
    private SlideMenuReceiver receiver;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setBehindContentView(R.layout.sliding_menu);
        setContentView(R.layout.activity_main);
        //状态栏沉浸
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //初始化views
        initView();
        //创建四个fragment实例
        createFrames();
        //进入APP首先加载indexFragment页面
        initMenu();
        //底部导航的点击事件
        ll_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIndexFragment();
            }
        });
        ll_licai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLoansFragment();
            }
        });
        ll_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMineFragment();
            }
        });
        ll_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFindFragment();
            }
        });
        //侧滑里面的点击事件
        rlHelp.setOnClickListener(this);
        rlYjfk.setOnClickListener(this);
        rlAboutUS.setOnClickListener(this);
        rlCache.setOnClickListener(this);
        tvLogout.setOnClickListener(this);


        setIndexFragment();
        try {
            Urls.parse(this.getAssets().open("urls.xml"));//解析urls.xml中的配置信息
        } catch (IOException e) {
            e.printStackTrace();
        }
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.xidaiw.SlideMenuToggle");
        receiver=new SlideMenuReceiver();
        registerReceiver(receiver,filter);
    }

    private void initMenu() {
        menu = getSlidingMenu();
        menu.setMode(com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.LEFT);
        menu.setShadowWidthRes(R.dimen.activity_horizontal_margin);
        menu.setTouchModeAbove(com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowDrawable(R.drawable.sliding_menu_bg);
        menu.setBehindOffsetRes(R.dimen.slideMenu);
        menu.setFadeDegree(0.35f);
    }

    //切换到更多页面
    private void setFindFragment() {
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (!findFragment.isAdded()){
            transaction.add(R.id.container,findFragment);
            transaction.show(findFragment).hide(indexFragment).hide(mineFragment).hide(loansFragment);
        }else{
            transaction.show(findFragment).hide(indexFragment).hide(mineFragment).hide(loansFragment);
        }
        transaction.commit();
        fragmentShowState(false,false,false,true);
        tv_index.setTextColor(getResources().getColor(R.color.footer_able));
        tv_licai.setTextColor(getResources().getColor(R.color.footer_able));
        tv_account.setTextColor(getResources().getColor(R.color.footer_able));
        tv_more.setTextColor(getResources().getColor(R.color.primary));
    }
//切换到我的账户页面
    private void setMineFragment() {

        menu.setTouchModeAbove(com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.TOUCHMODE_FULLSCREEN);
        SharedPreferences sp  = getSharedPreferences("data", MODE_PRIVATE);
        String mobile = sp.getString("mobile", "");
        if(mobile==""){
            Intent intent=new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else{
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (!mineFragment.isAdded()){
            transaction.add(R.id.container,mineFragment);
            transaction.show(mineFragment).hide(indexFragment).hide(loansFragment).hide(findFragment);
        }else{
            transaction.show(mineFragment).hide(indexFragment).hide(loansFragment).hide(findFragment);
        }
        transaction.commit();
        fragmentShowState(false,false,true,false);
        tv_index.setTextColor(getResources().getColor(R.color.footer_able));
        tv_licai.setTextColor(getResources().getColor(R.color.footer_able));
        tv_account.setTextColor(getResources().getColor(R.color.primary));
        tv_more.setTextColor(getResources().getColor(R.color.footer_able));
        }
    }
//切换到理财页面
    private void setLoansFragment() {

        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (!loansFragment.isAdded()){
            transaction.add(R.id.container,loansFragment);
            transaction.show(loansFragment).hide(indexFragment).hide(mineFragment).hide(findFragment);
        }else{
            transaction.show(loansFragment).hide(indexFragment).hide(mineFragment).hide(findFragment);
        }
        transaction.commit();
        fragmentShowState(false,true,false,false);
        tv_index.setTextColor(getResources().getColor(R.color.footer_able));
        tv_licai.setTextColor(getResources().getColor(R.color.primary));
        tv_account.setTextColor(getResources().getColor(R.color.footer_able));
        tv_more.setTextColor(getResources().getColor(R.color.footer_able));
    }
//切换到首页
    private void setIndexFragment() {

        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (!indexFragment.isAdded()){
            transaction.add(R.id.container,indexFragment);
            transaction.show(indexFragment).hide(loansFragment).hide(findFragment).hide(mineFragment);
        }else {
            transaction.show(indexFragment).hide(loansFragment).hide(findFragment).hide(mineFragment);
        }
        transaction.commit();
        fragmentShowState(true,false,false,false);
        tv_index.setTextColor(getResources().getColor(R.color.primary));
        tv_licai.setTextColor(getResources().getColor(R.color.footer_able));
        tv_account.setTextColor(getResources().getColor(R.color.footer_able));
        tv_more.setTextColor(getResources().getColor(R.color.footer_able));
    }

    private void createFrames() {
        indexFragment=new FragmentIndex();
        loansFragment=new FragmentLoans();
        mineFragment=new FragmentMine();
        findFragment=new FragmentFind();
    }

    private void initView() {
        fl_container= (FrameLayout) findViewById(R.id.container);
        ll_index= (LinearLayout) findViewById(R.id.ll_index);
        ll_licai= (LinearLayout) findViewById(R.id.ll_licai);
        ll_account= (LinearLayout) findViewById(R.id.ll_account);
        ll_more= (LinearLayout) findViewById(R.id.ll_more);
        tv_index= (TextView) findViewById(R.id.tv_index);
        tv_account= (TextView) findViewById(R.id.tv_accout);
        tv_licai= (TextView) findViewById(R.id.tv_licai);
        tv_more= (TextView) findViewById(R.id.tv_more);
        iv_index= (ImageView) findViewById(R.id.iv_index);
        iv_licai= (ImageView) findViewById(R.id.iv_licai);
        iv_account= (ImageView) findViewById(R.id.iv_account);
        iv_more= (ImageView) findViewById(R.id.iv_more);
        tvLogout= (TextView) findViewById(R.id.tv_logout);
        rlAboutUS= (RelativeLayout) findViewById(R.id.rl_aboutus);
        rlHelp= (RelativeLayout) findViewById(R.id.rl_help);
        rlCache= (RelativeLayout) findViewById(R.id.rl_clearcache);
        rlYjfk= (RelativeLayout) findViewById(R.id.rl_yjfk);//意见反馈

    }
    private void fragmentShowState(boolean index,boolean loans,boolean account,boolean more){
        iv_index.setEnabled(index);
        iv_licai.setEnabled(loans);
        iv_account.setEnabled(account);
        iv_more.setEnabled(more);
    }
    //双击回退键退出APP程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            GlobalUtils.exitBy2Click(MainActivity.this);
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_logout:
                SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("mobile","");
                editor.commit();
                Toast.makeText(this,"我是安全退出",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_avanty:
                menu.toggle();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    class SlideMenuReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            menu.setMode(com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.LEFT);
            menu.toggle();
        }
    }
}
