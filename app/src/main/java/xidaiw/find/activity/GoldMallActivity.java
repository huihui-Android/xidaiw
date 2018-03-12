package xidaiw.find.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.xidaiw.btj.R;

import xidaiw.util.DensityUtil;

public class GoldMallActivity extends AppCompatActivity {
    private LinearLayout llTopup30,llTopup50,llTopup100,llTopup200,llFl,llPx;
    private TextView tvHeader,tvScore;
    private ImageView ivBack,ivFl1,ivFl2,ivPx1,ivPx2;
    private CheckBox checkBox;
    private boolean flag=false;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_mall);
        initViews();
        tvHeader.setText("金币商城");
        bindViews();

    }

    private void bindViews() {
        MyClickListener listener=new MyClickListener();
        ivBack.setOnClickListener(listener);
        llFl.setOnClickListener(listener);
        llPx.setOnClickListener(listener);
        llTopup30.setOnClickListener(listener);
        llTopup50.setOnClickListener(listener);
        llTopup100.setOnClickListener(listener);
        llTopup200.setOnClickListener(listener);
        checkBox.setOnClickListener(listener);
    }

    private void initViews() {
        llTopup30= (LinearLayout) findViewById(R.id.ll_topup_30);
        llTopup50= (LinearLayout) findViewById(R.id.ll_topup_50);
        llTopup100= (LinearLayout) findViewById(R.id.ll_topup_100);
        llTopup200= (LinearLayout) findViewById(R.id.ll_topup_200);
        llFl= (LinearLayout) findViewById(R.id.ll_fl);
        llPx= (LinearLayout) findViewById(R.id.ll_px);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvScore= (TextView) findViewById(R.id.tv_score);
        ivFl1= (ImageView) findViewById(R.id.iv_fl_1);
        ivFl2= (ImageView) findViewById(R.id.iv_fl_2);
        ivPx1= (ImageView) findViewById(R.id.iv_px_1);
        ivPx2= (ImageView) findViewById(R.id.iv_px_2);
        checkBox= (CheckBox) findViewById(R.id.checkbox);
    }
    private class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.ll_fl:
                    if (!flag){
                        ivFl1.setVisibility(View.VISIBLE);
                        ivFl2.setVisibility(View.GONE);
                        ivPx1.setVisibility(View.GONE);
                        ivPx2.setVisibility(View.VISIBLE);
                        flag=true;
                        View inflate = View.inflate(GoldMallActivity.this, R.layout.gold_mall_fl_popup_view, null);
                        popupWindow = new PopupWindow(inflate, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAsDropDown(llFl,0, DensityUtil.px2dip(GoldMallActivity.this,20));


                    }else{
                        flag=false;
                        ivFl1.setVisibility(View.GONE);
                        ivFl2.setVisibility(View.VISIBLE);
                        ivPx1.setVisibility(View.GONE);
                        ivPx2.setVisibility(View.VISIBLE);
                        popupWindow.dismiss();
                    }
                    checkBox.setChecked(false);
                    break;
                case R.id.ll_px:
                    if (!flag){
                        ivFl1.setVisibility(View.GONE);
                        ivFl2.setVisibility(View.VISIBLE);
                        ivPx1.setVisibility(View.VISIBLE);
                        ivPx2.setVisibility(View.GONE);
                        flag=true;
                    }else{
                        flag=false;
                        ivFl1.setVisibility(View.GONE);
                        ivFl2.setVisibility(View.VISIBLE);
                        ivPx1.setVisibility(View.GONE);
                        ivPx2.setVisibility(View.VISIBLE);
                    }
                    checkBox.setChecked(false);
                    break;
                case R.id.checkbox:
                        if (checkBox.isChecked()){
                            Toast.makeText(GoldMallActivity.this,"选中",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(GoldMallActivity.this,"取消",Toast.LENGTH_SHORT).show();
                        }
                        ivFl1.setVisibility(View.GONE);
                        ivFl2.setVisibility(View.VISIBLE);
                        ivPx1.setVisibility(View.GONE);
                        ivPx2.setVisibility(View.VISIBLE);
                        flag=false;
                    break;
                case R.id.ll_topup_30:

                    break;
                case R.id.ll_topup_50:

                    break;
                case R.id.ll_topup_100:

                    break;
                case R.id.ll_topup_200:

                    break;
            }
        }
    }
}
