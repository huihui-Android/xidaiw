package xidaiw.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xidaiw.btj.R;

public class MyInvestActivity extends AppCompatActivity {
    private RelativeLayout rlJymx,rlTzjl;
    private ImageView ivBack,ivHelp;
    private TextView tvHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_invest);
        initView();
        tvHeader.setText("我的投资");
        ivHelp.setVisibility(View.VISIBLE);
        bindView();
    }

    private void bindView() {
        MyOnclickListener listener=new MyOnclickListener();
        ivHelp.setOnClickListener(listener);
        ivBack.setOnClickListener(listener);
        rlTzjl.setOnClickListener(listener);
        rlJymx.setOnClickListener(listener);
    }

    private void initView() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        ivHelp= (ImageView) findViewById(R.id.iv_help);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        rlJymx= (RelativeLayout) findViewById(R.id.rl_jymx);
        rlTzjl= (RelativeLayout) findViewById(R.id.rl_tzjl);
    }
    private class MyOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.iv_help:
                    Toast.makeText(MyInvestActivity.this, "我是帮助", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rl_tzjl:
                    Toast.makeText(MyInvestActivity.this, "我是投资记录", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rl_jymx:
                    Intent investRecord = new Intent(MyInvestActivity.this,TransactionDetailActivity.class);
                    startActivity(investRecord);
                    break;
            }
        }
    }
}
