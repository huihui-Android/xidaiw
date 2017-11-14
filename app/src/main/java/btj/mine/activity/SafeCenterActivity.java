package btj.mine.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xidaiw.btj.R;

public class SafeCenterActivity extends Activity implements View.OnClickListener{
    private ImageView ivBack;
    private ImageView ivHelp;
    private RelativeLayout rlRenZheng;
    private TextView tvRenzheng;
    private RelativeLayout rlCard;
    private TextView tvCard;
    private RelativeLayout rlBindPhone;
    private TextView tvPhone;
    private RelativeLayout rlEditPwd;
    private RelativeLayout rlEditPayPwd;
    private RelativeLayout rlGesture;
    private RelativeLayout rlEditGesturePwd;
    private ImageView ivToggle;
    private boolean isGesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_safe_center);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//状态栏沉浸
        initViews();//初始化控件
        loadData();//加载用户数据
        bindData();//添加点击事件

    }

    private void loadData() {

    }

    private void bindData() {
        ivBack.setOnClickListener(this);
        ivHelp.setOnClickListener(this);
        rlRenZheng.setOnClickListener(this);
        rlCard.setOnClickListener(this);
        rlBindPhone.setOnClickListener(this);
        rlEditPwd.setOnClickListener(this);
        rlEditPayPwd.setOnClickListener(this);
        rlGesture.setOnClickListener(this);
        rlEditGesturePwd.setOnClickListener(this);

    }

    private void initViews() {
        ivBack=findViewById(R.id.iv_back);
        ivHelp=findViewById(R.id.iv_help);
        rlRenZheng=findViewById(R.id.rl_rz);
        tvRenzheng=findViewById(R.id.tv_renzheng);
        rlCard=findViewById(R.id.rl_card);
        tvCard=findViewById(R.id.tv_card);
        rlBindPhone=findViewById(R.id.rl_bindphone);
        tvPhone=findViewById(R.id.tv_phone);
        rlEditPwd=findViewById(R.id.rl_editpwd);
        rlEditPayPwd=findViewById(R.id.rl_editpaypwd);
        rlGesture=findViewById(R.id.rl_gesturepwd);
        rlEditGesturePwd=findViewById(R.id.rl_editGesturePwd);
        ivToggle=findViewById(R.id.iv_toggle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_help:
                break;
            case R.id.rl_rz:
                Intent intent =new Intent(this,CertificationActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_card:
                Intent intent2 =new Intent(this,BindBankCardActivity.class);
                startActivity(intent2);
                break;
            case R.id.rl_bindphone:
                break;
            case R.id.rl_editpwd:
                Intent intent3 =new Intent(this,EditPasswordActivity.class);
                startActivity(intent3);
                break;
            case R.id.rl_editpaypwd:
                Intent intent4 =new Intent(this,EditPayPasswordActivity.class);
                startActivity(intent4);
                break;
            case R.id.rl_editGesturePwd:
                break;
            case R.id.rl_gesturepwd:
                toggle();
                break;
        }
    }
    public void openGesture(){
        if (isGesture) return;
            ivToggle.setImageResource(R.mipmap.toggle_on);
            isGesture=true;

    }
    public void closeGesture(){
        if (isGesture){
            ivToggle.setImageResource(R.mipmap.toggle_off);
            isGesture=false;
        }
    }
    public void toggle(){
        if (isGesture){
            closeGesture();
        }else{
            openGesture();
        }
    }
}
