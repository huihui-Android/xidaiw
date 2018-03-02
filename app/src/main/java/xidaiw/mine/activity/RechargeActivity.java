package xidaiw.mine.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import java.util.List;

import xidaiw.mine.entity.BankInfo;
import xidaiw.util.GlobalUtils;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;
import xidaiw.widget.MyImageView;

public class RechargeActivity extends AppCompatActivity {

    private TextView tvHeader;
    private TextView tvRight;
    private TextView tvTimeLimit;
    private TextView tvDailyLimit;
    private TextView tvBankName;
    private TextView tvBankNum;
    private MyImageView ivBankLogo;
    private EditText etRechargeMoney;
    private Button btnRecharge;
    private ImageView ivClear,ivBack;
    private TextView tvBankLimitTable;
    private static final String TAG = "RechargeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        initViews();
        tvHeader.setText("充值");
        bindEvents();
        initData();
    }

    private void initData() {
        HttpClient.get(this, Urls.getHost()+"/userBankCard/listByChannelId?productChannelId=2",new RechargeResponseHandler());
    }

    private void bindEvents() {
        MyOnclickListener listener=new MyOnclickListener();
        tvRight.setOnClickListener(listener);
        ivClear.setOnClickListener(listener);
        btnRecharge.setOnClickListener(listener);
        ivBack.setOnClickListener(listener);
        tvBankLimitTable.setOnClickListener(listener);
    }

    private void initViews() {
        tvHeader = (TextView) findViewById(R.id.tv_header);
        tvRight = (TextView) findViewById(R.id.tv_right);
        tvTimeLimit = (TextView) findViewById(R.id.tv_time_limit);
        tvDailyLimit = (TextView) findViewById(R.id.tv_daily_limit);
        tvBankName = (TextView) findViewById(R.id.tv_bankName);
        tvBankNum = (TextView) findViewById(R.id.tv_bankNum);
        ivBankLogo = (MyImageView) findViewById(R.id.iv_bankLogo);
        etRechargeMoney = (EditText) findViewById(R.id.et_recharge_money);
        btnRecharge = (Button) findViewById(R.id.btn_recharge);
        ivClear = (ImageView) findViewById(R.id.iv_clear);
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvBankLimitTable= (TextView) findViewById(R.id.tv_bankLimitTable);
    }
    private class MyOnclickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.tv_right:
                    Toast.makeText(RechargeActivity.this, "充值记录", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.iv_clear:
                    etRechargeMoney.setText("");
                    break;
                case R.id.btn_recharge:
                    String rechargeMoney = etRechargeMoney.getText().toString().trim();
                    if (TextUtils.isEmpty(rechargeMoney)){
                        Toast.makeText(RechargeActivity.this, "充值金额不能为空!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    double rechargMoneyNum = Double.parseDouble(rechargeMoney);
                    if (rechargMoneyNum<50){
                        Toast.makeText(RechargeActivity.this, "充值须不低于50元", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(RechargeActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.tv_bankLimitTable:
                    Toast.makeText(RechargeActivity.this, "银行限额表", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private class RechargeResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "onSuccess: "+s);
            BankInfo bankInfo = JSON.parseObject(s, BankInfo.class);
            if (bankInfo.isSuccess()){
                BankInfo.DataBean data = bankInfo.getData();
                List<BankInfo.DataBean.ListBean> list = data.getList();
                ivBankLogo.setImageURL(list.get(0).getBankPicPath());
                tvBankName.setText(list.get(0).getBankName());
                tvBankNum.setText("尾号"+list.get(0).getBankCardNumber());
                tvTimeLimit.setText(GlobalUtils.NumberFormatTransfer(list.get(0).getBankTimeLimit()+".00"));
                tvDailyLimit.setText(GlobalUtils.NumberFormatTransfer(list.get(0).getBankDayLimit()+".00"));
            }
        }
    }
}
