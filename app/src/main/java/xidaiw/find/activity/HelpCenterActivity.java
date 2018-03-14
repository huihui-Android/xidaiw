package xidaiw.find.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xidaiw.btj.R;

public class HelpCenterActivity extends AppCompatActivity {
    private ImageView ivBack;
    private TextView tvHeader;
    private LinearLayout llCustomer1,llCustomer2,llUser,llWithdraw,llRecharge,llBox,llBank,llInvest;
    private RelativeLayout rlQuestion1,rlQuestion2,rlQuestion3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
        initViews();
        tvHeader.setText("帮助中心");
        bindViews();
    }

    private void bindViews() {
        MyOnclickListener listener=new MyOnclickListener();
        ivBack.setOnClickListener(listener);
        llCustomer1.setOnClickListener(listener);
        llCustomer2.setOnClickListener(listener);
        rlQuestion1.setOnClickListener(listener);
        rlQuestion2.setOnClickListener(listener);
        rlQuestion3.setOnClickListener(listener);
        llUser.setOnClickListener(listener);
        llRecharge.setOnClickListener(listener);
        llWithdraw.setOnClickListener(listener);
        llBox.setOnClickListener(listener);
        llBank.setOnClickListener(listener);
        llInvest.setOnClickListener(listener);
    }

    private void initViews() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        llCustomer1= (LinearLayout) findViewById(R.id.ll_customer_1);
        llCustomer2= (LinearLayout) findViewById(R.id.ll_customer_2);
        llUser= (LinearLayout) findViewById(R.id.ll_user);
        llWithdraw= (LinearLayout) findViewById(R.id.ll_withdraw);
        llRecharge= (LinearLayout) findViewById(R.id.ll_recharge);
        llBox= (LinearLayout) findViewById(R.id.ll_box);
        llBank= (LinearLayout) findViewById(R.id.ll_bank);
        llInvest= (LinearLayout) findViewById(R.id.ll_invest);
        rlQuestion1= (RelativeLayout) findViewById(R.id.rl_question_1);
        rlQuestion2= (RelativeLayout) findViewById(R.id.rl_question_2);
        rlQuestion3= (RelativeLayout) findViewById(R.id.rl_question_3);
    }
    private class MyOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.ll_customer_1:

                    break;
                case R.id.ll_customer_2:

                    break;
                case R.id.rl_question_1:

                    break;
                case R.id.rl_question_2:

                    break;
                case R.id.rl_question_3:

                    break;
                case R.id.ll_user:

                    break;
                case R.id.ll_invest:

                    break;
                case R.id.ll_box:

                    break;
                case R.id.ll_recharge:

                    break;
                case R.id.ll_withdraw:

                    break;
                case R.id.ll_bank:

                    break;
            }
        }
    }
}
