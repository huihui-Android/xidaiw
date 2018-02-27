package xidaiw.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
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
import com.loopj.android.http.RequestParams;
import com.xidaiw.btj.R;

import xidaiw.mine.entity.LoginBySmsInfo;
import xidaiw.mine.entity.LoginInfo;
import xidaiw.mine.entity.SmsInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;
import xidaiw.util.progressBar.AsyncDialog;

public class LoginBySmsActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView ivBack;
    private TextView tvHeader;
    private EditText etPhone;
    private EditText etSms;
    private TextView tvPhoneError;
    private TextView tvSmsError;
    private TextView tvRegister;
    private TextView tvLogin;
    private Button btnLogin;
    private TextView tvTextCode;
    private static final String TAG = "LoginBySmsActivity";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int i = msg.arg1;
            switch(msg.what){
                case 0:
                    if (i==0){
                        tvTextCode.setText("重新获取");
                        tvTextCode.setClickable(true);
                    }else{
                        tvTextCode.setText(i+"秒后重新获取");
                        tvTextCode.setClickable(false);
                    }
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_by_sms);
        initViews();
        bindEvents();
        tvHeader.setText("登录");
    }

    private void bindEvents() {
        ivBack.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        tvTextCode.setOnClickListener(this);
    }

    private void initViews() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        etPhone= (EditText) findViewById(R.id.et_phone);
        etSms= (EditText) findViewById(R.id.et_sms);
        tvPhoneError= (TextView) findViewById(R.id.tv_phone_error);
        tvSmsError= (TextView) findViewById(R.id.tv_sms_error);
        tvRegister= (TextView) findViewById(R.id.tv_register);
        tvLogin= (TextView) findViewById(R.id.tv_login);
        btnLogin= (Button) findViewById(R.id.btn_login);
        tvTextCode= (TextView) findViewById(R.id.tv_getTextCode);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_register:
                Intent intent =new Intent(LoginBySmsActivity.this,RegistActivity.class);
                startActivity(intent);
                break;
            case  R.id.tv_login:
                Intent intent1 =new Intent(LoginBySmsActivity.this,LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_getTextCode:
                getSmsCode();
                break;
            case R.id.btn_login:
                SmsLogin();
                break;
        }
    }

    private void SmsLogin() {
        String mobile = etPhone.getText().toString().trim();
        String sms = etSms.getText().toString().trim();
        if (TextUtils.isEmpty(mobile)){
            Toast.makeText(this, "手机号不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(sms)){
            Toast.makeText(this, "动态密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams params=new RequestParams();
        params.put("mobile",mobile);
        params.put("code",sms);
        AsyncDialog.show(LoginBySmsActivity.this,"正在登陆...");
        HttpClient.post(LoginBySmsActivity.this, Urls.getHost()+"/loginWithCode",params,new LoginBySmsHttpResponseHandler());
    }

    public void getSmsCode() {
        String mobile = etPhone.getText().toString().trim();
        if (TextUtils.isEmpty(mobile)){
            Toast.makeText(this, "手机号不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        AsyncDialog.show(LoginBySmsActivity.this,"动态密码获取中...");
        HttpClient.get(LoginBySmsActivity.this,Urls.getHost()+"/mobileRegisteredNew1?mobile="+mobile,new GetSmsAsyncHttpResponseHandler());
    }

    private class LoginBySmsHttpResponseHandler extends AsyncHttpResponseHandler{
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "onSuccess: "+s);
            AsyncDialog.hide();
            LoginBySmsInfo loginBySmsInfo = JSON.parseObject(s, LoginBySmsInfo.class);
            if (loginBySmsInfo.isSuccess()){
                String tel = loginBySmsInfo.getData().getMobile();
                String pwd = loginBySmsInfo.getData().getPassword();
                RequestParams params=new RequestParams();
                params.put("mobile",tel);
                params.put("password",pwd);
                HttpClient.post(LoginBySmsActivity.this, Urls.getHost()+"/login",params,new LoginHttpResponseHandler());
            }
        }
        private class LoginHttpResponseHandler extends AsyncHttpResponseHandler {
            public void onSuccess(int arg0, String json) {
                super.onSuccess(arg0, json);
                Log.d(TAG,json);
                AsyncDialog.hide();
                LoginInfo loginInfo = JSON.parseObject(json, LoginInfo.class);
                if (loginInfo.isSuccess()){
                    //登录成功
                    Intent intent=new Intent("LoginSuccess");
                    sendBroadcast(intent);
                    Toast.makeText(LoginBySmsActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    //登录失败
                    Toast.makeText(LoginBySmsActivity.this, loginInfo.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private class GetSmsAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            Log.i(TAG, "onSuccess: "+s);
            AsyncDialog.hide();
            SmsInfo smsInfo = JSON.parseObject(s, SmsInfo.class);
            if (smsInfo.isSuccess()){
                Toast.makeText(LoginBySmsActivity.this,smsInfo.getMessage(), Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i=59;i>=0;i--){
                            Message msg = handler.obtainMessage();
                            msg.arg1=i;
                            handler.sendMessage(msg);
                            SystemClock.sleep(1000);
                        }
                    }
                }).start();
            }else{
                Toast.makeText(LoginBySmsActivity.this,smsInfo.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
