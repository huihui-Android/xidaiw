package xidaiw.mine.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.xidaiw.btj.R;

import xidaiw.widget.Dialog;

public class BindBankCardActivity extends Activity implements View.OnClickListener,TextWatcher{
    private ImageView ivBack;
    private ImageView ivHelp;
    private EditText etBankName;
    private EditText etBankBranch;
    private EditText etBankAddress;
    private EditText etCardNum;
    private Button btnAddBankCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bind_bank_card);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initViews();
        bindData();
    }

    private void bindData() {
        ivBack.setOnClickListener(this);
        ivHelp.setOnClickListener(this);
        btnAddBankCard.setOnClickListener(this);
        etBankBranch.addTextChangedListener(this);
        etBankName.addTextChangedListener(this);
        etBankAddress.addTextChangedListener(this);
        etCardNum.addTextChangedListener(this);
    }

    private void initViews() {
        ivBack=findViewById(R.id.iv_back);
        ivHelp=findViewById(R.id.iv_help);
        etBankName=findViewById(R.id.et_bankName);
        etBankAddress=findViewById( R.id.et_bankAddress);
        etBankBranch=findViewById(R.id.et_bankBranch);
        etCardNum=findViewById(R.id.et_cardNum);
        btnAddBankCard=findViewById(R.id.btn_add_bankCard);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_help:
                break;
            case R.id.btn_add_bankCard:
                String cardNum = etCardNum.getText().toString().trim();
                String bankName = etBankName.getText().toString().trim();
                String bankAddress = etBankAddress.getText().toString().trim();
                String bankBranch = etBankBranch.getText().toString().trim();
                if (TextUtils.isEmpty(cardNum)){
                    Toast.makeText(BindBankCardActivity.this,"银行卡号不能为空!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(bankName)){
                    Toast.makeText(BindBankCardActivity.this,"银行名称不能为空!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(bankAddress)){
                    Toast.makeText(BindBankCardActivity.this,"银行地址不能为空!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(bankBranch)){
                    Toast.makeText(BindBankCardActivity.this,"支行名称不能为空!",Toast.LENGTH_SHORT).show();
                    return;
                }
                Dialog.singleGeneralDialog("添加银行卡成功",BindBankCardActivity.this);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            btnAddBankCard.setEnabled(false);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!etCardNum.getText().toString().trim().equals("")) {
            if (!etBankName.getText().toString().trim().equals("")){
                if (!etBankAddress.getText().toString().trim().equals("")) {
                    if (!etBankBranch.getText().toString().trim().equals("")){
                        btnAddBankCard.setEnabled(true);
                    }
                }
            }
        }
    }
}
