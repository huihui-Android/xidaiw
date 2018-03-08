package xidaiw.mine.activity;

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

import xidaiw.widget.Dialog;

public class EditPasswordActivity extends Activity implements View.OnClickListener,TextWatcher{
    private ImageView ivBack;
    private ImageView ivHelp;
    private EditText etOldPwd;
    private EditText etNewPwd;
    private EditText etConfirmPwd;
    private TextView tvForgetPwd;
    private Button btnEditPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_password);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initViews();
        bindData();
    }

    private void bindData() {
        ivBack.setOnClickListener(this);
        ivHelp.setOnClickListener(this);
        tvForgetPwd.setOnClickListener(this);
        btnEditPwd.setOnClickListener(this);
        etOldPwd.addTextChangedListener(this);
        etNewPwd.addTextChangedListener(this);
        etConfirmPwd.addTextChangedListener(this);
    }

    private void initViews() {
        ivBack=findViewById(R.id.iv_back);
        ivHelp=findViewById(R.id.iv_help);
        etOldPwd=findViewById(R.id.et_oldPwd);
        etNewPwd=findViewById(R.id.et_newPwd);
        etConfirmPwd=findViewById(R.id.et_confirmPwd);
        tvForgetPwd=findViewById(R.id.tv_forgetPwd);
        btnEditPwd=findViewById(R.id.btn_editPwd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_help:
                break;
            case R.id.tv_forgetPwd:
                Intent intent=new Intent(EditPasswordActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_editPwd:
                Dialog.singleGeneralDialog("修改密码成功",EditPasswordActivity.this);
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
            if (!etOldPwd.getText().toString().trim().equals("")){
                if (!etNewPwd.getText().toString().trim().equals("")){
                    if (!etConfirmPwd.getText().toString().trim().equals("")){
                        btnEditPwd.setEnabled(true);
                    }
                }
            }
    }
}
