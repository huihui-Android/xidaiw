package xidaiw.mine.activity;

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
import android.widget.TextView;

import com.xidaiw.btj.R;

public class ForgetPayPasswordActivity extends Activity implements View.OnClickListener,TextWatcher{
    private ImageView ivBack;
    private ImageView ivHelp;
    private EditText etCardNum;
    private EditText etTextCode;
    private TextView tvGetTextCode;
    private Button btnConfirmPwd;
    private TextView tvCardTailNum;//银行卡尾号
    private ImageView ivBankLogo;//绑定银行对应的logo
    private TextView tvPhoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forget_pay_password);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initViews();
        bindData();
    }

    private void bindData() {
        ivBack.setOnClickListener(this);
        ivHelp.setOnClickListener(this);
        tvGetTextCode.setOnClickListener(this);
        btnConfirmPwd.setOnClickListener(this);
        etTextCode.addTextChangedListener(this);
        etCardNum.addTextChangedListener(this);
    }

    private void initViews() {
        ivBack=findViewById(R.id.iv_back);
        ivHelp=findViewById(R.id.iv_help);
        ivBankLogo=findViewById(R.id.iv_bankLogo);
        etCardNum=findViewById(R.id.et_cardNum);
        etTextCode=findViewById(R.id.et_textCode);
        tvGetTextCode=findViewById(R.id.tv_getTextCode);
        tvCardTailNum=findViewById(R.id.tv_cardTailNum);
        tvPhoneNum=findViewById(R.id.tv_phone);
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
            case R.id.tv_getTextCode:
                break;
            case R.id.btn_confirmPwd:

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
        if (!etCardNum.getText().toString().trim().equals("")){
            if (!etTextCode.getText().toString().trim().equals("")){
                btnConfirmPwd.setEnabled(true);
            }
        }
    }
}
