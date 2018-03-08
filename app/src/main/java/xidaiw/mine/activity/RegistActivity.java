package xidaiw.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.InputType;
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
import com.loopj.android.http.RequestParams;
import com.xidaiw.btj.R;

import xidaiw.mine.entity.LoginInfo;
import xidaiw.mine.entity.RegistInfo;
import xidaiw.mine.entity.SmsInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;
import xidaiw.util.progressBar.AsyncDialog;
import xidaiw.widget.MyImageView;


public class RegistActivity extends AppCompatActivity {
    private static final String TAG = "RegistActivity";
    private ImageView ivBack,ivEye,ivjb;
    private MyOnclickListener clickListener;
    private MyImageView ivYzm;
    private TextView tvHeader,tvGetCode,tvProtocol,tvYzmError,tvSmsError;
    private EditText etPhone,etPassword,etYzm,etSms,etInvite;
    private LinearLayout llInvite,llShowInvite,llLogin;
    private Button btnRegister;
    private boolean isInvite=false,isShowPwd=false;
    String setHint="6-12位字符<small>(区分大小写)</small>";
//    private String channelId="1";//小米市场
//    private String channelId="2";//360市场
//    private String channelId="6";//华为市场
//    private String channelId="11";//安智网市场
//    private String channelId="13";//搜狗市场
//    private String channelId="16";//魅族市场
//    private String channelId="20";//锤子市场
//    private String channelId="35";//vivo市场
    private String channelId="8888";//官网版
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case 0:
                    if (msg.arg1 == 0) {
                        tvGetCode.setText("重新获取");
                        tvGetCode.setClickable(true);
                    } else {
                        tvGetCode.setText( msg.arg1 + "秒后重新获取");
                        tvGetCode.setClickable(false);
                    }
                    break;
            }
        }
    };
    private String mobile;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
        etPassword.setHint(Html.fromHtml(setHint));
        clickListener = new MyOnclickListener();
        bindEvent();
        tvHeader.setText("注册");
        ivYzm.setImageURL(Urls.getQueryImageCode());
    }
    private void bindEvent() {
        ivBack.setOnClickListener(clickListener);
        ivEye.setOnClickListener(clickListener);
        tvGetCode.setOnClickListener(clickListener);
        ivYzm.setOnClickListener(clickListener);
        llShowInvite.setOnClickListener(clickListener);
        llLogin.setOnClickListener(clickListener);
        tvProtocol.setOnClickListener(clickListener);
        btnRegister.setOnClickListener(clickListener);
    }
    private void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        etPassword= (EditText) findViewById(R.id.et_password);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        etPhone= (EditText) findViewById(R.id.et_phone);
        ivEye= (ImageView) findViewById(R.id.iv_eye);
        etYzm= (EditText) findViewById(R.id.et_yzm);
        etSms= (EditText) findViewById(R.id.et_sms);
        ivYzm= (MyImageView) findViewById(R.id.iv_yzm);
        tvGetCode= (TextView) findViewById(R.id.tv_getTextCode);
        llInvite= (LinearLayout) findViewById(R.id.ll_invite);
        llShowInvite= (LinearLayout) findViewById(R.id.ll_show_invite);
        ivjb= (ImageView) findViewById(R.id.iv_jb);
        llLogin= (LinearLayout) findViewById(R.id.ll_login);
        etInvite= (EditText) findViewById(R.id.et_invite);
        tvProtocol= (TextView) findViewById(R.id.tv_user_protocol);
        btnRegister= (Button) findViewById(R.id.btn_register);
        tvYzmError= (TextView) findViewById(R.id.tv_yzm_error);
        tvSmsError= (TextView) findViewById(R.id.tv_sms_error);
    }

    public void getSmsCode() {
        String mobile = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String yzm = etYzm.getText().toString().trim();
        if (TextUtils.isEmpty(mobile)){
            Toast.makeText(this, "手机号不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(yzm)){
            Toast.makeText(this, "图片验证码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams params=new RequestParams();
        params.put("mobile",mobile);
        params.put("imageCode",yzm);
        HttpClient.get(this,Urls.getHost()+"/mobileRegisteredNew",new SmsAsyncHttpResponseHandler());
    }

    private  class MyOnclickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.iv_eye:
                    if (!isShowPwd){
                        ivEye.setImageResource(R.mipmap.eye_open1);
                        etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        isShowPwd=true;
                    }else{
                        ivEye.setImageResource(R.mipmap.eye_close1);
                        etPassword.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        isShowPwd=false;
                    }
                    break;
                case R.id.iv_yzm:
                    ivYzm.setImageURL(Urls.getQueryImageCode());
                    break;
                case R.id.tv_getTextCode:
                    getSmsCode();
                    break;
                case R.id.ll_show_invite:
                    if (!isInvite){
                        llInvite.setVisibility(View.VISIBLE);
                        ivjb.setImageResource(R.mipmap.jb2);
                        isInvite=true;
                    }else{
                        llInvite.setVisibility(View.GONE);
                        ivjb.setImageResource(R.mipmap.jb1);
                        isInvite=false;
                    }
                    break;
                case R.id.tv_user_protocol:
                    Intent intent=new Intent(RegistActivity.this,UserProtocolActivity.class);
                    startActivity(intent);
                    break;
                case R.id.ll_login:
                    Intent intent1=new Intent(RegistActivity.this,LoginActivity.class);
                    startActivity(intent1);
                    finish();
                    break;
                case R.id.btn_register:
                    register();
                    break;
            }
        }
    }

    /**
     * 注册
     */
    private void register() {
        mobile = etPhone.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        String yzm = etYzm.getText().toString().trim();
        String sms = etSms.getText().toString().trim();
        String invite = etInvite.getText().toString().trim();//推荐人的手机号
        if (TextUtils.isEmpty(mobile)){
            Toast.makeText(this, "手机号不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(yzm)){
            Toast.makeText(this, "图片验证码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(sms)){
            Toast.makeText(this, "短信验证码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams param=new RequestParams();
        param.put("mobile", mobile);
        param.put("password", password);
        param.put("passwordAgain", password);
        param.put("code",sms);
        param.put("recommend",invite);
        param.put("channelId",channelId);
        Log.i(TAG, "register: channelId:"+channelId);
        HttpClient.post(this,Urls.getHost()+"/registerForadAndroid",param,new RegisterHttpResponseHandler());

    }
    /**
     * 监听按钮下直接调用即可
     */
    private void sendMessageClick() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 59; i >= 0; i--) {
                    Message msg = handler.obtainMessage();
                    msg.arg1 = i;
                    handler.sendMessage(msg);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private class SmsAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String json) {
            super.onSuccess(i, json);
            Log.i(TAG, "onSuccess: "+json);
            SmsInfo smsInfo = JSON.parseObject(json, SmsInfo.class);
            if (smsInfo.isSuccess()){
                if (smsInfo.getData().isRegistered()){
                    Toast.makeText(RegistActivity.this,"该手机号已注册过了!", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    sendMessageClick();
                    tvYzmError.setVisibility(View.INVISIBLE);
                }
            }else{
                if (smsInfo.getMessage()=="图片验证码不正确"){
                    tvYzmError.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(RegistActivity.this,smsInfo.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private class RegisterHttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "onSuccess: "+s);
            RegistInfo registInfo = JSON.parseObject(s, RegistInfo.class);
            if (registInfo.isSuccess()){
//                Toast.makeText(RegistActivity.this, registInfo.getMessage(), Toast.LENGTH_SHORT).show();
                tvSmsError.setVisibility(View.INVISIBLE);
                RequestParams params=new RequestParams();
                params.put("mobile",mobile);
                params.put("password",password);
                HttpClient.post(RegistActivity.this,Urls.getLogin(),params,new LoginHttpResponseHandler());
            }else{
                Toast.makeText(RegistActivity.this, registInfo.getMessage(), Toast.LENGTH_SHORT).show();
//                if (registInfo.getMessage().equals("验证码过期")){
//                    tvSmsError.setVisibility(View.VISIBLE);
//                }else{
//                    Toast.makeText(RegistActivity.this, registInfo.getMessage(), Toast.LENGTH_SHORT).show();
//                }
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
                    Toast.makeText(RegistActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    //登录失败
                    Toast.makeText(RegistActivity.this, loginInfo.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
