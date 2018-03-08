package xidaiw.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
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

import xidaiw.mine.entity.InviteFriendsInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;
import xidaiw.util.WXShare;
import xidaiw.widget.RewritePopwindow;

public class InviteFriendsActivity extends AppCompatActivity {
    private ImageView ivBack;
    private TextView tvPhoneNum,tvInviteNum,tvInviteMoney,tvMyInvite,tvHeader,tvAwardRuler;
    private Button btnCopyCode,btnInvite;
    private MyOnclickListener listener;
    private static final String TAG = "InviteFriendsActivity";
    private RewritePopwindow popwindow;
    private Tencent mTencent;
    private static final String mAppid = "1106268541";
    private String shareTitle="喜袋网-专业、安全、稳健、高效的理财平台!";
    private String shareSummary="注册喜袋网会员送金币,送积分,更有理财大礼包等您来领哦!";
    private String shareImageUrl="http://101.37.174.8/ftp_user/app/thumb.png";
    private String shareURL="http://m.xidaiw.com/wap/recommend1";
    private ArrayList<String> shareImageList=new ArrayList<String>();
    private WXShare wxShare;
    private static final String WXID = "wxa1453efebee9360d";    //这个APP_ID就是注册APP的时候生成的
    public IWXAPI api;      //这个
    private String mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
        initView();
        tvHeader.setText("邀请好友");
        bindClicks();
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        mobile = sp.getString("mobile", "");
        tvPhoneNum.setText(mobile);
        HttpClient.get(this, Urls.getHost()+"/yaoqing",new InviteFriendsResponseHanlder());
    }

    private void bindClicks() {
        listener = new MyOnclickListener();
        ivBack.setOnClickListener(listener);
        btnCopyCode.setOnClickListener(listener);
        tvAwardRuler.setOnClickListener(listener);
        tvMyInvite.setOnClickListener(listener);
        btnInvite.setOnClickListener(listener);
    }

    private void initView() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        tvPhoneNum= (TextView) findViewById(R.id.tv_phoneNum);
        btnCopyCode= (Button) findViewById(R.id.btn_copy_code);
        tvMyInvite= (TextView) findViewById(R.id.tv_my_invite);
        tvAwardRuler= (TextView) findViewById(R.id.tv_award_ruler);
        btnInvite= (Button) findViewById(R.id.btn_invite);
        tvInviteNum= (TextView) findViewById(R.id.tv_inviteNum);
        tvInviteMoney= (TextView) findViewById(R.id.tv_invite_money);
    }
    private class MyOnclickListener implements View.OnClickListener{



        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.btn_copy_code:
                    ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    // 将文本内容放到系统剪贴板里。
                    cm.setText(tvPhoneNum.getText());
                    Toast.makeText(InviteFriendsActivity.this, "邀请码复制成功!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tv_award_ruler:
                    Intent awardRuler=new Intent(InviteFriendsActivity.this,AwardRulerActivity.class);
                    startActivity(awardRuler);
                    break;
                case R.id.tv_my_invite:
                    Intent myInvite=new Intent(InviteFriendsActivity.this,MyInviteActivity.class);
                    startActivity(myInvite);
                    break;
                case R.id.btn_invite:
                    popwindow = new RewritePopwindow(InviteFriendsActivity.this, new OnItemClick());
                    popwindow.showAtLocation(v, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    break;
            }
        }
    }

    private class InviteFriendsResponseHanlder extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "InviteFriendsResponseHanlder: "+s);
            InviteFriendsInfo inviteFriendsInfo = JSON.parseObject(s, InviteFriendsInfo.class);
            if (inviteFriendsInfo.isSuccess()){
                InviteFriendsInfo.DataBean data = inviteFriendsInfo.getData();
                double award = inviteFriendsInfo.getData().getAward();
                int total = inviteFriendsInfo.getData().getTotal();
                tvInviteNum.setText(total+"");
                tvInviteMoney.setText(award+"");
            }
        }
    }

    private class OnItemClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            popwindow.dismiss();
            popwindow.backgroundAlpha(InviteFriendsActivity.this, 1f);
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
    }
    //QQ分享的回调
    private class BaseUiListener implements IUiListener {
        @Override
        public void onComplete(Object response) {
            //V2.0版本，参数类型由JSONObject 改成了Object,具体类型参考api文档
            Toast.makeText(InviteFriendsActivity.this, "onComplete", Toast.LENGTH_SHORT).show();
        }
        protected void doComplete(JSONObject values) {

        }
        @Override
        public void onError(UiError e) {
            Toast.makeText(InviteFriendsActivity.this, "onError"+e, Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onCancel() {
            Toast.makeText(InviteFriendsActivity.this, "onCancel", Toast.LENGTH_SHORT).show();
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
        mTencent.shareToQQ(InviteFriendsActivity.this, params, new BaseUiListener());
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
        mTencent.shareToQzone(InviteFriendsActivity.this, params, new BaseUiListener());
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
//    public void jumpToAwardDetal(int index){
//        Intent intent=new Intent(this,AwardDetailActivity.class);
//        intent.putExtra("awardExtra",index);
//        startActivity(intent);
//    }
}
