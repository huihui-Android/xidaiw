package xidaiw.mine.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import xidaiw.mine.entity.PersonInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

public class LookDetailActivity extends AppCompatActivity {
    private ImageView ivBack;
    private TextView tvHeader;
    private TextView tvAssetsTotal;
    private TextView tvAssetsStatics;
    private TextView tvUnPayCaptical;
    private TextView tvUnPayInterest;
    private TextView tvAvailableBalance;
    private TextView tvFrozenCapital;
    private TextView tvWithdrawChecking;
    private TextView tvInvestBeforeBidOver;
    private TextView tvInvestPayback;
    private TextView tvInterestReceived;
    private TextView tvInterestUnReceive;
    private TextView tvOutdatePayback;
    private TextView tvOtherPayback;
    private TextView tvRedpacketPayback;
    private TextView tvVoucherPayback;
    private TextView tvInvitePayback;
    private TextView tvWhenRegister;
    private TextView tvComingDay1,tvComingDay2,tvComingDay3;
    private TextView tvTotalWithdraw,tvTotalRecharge,tvTotalInvest,tvTotalBorrowedMoney;
    private static final String TAG = "LookDetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_detail);
        initViews();
        tvHeader.setText("资金统计");
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        HttpClient.get(LookDetailActivity.this, Urls.getHost()+"/account/indexNew",new AccountDataResponseHandler());
    }

    private void initViews() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        tvAssetsTotal = (TextView) findViewById(R.id.tv_assets_total);
        tvAssetsStatics= (TextView) findViewById(R.id.tv_assets_statistics);
        tvUnPayCaptical= (TextView) findViewById(R.id.tv_unpay_capital);
        tvUnPayInterest= (TextView) findViewById(R.id.tv_unpay_interest);
        tvAvailableBalance= (TextView) findViewById(R.id.tv_availableBalance);
        tvFrozenCapital= (TextView) findViewById(R.id.tv_frozen_capital);
        tvWithdrawChecking= (TextView) findViewById(R.id.tv_withdraw_checking);
        tvInvestBeforeBidOver= (TextView) findViewById(R.id.tv_before_bidOver);
        tvInvestPayback= (TextView) findViewById(R.id.tv_invest_payback);
        tvInterestReceived= (TextView) findViewById(R.id.tv_interest_received);
        tvInterestUnReceive= (TextView) findViewById(R.id.tv_interest_unReceive);
        tvOutdatePayback= (TextView) findViewById(R.id.tv_outdated_payback);
        tvOtherPayback= (TextView) findViewById(R.id.tv_other_payback);
        tvRedpacketPayback= (TextView) findViewById(R.id.tv_red_packet_payback);
        tvVoucherPayback= (TextView) findViewById(R.id.tv_voucher_payback);
        tvInvitePayback= (TextView) findViewById(R.id.tv_invite_payback);
        tvWhenRegister= (TextView) findViewById(R.id.tv_when_register);
        tvComingDay1= (TextView) findViewById(R.id.tv_coming_day1);
        tvComingDay2= (TextView) findViewById(R.id.tv_coming_day2);
        tvComingDay3= (TextView) findViewById(R.id.tv_coming_day3);
        tvTotalWithdraw= (TextView) findViewById(R.id.tv_total_withdraw);
        tvTotalRecharge= (TextView) findViewById(R.id.tv_total_recharge);
        tvTotalInvest= (TextView) findViewById(R.id.tv_total_invest);
        tvTotalBorrowedMoney= (TextView) findViewById(R.id.tv_total_borrowed_money);
    }

    private class AccountDataResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "onSuccess: "+s);
            PersonInfo personInfo = JSON.parseObject(s, PersonInfo.class);
            if (personInfo.isSuccess()){
                PersonInfo.DataBean data = personInfo.getData();
                String ableWithdrawalAmount = data.getAbleWithdrawalAmount();
                tvAvailableBalance.setText(ableWithdrawalAmount);

            }
        }
    }
}
