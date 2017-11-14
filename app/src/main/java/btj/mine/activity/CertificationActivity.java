package btj.mine.activity;

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

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.xidaiw.btj.R;

import btj.util.progressBar.AsyncDialog;
import btj.widget.Dialog;

public class CertificationActivity extends Activity implements View.OnClickListener, TextWatcher {

    private ImageView ivBack;
    private ImageView ivHelp;
    private EditText etRealName;
    private EditText etCardNum;
    private Button btnCertification;
    private String realName;
    private String cardNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_certification);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//状态栏沉浸
        initViews();
        bindData();
         realName = etRealName.getText().toString().trim();
         cardNum = etCardNum.getText().toString().trim();
    }

    private void bindData() {
        ivBack.setOnClickListener(this);
        ivHelp.setOnClickListener(this);
        btnCertification.setOnClickListener(this);
        etRealName.addTextChangedListener(this);
        etCardNum.addTextChangedListener(this);
    }

    private void initViews() {
        ivBack = findViewById(R.id.iv_back);
        ivHelp = findViewById(R.id.iv_help);
        etRealName = findViewById(R.id.et_realName);
        etCardNum = findViewById(R.id.et_cardNum);
        btnCertification = findViewById(R.id.btn_certificate);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_help:
                break;
            case R.id.btn_certificate:
                realName = etRealName.getText().toString().trim();
                cardNum = etCardNum.getText().toString().trim();
                if (TextUtils.isEmpty(realName)) {
                    Toast.makeText(this, "请输入真实姓名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cardNum)) {
                    Toast.makeText(this, "请输入身份证号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                RequestParams params = new RequestParams();
                params.put("realName", realName);
                params.put("cardNum", cardNum);
                //AsyncDialog.show(this, "正在实名认证...");
                //AsyncDialog.hide();
                Dialog.singleGeneralDialog("认证成功",CertificationActivity.this);
                //finish();
                //HttpClient.post(this, Urls.getLogin(),params, new CetificateAsyncHttpResponseHandler());//实名认证操作
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                btnCertification.setEnabled(false);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!etRealName.getText().toString().trim().equals("")) {
            if (!etCardNum.getText().toString().trim().equals("")){
                btnCertification.setEnabled(true);
            }
        }
    }

    public class CertificateAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
        public void onStart() {
            super.onStart();
        }

        public void onSuccess(int arg0, String json) {
            super.onSuccess(arg0, json);
            AsyncDialog.hide();

        }

        public void onFailure(Throwable arg0, String json) {
            super.onFailure(arg0, json);
        }
    }
}
