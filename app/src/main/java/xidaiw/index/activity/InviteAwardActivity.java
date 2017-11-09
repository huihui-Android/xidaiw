package xidaiw.index.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.xidaiw.btj.R;

import org.json.JSONObject;

import java.util.ArrayList;

import xidaiw.widget.RewritePopwindow;

public class InviteAwardActivity extends Activity implements View.OnClickListener{
    private TextView tvLookDetail;
    private ImageView ivAward1;
    private ImageView ivAward2;
    private ImageView ivAward3;
    private Button btnInvite;
    private ImageView ivYqjl;
    private LinearLayout llYqjl;
    private RewritePopwindow mPopwindow;
    private Tencent mTencent;
    private static final String mAppid = "1106268541";
    private String shareTitle="注册喜袋网会员送金币,送积分,更有理财大礼包等您来领哦!";
    private String shareSummary="注册喜袋网会员送金币,送积分,更有理财大礼包等您来领哦!";
    private String shareImageUrl="http://101.37.174.8/ftp_user/app/thumb.png";
    private String shareURL="http://m.xidaiw.com/wap/recommend1";
    private ArrayList<String> shareImageList=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_invite_award);
        initViews();
        //绑定点击事件
        bindClickEvents();
        if (mTencent == null) {
            mTencent = Tencent.createInstance(mAppid, this.getApplicationContext());//QQ分享
        }
        shareImageList.add(shareImageUrl);//此处给QQ空间分享加数据
    }
    private void bindClickEvents() {
        btnInvite.setOnClickListener(this);
        tvLookDetail.setOnClickListener(this);
    }


    private void initViews() {
        tvLookDetail=findViewById(R.id.tv_lookDetail);
        ivAward1=findViewById(R.id.iv_award1);
        ivAward2=findViewById(R.id.iv_award2);
        ivAward3=findViewById(R.id.iv_award3);
        btnInvite=findViewById(R.id.btn_invite);
        ivYqjl=findViewById(R.id.iv_yqjl);
        llYqjl=findViewById(R.id.ll_yqjl);
    }
    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            mPopwindow.dismiss();
            mPopwindow.backgroundAlpha(InviteAwardActivity.this, 1f);
            switch (v.getId()) {
                case R.id.ll_wx_share:
                    Toast.makeText(InviteAwardActivity.this, "微信好友", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_wxFriends:
                    Toast.makeText(InviteAwardActivity.this, "朋友圈", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_qq:
                    qqShare();
                    break;
                case R.id.ll_qq_zone:
                    shareToQzone ();
                    //Toast.makeText(InviteAwardActivity.this, "QQ空间", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_textMessage:
                    Toast.makeText(InviteAwardActivity.this, "短息", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }

    };

    private void qqShare() {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, shareTitle);
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, shareSummary );
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, shareURL);
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL,shareImageUrl);
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME,  "喜袋网");
        mTencent.shareToQQ(InviteAwardActivity.this, params, new BaseUiListener());
    }
    private void shareToQzone () {
        final Bundle params = new Bundle();
        //分享类型
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, shareTitle);//必填
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, shareSummary);//选填
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, shareURL);//必填
        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, shareImageList);
        mTencent.shareToQzone(InviteAwardActivity.this, params, new BaseUiListener());
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_invite:
                mPopwindow = new RewritePopwindow(InviteAwardActivity.this, itemsOnClick);
                mPopwindow.showAtLocation(v, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
            case R.id.tv_lookDetail:
                Toast.makeText(InviteAwardActivity.this, "查看详情", Toast.LENGTH_SHORT).show();
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_API) {
            Toast.makeText(InviteAwardActivity.this, "还回", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private class BaseUiListener implements IUiListener {
        @Override
        public void onComplete(Object response) {
            //V2.0版本，参数类型由JSONObject 改成了Object,具体类型参考api文档
            Toast.makeText(InviteAwardActivity.this, "onComplete", Toast.LENGTH_SHORT).show();
        }
        protected void doComplete(JSONObject values) {

        }
        @Override
        public void onError(UiError e) {
            Toast.makeText(InviteAwardActivity.this, "onError"+e, Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onCancel() {
            Toast.makeText(InviteAwardActivity.this, "onCancel", Toast.LENGTH_SHORT).show();
        }
    }
}

