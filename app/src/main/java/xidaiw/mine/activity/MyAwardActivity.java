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

public class MyAwardActivity extends AppCompatActivity {
    private TextView tvHeader,tvRedPacketFlag,tvVoucherFlag;
    private ImageView ivBack;
    private RelativeLayout rlRedPacket,rlVoucher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_award);
        initViews();
        tvHeader.setText("我的奖励");
        bindViews();
    }
    private void bindViews() {
        MyOnclickListener listener=new MyOnclickListener();
        ivBack.setOnClickListener(listener);
        rlRedPacket.setOnClickListener(listener);
        rlVoucher.setOnClickListener(listener);
    }

    private void initViews() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        tvRedPacketFlag= (TextView) findViewById(R.id.tv_red_packet_flag);
        tvVoucherFlag= (TextView) findViewById(R.id.tv_voucher_flag);
        rlRedPacket= (RelativeLayout) findViewById(R.id.rl_red_packet);
        rlVoucher= (RelativeLayout) findViewById(R.id.rl_voucher);

    }
    private class MyOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.rl_red_packet:
                    Intent redpacket=new Intent(MyAwardActivity.this,RedPacketActivity.class);
                    startActivity(redpacket);
                    break;
                case R.id.rl_voucher:
                    Toast.makeText(MyAwardActivity.this, "我是代金券", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
