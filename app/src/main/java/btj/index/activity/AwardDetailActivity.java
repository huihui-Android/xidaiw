package btj.index.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xidaiw.btj.R;

public class AwardDetailActivity extends Activity {
    private TextView tvTitle;
    private ImageView ivBack;
    private FrameLayout flAwardContainer;
    private ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_award_detail);
        tvTitle=findViewById(R.id.tv_title);
        ivBack=findViewById(R.id.iv_back);
        tvTitle.setText("邀请有礼");
        ivBack.setImageResource(R.mipmap.back_left);
        vp=findViewById(R.id.vp_award_detail);
    }
}
