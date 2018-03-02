package xidaiw.mine.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import java.util.List;

import xidaiw.mine.entity.BankInfo;
import xidaiw.mine.entity.PersonInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

public class WithdrawActivity extends AppCompatActivity {
    private TextView tvHeader,tvRight,tvAvailableBalance,tvSxf,tvSxfDesc,tvWithdrawAll,tvWidthdrawBank;
    private Button btnWithdraw;
    private EditText etWithdrawMoney,etPayPassword;
    private ImageView ivBack,ivCloseDialog;
    private LinearLayout llDialog;
    private static final String TAG = "WithdrawActivity";
    private String ableWithdrawalAmount;
    private boolean isShowDialog=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
        initViews();
        tvHeader.setText("提现");
        tvRight.setText("提现记录");
        bindEvents();
        initData();
    }

    private void initData() {
        HttpClient.get(this, Urls.getHost()+"/userBankCard/listByChannelId?productChannelId=2",new WithDrawAsyncHttpResponseHandler());
        HttpClient.get(this,Urls.getHost()+"/account/indexNew",new PersonAysncHttpResponseHandler());
    }

    private void bindEvents() {
        MyOnclickListener listener =new MyOnclickListener();
        ivBack.setOnClickListener(listener);
        tvRight.setOnClickListener(listener);
        tvSxfDesc.setOnClickListener(listener);
        tvWithdrawAll.setOnClickListener(listener);
        btnWithdraw.setOnClickListener(listener);
        ivCloseDialog.setOnClickListener(listener);
    }

    private void initViews() {
        tvHeader= (TextView) findViewById(R.id.tv_header);
        tvRight= (TextView) findViewById(R.id.tv_right);
        tvAvailableBalance= (TextView) findViewById(R.id.tv_availableBalance);
        tvSxf= (TextView) findViewById(R.id.tv_sxf);
        tvSxfDesc= (TextView) findViewById(R.id.tv_sxf_desc);
        tvWidthdrawBank= (TextView) findViewById(R.id.tv_withdraw_bank);
        tvWithdrawAll= (TextView) findViewById(R.id.tv_withdraw_all);
        etWithdrawMoney= (EditText) findViewById(R.id.et_withdraw_money);
        etPayPassword= (EditText) findViewById(R.id.et_pay_password);
        btnWithdraw= (Button) findViewById(R.id.btn_widthdraw);
        ivBack= (ImageView) findViewById(R.id.iv_back);
        llDialog= (LinearLayout) findViewById(R.id.ll_dialog);
        ivCloseDialog= (ImageView) findViewById(R.id.iv_close_dialog);
    }
    private class MyOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.tv_right:
                    Toast.makeText(WithdrawActivity.this, "提现记录", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tv_sxf_desc:
//                    Toast.makeText(WithdrawActivity.this, "提现手续费说明", Toast.LENGTH_SHORT).show();
                    llDialog.setVisibility(View.VISIBLE);
                    break;
                case R.id.tv_withdraw_all:
                    etWithdrawMoney.setText(ableWithdrawalAmount);
                    break;
                case R.id.btn_widthdraw:
                    Toast.makeText(WithdrawActivity.this, "提现", Toast.LENGTH_SHORT).show();
                    String withdrawMoney = etWithdrawMoney.getText().toString().trim();
                    if (TextUtils.isEmpty(withdrawMoney)){
                        Toast.makeText(WithdrawActivity.this, "提现金额不能为空!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    double withdrawMoneyNum = Double.parseDouble(withdrawMoney);
                    double ableWithdrawNum = Double.parseDouble(ableWithdrawalAmount);
                    if (withdrawMoneyNum>ableWithdrawNum){
                        Toast.makeText(WithdrawActivity.this, "提现金不能大于可用余额!", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(WithdrawActivity.this, "提现成功!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.iv_close_dialog:
                    llDialog.setVisibility(View.GONE);
                    break;
            }
        }
    }

    private class WithDrawAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            Log.i(TAG, "onSuccess: "+s);
            BankInfo bankInfo = JSON.parseObject(s, BankInfo.class);
            if (bankInfo.isSuccess()){
                BankInfo.DataBean data = bankInfo.getData();
                List<BankInfo.DataBean.ListBean> list = data.getList();
                tvWidthdrawBank.setText(list.get(0).getBankName()+"(尾号"+list.get(0).getBankCardNumber()+")");
            }
        }
    }

    private class PersonAysncHttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            Log.i(TAG, "onSuccess:个人信息 "+s);
            PersonInfo personInfo = JSON.parseObject(s, PersonInfo.class);
            if (personInfo.isSuccess()){
                PersonInfo.DataBean data = personInfo.getData();
                ableWithdrawalAmount = data.getAbleWithdrawalAmount();
                tvAvailableBalance.setText(ableWithdrawalAmount);
            }
        }
    }
}
