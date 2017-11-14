package btj.mine.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.xidaiw.btj.R;

public class EditPayPasswordActivity extends Activity implements View.OnClickListener{
    private ImageView ivBack;
    private ImageView ivHelp;
    private RelativeLayout rlRemeberPayPwd;
    private RelativeLayout rlForgetPayPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_pay_password);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initViews();
        bindData();
    }

    private void bindData() {
        ivBack.setOnClickListener(this);
        ivHelp.setOnClickListener(this);
        rlRemeberPayPwd.setOnClickListener(this);
        rlForgetPayPwd.setOnClickListener(this);
    }

    private void initViews() {
        ivBack=findViewById(R.id.iv_back);
        ivHelp=findViewById(R.id.iv_help);
        rlRemeberPayPwd=findViewById(R.id.rl_rememberPayPwd);
        rlForgetPayPwd=findViewById(R.id.rl_forgetPayPwd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_help:
                break;
            case R.id.rl_rememberPayPwd:
                Intent intent=new Intent(EditPayPasswordActivity.this,ResetPayPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_forgetPayPwd:
                Intent intent1=new Intent(EditPayPasswordActivity.this,ForgetPayPasswordActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
