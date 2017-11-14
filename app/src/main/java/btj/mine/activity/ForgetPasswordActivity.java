package btj.mine.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xidaiw.btj.R;

import btj.widget.Dialog;

public class ForgetPasswordActivity extends Activity implements View.OnClickListener,TextWatcher{
    private ImageView ivBack;
    private ImageView ivHelp;
    private EditText etPhoneNum;
    private EditText etTextCode;
    private Button btnEditPwd;
    private TextView tvTextCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forget_password);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initViews();
        bindData();
    }

    private void bindData() {
        ivBack.setOnClickListener(this);
        ivHelp.setOnClickListener(this);
        tvTextCode.setOnClickListener(this);
        btnEditPwd.setOnClickListener(this);
        etPhoneNum.addTextChangedListener(this);
        etTextCode.addTextChangedListener(this);
    }

    private void initViews() {
        ivBack=findViewById(R.id.iv_back);
        ivHelp=findViewById(R.id.iv_help);
        etPhoneNum=findViewById(R.id.et_phoneNum);
        etTextCode=findViewById(R.id.et_textCode);
        tvTextCode=findViewById(R.id.tv_getTextCode);
        btnEditPwd=findViewById(R.id.btn_editPwd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_getTextCode:
                Dialog.singleGeneralDialog("获取验证码",ForgetPasswordActivity.this);
                break;
            case R.id.iv_help:
                break;
            case R.id.btn_editPwd:
                Intent intent=new Intent(ForgetPasswordActivity.this,ResetPasswordActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            btnEditPwd.setEnabled(false);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
            if (!etPhoneNum.getText().toString().trim().equals("")){
                if (!etTextCode.getText().toString().trim().equals("")){
                    btnEditPwd.setEnabled(true);
                }
            }
    }
}
