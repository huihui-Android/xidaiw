package xidaiw.index.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.xidaiw.btj.R;

import org.json.JSONObject;

import java.util.ArrayList;

import xidaiw.util.WXShare;
import xidaiw.widget.RewritePopwindow;

public class InviteAwardActivity extends Activity implements View.OnClickListener{
    private TextView tvLookDetail,tvEllipse;
    private TextView tvHeader;
    private ImageView ivAward1;
    private ImageView ivAward2;
    private ImageView ivAward3;
    private Button btnInvite;
    private ImageView ivYqjl;
    private LinearLayout llYqjl;
    private RewritePopwindow mPopwindow;
    private ImageView ivBack;
    private ImageView ivClose;
    private Tencent mTencent;
    private static final String mAppid = "1106268541";
    private String Ellipse="1599****2513获得50.00元现金红包        1573****2663获得200.00元现金红包       1368****1355获得20.00元现金红包        1800****3185获得100.00元现金红包        1898****3857获得50.00元现金红包" +
            "         1539****2503获得100.00元现金红包        1375****4637获得20.00元现金红包       1348****1755获得50.00元现金红包        1803****1355获得200.00元现金红包        1895****2567获得150.00元现金红包" +
            "          1589****2111获得10.00元现金红包       1873****2613获得30.00元现金红包        1398****1858获得100.00元现金红包        1891****1835获得10.00元现金红包        1393****5227获得50.00元现金红包" +
            "        1593****0518获得50.00元现金红包       1592****2723获得50.00元现金红包        1378****1805获得30.00元现金红包        1863****0153获得500.00元现金红包        1597****5140获得150.00元现金红包";
    private String shareTitle="喜袋网-专业、安全、稳健、高效的理财平台!";
    private String shareSummary="注册喜袋网会员送金币,送积分,更有理财大礼包等您来领哦!";
    private String shareImageUrl="http://101.37.174.8/ftp_user/app/thumb.png";
    private String shareURL="http://m.xidaiw.com/wap/recommend1";
    private ArrayList<String> shareImageList=new ArrayList<String>();
    private WXShare wxShare;
    private static final String WXID = "wxa1453efebee9360d";    //这个APP_ID就是注册APP的时候生成的
//    private static final String APP_SECRET = "12312312313212313213213";

