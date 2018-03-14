package xidaiw.index.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import java.util.List;

import xidaiw.mine.activity.BindBankCardActivity;
import xidaiw.mine.activity.CertificationActivity;
import xidaiw.mine.activity.InviteFriendsActivity;
import xidaiw.mine.activity.LoginActivity;
import xidaiw.mine.activity.LookDetailActivity;
import xidaiw.mine.activity.MyAwardActivity;
import xidaiw.mine.activity.MyInvestActivity;
import xidaiw.mine.activity.RechargeActivity;
import xidaiw.mine.activity.SafeCenterActivity;
import xidaiw.mine.activity.WithdrawActivity;
import xidaiw.mine.entity.BankInfo;
import xidaiw.mine.entity.PersonInfo;
import xidaiw.util.DensityUtil;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

import static xidaiw.util.GlobalUtils.NumberFormatTranferTwo;
import static xidaiw.util.GlobalUtils.moneyWithDouble;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMine extends Fragment{
    //账户页面的控件
    private ImageView ivHelp;
    private ImageView ivAvanta;
    private TextView tvYesterdEarn1;
    private TextView tvYesterdayEarn2;
    private TextView tvAvailablBalance;
    private TextView tvTotalBalance;
    private TextView tvDetail;
    private TextView tvPhone;
    private Button btnWithDraw;
    private Button btnRecharge;
    private LinearLayout llMyjl;
    private LinearLayout llAutoBid;
    private LinearLayout llMysafety;
    private LinearLayout llMyInvite;
    private RelativeLayout rlLogin;
    private Button btnLogin;
    private static final String TAG = "FragmentMine";
    private RefreshDataReceiver refreshDataReceiver;
    private Onclicks onclicks;
    private ScrollView sv_mine;
    private LogoutRefreshReceiver logoutReceiver;
    private PersonInfo.DataBean.CustomerAccountBean customerAccount;
    private List<BankInfo.DataBean.ListBean> bankList;

    public FragmentMine() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        onclicks = new Onclicks();
        btnLogin.setOnClickListener(onclicks);
        requestData();
        IntentFilter filter=new IntentFilter();
        filter.addAction("LoginSuccess");
        filter.addAction("withdrawSuccess");
        refreshDataReceiver = new RefreshDataReceiver();
        getActivity().registerReceiver(refreshDataReceiver,filter);
        IntentFilter filter1=new IntentFilter();
        filter1.addAction("logout");
        logoutReceiver = new LogoutRefreshReceiver();
        getActivity().registerReceiver(logoutReceiver,filter1);
    }

    public class RefreshDataReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            requestData();
        }
    }
    public void requestData(){
        HttpClient.get(getActivity(), Urls.getHost()+"/account/indexNew", new PersonAsyncHttpResponseHandler() );
    }
    private void initViews() {
        //content里面的viewgroup
        ivAvanta=getActivity().findViewById(R.id.iv_avanty);
        ivHelp=getActivity().findViewById(R.id.iv_help);
        tvPhone=getActivity().findViewById(R.id.tv_phone);
        tvYesterdEarn1=getActivity().findViewById(R.id.tv_yesterdayEarn1);
        tvYesterdayEarn2=getActivity().findViewById(R.id.tv_yesterdayEarn2);
        tvAvailablBalance=getActivity().findViewById(R.id.tv_availableBalance);
        tvTotalBalance=getActivity().findViewById(R.id.tv_totalBalance);
        tvDetail=getActivity().findViewById(R.id.tv_detail);
        btnWithDraw=getActivity().findViewById(R.id.btn_widthdraw);
        btnRecharge=getActivity().findViewById(R.id.btn_recharge);
        llMyjl=getActivity().findViewById(R.id.ll_myjl);
        llAutoBid=getActivity().findViewById(R.id.ll_autobid);
        llMysafety=getActivity().findViewById(R.id.ll_safety);
        llMyInvite=getActivity().findViewById(R.id.ll_myinvit);
        btnLogin=getActivity().findViewById(R.id.btn_login);
        rlLogin=getActivity().findViewById(R.id.rlLogin);
        sv_mine=getActivity().findViewById(R.id.sv_mine);
    }
    private class PersonAsyncHttpResponseHandler extends AsyncHttpResponseHandler{
        @Override
        public void onSuccess(int i, String json) {
            super.onSuccess(i, json);
            Log.i(TAG, "onSuccess: "+json);
            PersonInfo personInfo = JSON.parseObject(json, PersonInfo.class);
            if(personInfo.isSuccess()){
                rlLogin.setVisibility(View.GONE);
                ivAvanta.setOnClickListener(onclicks);
                tvPhone.setOnClickListener(onclicks);
                ivHelp.setOnClickListener(onclicks);
                tvDetail.setOnClickListener(onclicks);
                btnRecharge.setOnClickListener(onclicks);
                btnWithDraw.setOnClickListener(onclicks);
                llMyjl.setOnClickListener(onclicks);
                llAutoBid.setOnClickListener(onclicks);
                llMysafety.setOnClickListener(onclicks);
                llMyInvite.setOnClickListener(onclicks);
                PersonInfo.DataBean dataBean = personInfo.getData();
                customerAccount = dataBean.getCustomerAccount();
                String mobile = customerAccount.getMobile();
                tvPhone.setText(Html.fromHtml(mobile.substring(0,8)+"...<br/> <font color=\"#707070\">安全退出 ></font>"));
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(95, 0, 0, 0);
                tvPhone.setLayoutParams(lp);
                if (customerAccount.getTodayTotalEarnings().equals("0")){
                    tvYesterdEarn1.setText("0");
                    tvYesterdayEarn2.setText(".00");
                }else{
                    Double yesterdayEarn=Double.parseDouble(customerAccount.getTodayTotalEarnings());
                    tvYesterdEarn1.setText(moneyWithDouble(yesterdayEarn));
                    tvYesterdayEarn2.setText(moneyWithDouble(yesterdayEarn));
                }
                tvTotalBalance.setText(NumberFormatTranferTwo(customerAccount.getTotalAssets()+""));
                tvAvailablBalance.setText(NumberFormatTranferTwo(customerAccount.getTotalAvailable()));
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("mobile", customerAccount.getMobile());
                editor.putInt("availableScore", customerAccount.getAvailableScore());
                editor.putString("fullIdCardStr", customerAccount.getFullIdCardStr());
                editor.putBoolean("hasPayPwd", customerAccount.isHasPayPwd());
                editor.putBoolean("realNameAuthed", customerAccount.isRealNameAuthed());
                editor.putString("todayTotalEarnings", customerAccount.getTodayTotalEarnings()+"");
                editor.putString("totalAssets", customerAccount.getTotalAssets()+"");
                editor.putString("totalAvailable", customerAccount.getTotalAvailable());
                editor.putString("totalEarnings", customerAccount.getTotalEarnings()+"");
                editor.putString("totalFreezen", customerAccount.getTotalFreezen()+"");
                editor.commit();
                requestBankData();
            }else{
                sv_mine.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return true;
                    }
                });
                rlLogin.setVisibility(View.VISIBLE);
                tvPhone.setText("立即登录 >");
                tvTotalBalance.setText("0.00");
                tvAvailablBalance.setText("0.00");
                tvYesterdEarn1.setText("0");
                tvYesterdayEarn2.setText(".00");
                Log.i(TAG, "我是未登录的状态");
                btnLogin.setClickable(true);
                btnLogin.setOnClickListener(onclicks);
            }
        }
    }

    private void requestBankData() {
        HttpClient.get(getActivity(),Urls.getHost()+"/userBankCard/listByChannelId?productChannelId=2",new BankInfoAsyncResponseHandler());
    }

    private class Onclicks implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_avanty:
                case R.id.tv_phone:
                    //发送广播通知MainActivity打开侧滑菜单
                    Intent intent1 =new Intent("com.xidaiw.SlideMenuToggle");
                    getActivity().sendBroadcast(intent1);
                    break;
                case R.id.iv_help:
                    Toast.makeText(getActivity(),"帮助",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tv_detail:
                    Intent lookDetail=new Intent(getActivity(),LookDetailActivity.class);
                    startActivity(lookDetail);
                    break;
                case R.id.btn_widthdraw:
                    if (customerAccount.isRealNameAuthed()){
                        if (bankList.size()>0){
                            Intent withDraw=new Intent(getActivity(),WithdrawActivity.class);
                            startActivity(withDraw);
                        }else {
                            Intent bindCard=new Intent(getActivity(),BindBankCardActivity.class);
                            startActivity(bindCard);
                        }
                    }else{
                        Intent certificate=new Intent(getActivity(),CertificationActivity.class);
                        startActivity(certificate);
                    }


                    break;
                case R.id.btn_recharge:
                    if (customerAccount.isRealNameAuthed()){
                        if (bankList.size()>0){
                            Intent recharge=new Intent(getActivity(),RechargeActivity.class);
                            startActivity(recharge);
                        }else{
                            Intent bindCard=new Intent(getActivity(),BindBankCardActivity.class);
                            startActivity(bindCard);
                        }
                    }else{
                        Intent certificate=new Intent(getActivity(),CertificationActivity.class);
                        startActivity(certificate);
                    }


                    break;
                case R.id.ll_myjl:
                    Intent myAward = new Intent(getActivity(),MyAwardActivity.class);
                    startActivity(myAward);
                    break;
                case R.id.ll_autobid:
                    Intent myInvest=new Intent(getActivity(), MyInvestActivity.class);
                    startActivity(myInvest);
                    break;
                case R.id.ll_safety:
                    Intent intent=new Intent(getActivity(), SafeCenterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.ll_myinvit:
                    Intent invite = new Intent(getActivity(), InviteFriendsActivity.class);
                    startActivity(invite);
                    break;
                case R.id.btn_login:
                    Intent intent2=new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent2);
                    break;
            }
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(refreshDataReceiver);
        getActivity().unregisterReceiver(logoutReceiver);
    }

    private class LogoutRefreshReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            sv_mine.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
            rlLogin.setVisibility(View.VISIBLE);
            tvPhone.setText("立即登录 >");
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(DensityUtil.dip2px(getActivity(),60),DensityUtil.dip2px(getActivity(),30), 0, 0);
            tvPhone.setLayoutParams(lp);
            tvTotalBalance.setText("0.00");
            tvAvailablBalance.setText("0.00");
            tvYesterdEarn1.setText("0");
            tvYesterdayEarn2.setText(".00");
            ivAvanta.setOnClickListener(null);
            tvPhone.setOnClickListener(null);
            ivHelp.setOnClickListener(null);
            tvDetail.setOnClickListener(null);
            btnRecharge.setOnClickListener(null);
            btnWithDraw.setOnClickListener(null);
            llMyjl.setOnClickListener(null);
            llAutoBid.setOnClickListener(null);
            llMysafety.setOnClickListener(null);
            llMyInvite.setOnClickListener(null);
        }
    }

    private class BankInfoAsyncResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            Log.i(TAG, "BankInfoAsyncResponseHandler======"+s);
            BankInfo bankInfo = JSON.parseObject(s, BankInfo.class);
            if (bankInfo.isSuccess()){
                BankInfo.DataBean data = bankInfo.getData();
                bankList = data.getList();
                if (bankList.size()>0){
                    SharedPreferences sp = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("bankName", bankList.get(0).getBankName());
                    edit.putString("bankCard", bankList.get(0).getBankCardNumber());//fullBankCardNumber
                    edit.putString("fullBankCardNumber", bankList.get(0).getFullBankCardNumber());
                    edit.commit();
                }
            }
        }
    }
}
