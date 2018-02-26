package xidaiw.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xidaiw.btj.R;

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
                
                break;
            case R.id.btn_login:
                Toast.makeText(this, "通过验证码登录成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
