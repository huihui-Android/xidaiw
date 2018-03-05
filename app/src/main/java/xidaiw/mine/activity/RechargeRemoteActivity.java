package xidaiw.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.xidaiw.btj.R;

public class RechargeRemoteActivity extends AppCompatActivity {
    private TextView tvHeader;
    private ImageView ivBack;
    private WebView wvRecharge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_remote);
        initViews();
        tvHeader.setText("支付");
        ivBack.setOnClickListener(new MyOnclickListener());
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String relativeUrl = intent.getStringExtra("relativeUrl");
        wvRecharge.getSettings().setJavaScriptEnabled(true);
        wvRecharge.setWebViewClient(new WebViewClient());
        wvRecharge.loadUrl(url);
    }

    private void initViews() {
        tvHeader= (TextView) findViewById(R.id.tv_header);
        ivBack= (ImageView) findViewById(R.id.iv_back);
        wvRecharge= (WebView) findViewById(R.id.wv_recharge);
    }
    private class MyOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
            }
        }
    }
}
