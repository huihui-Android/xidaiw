package btj.mine.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.xidaiw.btj.R;

import btj.widget.Dialog;

public class ResetPasswordActivity extends Activity implements View.OnClickListener,TextWatcher{
    private ImageView ivBack;
    private ImageView ivHelp;
    private EditText etNewPwd;
    private EditText etConfirmPwd;
    private Button btnConfirmPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reset_password);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initViews();
        bindData();
    }

    private void bindData() {
        ivBack.setOnClickListener(this);
        ivHelp.setOnClickListener(this);
        btnConfirmPwd.setOnClickListener(this);
        etNewPwd.addTextChangedListener(this);
        etConfirmPwd.addTextChangedListener(this);
    }

    private void initViews() {
        ivBack=findViewById(R.id.iv_back);
        ivHelp=findViewById(R.id.iv_help);
        etNewPwd=findViewById(R.id.et_newPwd);
        etConfirmPwd=findViewById(R.id.et_confirmPwd);
        btnConfirmPwd=findViewById(R.id.btn_confirmPwd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_help:
                break;
            case R.id.btn_confirmPwd:
                Dialog.singleGeneralDialog("重置密码成功",ResetPasswordActivity.this);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            btnConfirmPwd.setEnabled(false);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!etNewPwd.getText().toString().trim().equals("")){
            if (!etConfirmPwd.getText().toString().trim().equals("")){
                btnConfirmPwd.setEnabled(true);
            }
        }
    }
}