    public IWXAPI api;      //这个
    private String mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_invite_award);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initViews();
        //绑定点击事件
        tvEllipse.setText(Ellipse);
        tvHeader.setText("邀请有礼");
        bindClickEvents();
        SharedPreferences sp  = getSharedPreferences("data", MODE_PRIVATE);
        mobile = sp.getString("mobile", "");
        if (mTencent == null) {
            mTencent = Tencent.createInstance(mAppid, this.getApplicationContext());//QQ分享
        }
        shareImageList.add(shareImageUrl);//此处给QQ空间分享加数据
    }
    private void bindClickEvents() {
        btnInvite.setOnClickListener(this);
        tvLookDetail.setOnClickListener(this);
        ivAward1.setOnClickListener(this);
        ivAward2.setOnClickListener(this);
        ivAward3.setOnClickListener(this);
        ivBack.setOnClickListener(this);
//        ivClose.setOnClickListener(this);
    }


    private void initViews() {
        ivBack=findViewById(R.id.iv_back);
        tvEllipse=findViewById(R.id.tv_ellipse);
//        ivClose=findViewById(R.id.iv_close);
        tvLookDetail=findViewById(R.id.tv_lookDetail);
        ivAward1=findViewById(R.id.iv_award1);
        ivAward2=findViewById(R.id.iv_award2);
        ivAward3=findViewById(R.id.iv_award3);
        btnInvite=findViewById(R.id.btn_invite);
        ivYqjl=findViewById(R.id.iv_yqjl);
        llYqjl=findViewById(R.id.ll_yqjl);
        tvHeader=findViewById(R.id.tv_header);
    }
    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            mPopwindow.dismiss();
            mPopwindow.backgroundAlpha(InviteAwardActivity.this, 1f);
            switch (v.getId()) {
                case R.id.ll_wx_share:
                    wxShare(SendMessageToWX.Req.WXSceneSession);//设置发送给朋友
                    break;
                case R.id.ll_wxFriends:
                    wxShare(SendMessageToWX.Req.WXSceneTimeline);//设置发送给朋友圈
                    break;
                case R.id.ll_qq:
                    qqShare();
                    break;
                case R.id.ll_qq_zone:
                    shareToQzone ();
                    break;
                case R.id.ll_textMessage:
                    doSendSMSTo("",shareTitle+shareSummary+shareURL+"/"+mobile);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_invite:
                mPopwindow = new RewritePopwindow(InviteAwardActivity.this, itemsOnClick);
                mPopwindow.showAtLocation(v, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
            case R.id.tv_lookDetail:
                jumpToAwardDetal(0);
                break;
            case R.id.iv_award1:
                jumpToAwardDetal(0);
                break;
            case R.id.iv_award2:
                jumpToAwardDetal(1);
                break;
            case R.id.iv_award3:
                jumpToAwardDetal(2);
                break;
            case R.id.iv_back:
                finish();
                break;
//            case R.id.iv_close:
//
//                break;
        }
    }
    //QQ分享的回调
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
    /*
        QQ分享
     */
    private void qqShare() {
        if (mobile.isEmpty()){
            Toast.makeText(this,"请先登录,再分享",Toast.LENGTH_SHORT).show();
            return;
        }
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, shareTitle);
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, shareSummary );
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, shareURL+"/"+mobile);
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL,shareImageUrl);
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME,  "喜袋网");
        mTencent.shareToQQ(InviteAwardActivity.this, params, new BaseUiListener());
    }
    /*
        QQ空间分享
    */
    private void shareToQzone () {
        if (mobile.isEmpty()){
            Toast.makeText(this,"请先登录,再分享",Toast.LENGTH_SHORT).show();
            return;
        }
        final Bundle params = new Bundle();
        //分享类型
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, shareTitle);//必填
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, shareSummary);//选填
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, shareURL+"/"+mobile);//必填
        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, shareImageList);
        mTencent.shareToQzone(InviteAwardActivity.this, params, new BaseUiListener());
    }
    /*
    微信分享  微信好友 朋友圈
    */
    public void wxShare(int type) {
        if (mobile.isEmpty()){
            Toast.makeText(this,"请先登录,再分享",Toast.LENGTH_SHORT).show();
            return;
        }
        api = WXAPIFactory.createWXAPI(this, WXID, true);
        if(!api.isWXAppInstalled()){
            Toast.makeText(this,"您没有安装微信",Toast.LENGTH_SHORT).show();
            return ;
        }
        api.registerApp(WXID);
        WXWebpageObject wxWebpageObject = new WXWebpageObject();
        wxWebpageObject.webpageUrl=shareURL+"/"+mobile;
        WXMediaMessage msg = new WXMediaMessage(wxWebpageObject);  //这个对象是用来包裹发送信息的对象
        msg.title = shareTitle;
        msg.description=shareSummary;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.thumb);
        msg.setThumbImage(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();    //创建一个请求对象
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = msg;  //把msg放入请求对象中
        req.scene = type;   //设置发送给朋友
        api.sendReq(req);   //如果调用成功微信,会返回true
    }
    /**
     * 调起系统发短信功能
     * @param phoneNumber
     * @param message
     */
    public void doSendSMSTo(String phoneNumber,String message){
        if (mobile.isEmpty()){
            Toast.makeText(this,"请先登录,再分享",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phoneNumber));
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }
    public void jumpToAwardDetal(int index){
        Intent intent=new Intent(this,AwardDetailActivity.class);
        intent.putExtra("awardExtra",index);
        startActivity(intent);
    }
}

