package xidaiw.find.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xidaiw.btj.R;

public class Attention2WxActivity extends AppCompatActivity {
    private String html="打开微信,点击右上角的<img src=\""+R.drawable.attention_wx_add+"\" style=\"width:2px;\"/>,再点击\"添加朋友\"下的,\"公众号\"";
    private String html1="打开微信,点击右上角的<small><img src=\""+R.drawable.attention_wx_add+"\"/></small>,再点击“添加朋友”下的,“公众号”";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention2_wx);
        ImageView ivBack= (ImageView) findViewById(R.id.iv_back);
        TextView tvHeader= (TextView) findViewById(R.id.tv_header);
        TextView tvStep1= (TextView) findViewById(R.id.tv_step_1);
        tvHeader.setText("关注微信");
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvStep1.setText(Html.fromHtml(html, new ProImageGetter(), null));
    }
    /**
     * 项目资源图片
     * @author Susie
     */
    private final class ProImageGetter implements Html.ImageGetter{

        @Override
        public Drawable getDrawable(String source) {
            // 获取到资源id
            int id = Integer.parseInt(source);
            Drawable drawable = getResources().getDrawable(id);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth()*2/3, drawable.getIntrinsicHeight()*2/3);
            return drawable;
        }
    }
}
