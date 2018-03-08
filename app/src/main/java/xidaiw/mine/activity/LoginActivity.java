package xidaiw.mine.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.xidaiw.btj.R;

import xidaiw.mine.entity.LoginInfo;
import xidaiw.util.EditTextUtils;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;
import xidaiw.util.progressBar.AsyncDialog;

public class LoginActivity extends Activity implements View.OnClickListener {
    private ImageView ivBack;
    private TextView tvTitle;
    private Button btnLogin;
    private TextView tvRegister;
    private TextView tvForgetPassword;
    private EditText etPhone;
    private EditText etPassword;
    private ImageView ivEye;
    private String phoneNum;
    String sethint="6-12位字符";
//    String sethint="6-12位字符<small>(区分大小写)</small>";
    private String password;
    private ImageView ivClearPhone;
    private ImageView ivClearPwd;
    private RelativeLayout rlSmsLogin;
    private TextView tvSmsLogin;
    private Boolean isEyeClosed=false;
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        initViews();
        tvTitle.setText("登录");
        etPassword.setHint(Html.fromHtml(sethint));
        ivBack.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        ivEye.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvForgetPassword.setOnClickListener(this);
        tvSmsLogin.setOnClickListener(this);
        etPhone.addTextChangedListener(watcherPhoneNum);
        EditTextUtils.clearInputListener(etPhone,ivClearPhone);
        EditTextUtils.clearInputListener(etPassword,ivClearPwd);
    }

    private void toLogin(){
        phoneNum = etPhone.getText().toString().trim();
        phoneNum = phoneNum.replace(" ", "");
        password = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(phoneNum)) {
            Toast.makeText(getApplicationContext(), "请输入手机号!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "请输入密码!", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestParams params = new RequestParams();//网络访问的参数
        try {
            params.put("mobile", phoneNum);
            params.put("password", password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AsyncDialog.show(this, "正在登录...");
        HttpClient.post(this, Urls.getLogin(), params, new LoginAsyncHttpResponseHandler());//登录操作
    }

    public class LoginAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
        public void onStart() {
            super.onStart();
        }

        public void onSuccess(int arg0, String json) {
            super.onSuccess(arg0, json);
            Log.d(TAG,json);
            AsyncDialog.hide();
            LoginInfo loginInfo = JSON.parseObject(json, LoginInfo.class);
            if (loginInfo.isSuccess()){
                //登录成功
                Intent intent=new Intent("LoginSuccess");
                sendBroadcast(intent);
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                //登录失败
                Toast.makeText(LoginActivity.this, "手机号或密码错误", Toast.LENGTH_SHORT).show();
                rlSmsLogin.setVisibility(View.VISIBLE);
            }
        }
        public void onFailure(Throwable arg0, String json) {super.onFailure(arg0, json);}
    }

    private void initViews() {
        ivBack = findViewById(R.id.iv_back);
        tvTitle = findViewById(R.id.tv_header);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);
        tvForgetPassword = findViewById(R.id.tv_forgotPassword);
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        ivEye = findViewById(R.id.iv_eye);
        ivClearPhone=findViewById(R.id.iv_clearphone);
        ivClearPwd=findViewById(R.id.iv_clearpwd);
        rlSmsLogin=findViewById(R.id.rl_smsLogin);
        tvSmsLogin=findViewById(R.id.tv_smsLogin);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                toLogin();
                break;
            case R.id.tv_register:
                Intent intent=new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_forgotPassword:
                Intent intent1=new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.iv_eye:
                if (!isEyeClosed){
                    ivEye.setImageResource(R.mipmap.eye_open1);
                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);//对用户可见的pwd
                    isEyeClosed=true;
                }else{
                    ivEye.setImageResource(R.mipmap.eye_close1);
                    etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);//对用户不可见的pwd
                    isEyeClosed=false;
                }
                break;
            case R.id.tv_smsLogin:
                Intent intent2=new Intent(LoginActivity.this,LoginBySmsActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    //手机号输入框的文本输入改变的监听
    private TextWatcher watcherPhoneNum = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //手机号格式化xxx xxxx xxxx
            if (s == null || s.length() == 0) return;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i != 3 && i != 8 && s.charAt(i) == ' ') {
                    continue;
                } else {
                    sb.append(s.charAt(i));
                    if ((sb.length() == 4 || sb.length() == 9) && sb.charAt(sb.length() - 1) != ' ') {
                        sb.insert(sb.length() - 1, ' ');
                    }
                }
            }
            if (!sb.toString().equals(s.toString())) {
                int index = start + 1;
                if (sb.charAt(start) == ' ') {
                    if (before == 0) {
                        index++;
                    } else {
                        index--;
                    }
                } else {
                    if (before == 1) {
                        index--;
                    }
                }
                etPhone.setText(sb.toString());
                etPhone.setSelection(index);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
