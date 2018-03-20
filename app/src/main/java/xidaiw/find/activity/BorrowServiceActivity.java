package xidaiw.find.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.xidaiw.btj.R;

import xidaiw.mine.activity.UserProtocolActivity;
import xidaiw.util.DensityUtil;
import xidaiw.util.HttpClient;
import xidaiw.widget.MyImageView;

public class BorrowServiceActivity extends AppCompatActivity {
    private LinearLayout llCommonProblem1,llCommonProblem2,llCommonProblem3,llCommonProblem4;//常见问题
    private ImageView ivCommonProblem1,ivCommonProblem2,ivCommonProblem3,ivCommonProblem4;
    private TextView tvCommonProblem1,tvCommonProblem2,tvCommonProblem3,tvCommonProblem4;
    private boolean isCommonProblem1 =true,isCommonProblem2 =true,isCommonProblem3 =true,isCommonProblem4 =true;

    private RelativeLayout rlApplicationRequirement,rlApplicationData,rlCommonProblems;
    private ImageView ivApplicationRequirement,ivApplicationData,ivCommonProblems;
    private TextView tvApplicationRequirement,tvApplicationData;
    private LinearLayout llCommonProblems;
    private boolean isApplication1=true,isApplication2=true,isApplication3=true;

    private ImageView ivBack;
    private TextView tvHeader;
    private TextView tvUserProtocol;

    private LinearLayout llCity,llMobile,llVerify,llBorrowType,llSex;
    private EditText etCity,etMobile,etVerify,etBorrowType,etSex;

    private CheckBox cbAgree;
    private TextView tvRefreshVerify;

    private Button btnConfirm1,btnConfirm2;
    private MyImageView ivVerify;
    private PopupWindow borrowTypePop =null;
    private PopupWindow cityPop=null;
    private PopupWindow sexPop=null;

    private LinearLayout llRefreshVerify;
    private LinearLayout llSmsCode;
    private TextView tvGetTextCode;
    private static final String TAG = "BorrowServiceActivity";


    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    if (msg.arg1 == 0) {
                        tvGetTextCode.setText("重新获取");
                        tvGetTextCode.setClickable(true);
                    } else {
                        tvGetTextCode.setText( msg.arg1 + "秒后重新获取");
                        tvGetTextCode.setClickable(false);
                    }
                    break;
            }
        }
    };
    private String type;
    private String mobile;
    private String verify;
    private String sex;
    private String city;
    private EditText etSmsCode;
    private String smsCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_service);
        initViews();
        tvHeader.setText("借款服务");
        bindEvents();
        ivVerify.setImageURL("http://mb.xidaiw.com/Index/verify");
        etBorrowType.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                etBorrowType.setInputType(InputType.TYPE_NULL);
                if (borrowTypePop ==null){
                    borrowTypePop = new PopupWindow(BorrowServiceActivity.this);
                }
                View view = View.inflate(BorrowServiceActivity.this, R.layout.borrow_money_type, null);
                borrowTypePop.setContentView(view);
                borrowTypePop.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
                borrowTypePop.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
                borrowTypePop.setBackgroundDrawable(new BitmapDrawable());
                borrowTypePop.showAsDropDown(llBorrowType,0, DensityUtil.dip2px(BorrowServiceActivity.this,5));
                view.findViewById(R.id.tv_borrow_money_type_1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etBorrowType.setText("车辆抵押贷款");
                        borrowTypePop.dismiss();
                    }
                });
                view.findViewById(R.id.tv_borrow_money_type_2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etBorrowType.setText("企事业公务员信用贷款");
                        borrowTypePop.dismiss();
                    }
                });
                view.findViewById(R.id.tv_borrow_money_type_3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etBorrowType.setText("二手车分期贷款");
                        borrowTypePop.dismiss();
                    }
                });
                view.findViewById(R.id.tv_borrow_money_type_4).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etBorrowType.setText("新车分期贷款");
                        borrowTypePop.dismiss();
                    }
                });
                borrowTypePop.setOutsideTouchable(true);
                //borrowTypePop.setFocusable(true);
                return true;
            }
        });
        etCity.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (cityPop==null){
                    cityPop = new PopupWindow(BorrowServiceActivity.this);
                }
                etSex.setInputType(InputType.TYPE_NULL);
                View view = View.inflate(BorrowServiceActivity.this, R.layout.borrow_money_city, null);
                cityPop.setContentView(view);
                cityPop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                cityPop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                cityPop.setBackgroundDrawable(null);
                view.findViewById(R.id.ll_shenzhen).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etCity.setText("深圳市");
                        cityPop.dismiss();
                    }
                });
                view.findViewById(R.id.ll_huizhou).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etCity.setText("惠州市");
                        cityPop.dismiss();
                    }
                });
                cityPop.showAsDropDown(llCity,0,DensityUtil.dip2px(BorrowServiceActivity.this,5));
                cityPop.setOutsideTouchable(true);

                return true;
            }
        });
        etSex.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (sexPop==null){
                    sexPop = new PopupWindow(BorrowServiceActivity.this);
                }

                View view = View.inflate(BorrowServiceActivity.this, R.layout.borrow_money_sex, null);
                sexPop.setContentView(view);
                sexPop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                sexPop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                sexPop.setBackgroundDrawable(null);
                view.findViewById(R.id.tv_male).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etSex.setText("先生");
                        sexPop.dismiss();
                    }
                });
                view.findViewById(R.id.tv_female).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etSex.setText("女士");
                        sexPop.dismiss();
                    }
                });
                sexPop.showAsDropDown(llSex,0,DensityUtil.dip2px(BorrowServiceActivity.this,5));
                sexPop.setOutsideTouchable(true);
                return true;
            }
        });
    }

    private void bindEvents() {
        MyOnclickListener listener=new MyOnclickListener();
        ivBack.setOnClickListener(listener);
        llCommonProblem1.setOnClickListener(listener);
        llCommonProblem2.setOnClickListener(listener);
        llCommonProblem3.setOnClickListener(listener);
        llCommonProblem4.setOnClickListener(listener);
        rlApplicationData.setOnClickListener(listener);
        rlApplicationRequirement.setOnClickListener(listener);
        rlCommonProblems.setOnClickListener(listener);
        tvUserProtocol.setOnClickListener(listener);
        tvRefreshVerify.setOnClickListener(listener);
        btnConfirm1.setOnClickListener(listener);
        btnConfirm2.setOnClickListener(listener);
        ivVerify.setOnClickListener(listener);
        //llBorrowType.setOnClickListener(listener);
        llCity.setOnClickListener(listener);
        llMobile.setOnClickListener(listener);
        llVerify.setOnClickListener(listener);
        //etBorrowType.setOnClickListener(listener);
        tvGetTextCode.setOnClickListener(listener);


    }

    private void initViews() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        llCommonProblem1= (LinearLayout) findViewById(R.id.ll_common_problem1);
        llCommonProblem2= (LinearLayout) findViewById(R.id.ll_common_problem2);
        llCommonProblem3= (LinearLayout) findViewById(R.id.ll_common_problem3);
        llCommonProblem4= (LinearLayout) findViewById(R.id.ll_common_problem4);
        ivCommonProblem1= (ImageView) findViewById(R.id.iv_common_problem1);
        ivCommonProblem2= (ImageView) findViewById(R.id.iv_common_problem2);
        ivCommonProblem3= (ImageView) findViewById(R.id.iv_common_problem3);
        ivCommonProblem4= (ImageView) findViewById(R.id.iv_common_problem4);
        tvCommonProblem1= (TextView) findViewById(R.id.tv_common_problem1);
        tvCommonProblem2= (TextView) findViewById(R.id.tv_common_problem2);
        tvCommonProblem3= (TextView) findViewById(R.id.tv_common_problem3);
        tvCommonProblem4= (TextView) findViewById(R.id.tv_common_problem4);
        rlApplicationRequirement= (RelativeLayout) findViewById(R.id.rl_application_requirement);
        rlApplicationData= (RelativeLayout) findViewById(R.id.rl_application_data);
        rlCommonProblems= (RelativeLayout) findViewById(R.id.rl_common_problems);
        ivApplicationRequirement= (ImageView) findViewById(R.id.iv_application_requirement);
        ivApplicationData= (ImageView) findViewById(R.id.iv_application_data);
        ivCommonProblems= (ImageView) findViewById(R.id.iv_common_problems);
        tvApplicationRequirement= (TextView) findViewById(R.id.tv_application_requirement);
        tvApplicationData= (TextView) findViewById(R.id.tv_application_data);
        llCommonProblems= (LinearLayout) findViewById(R.id.ll_common_problems);
        tvUserProtocol= (TextView) findViewById(R.id.tv_user_protocol);
        llCity= (LinearLayout) findViewById(R.id.ll_city);
        llMobile= (LinearLayout) findViewById(R.id.ll_mobile);
        llVerify= (LinearLayout) findViewById(R.id.ll_verify);
        llBorrowType= (LinearLayout) findViewById(R.id.ll_borrow_type);
        etCity= (EditText) findViewById(R.id.et_city);
        etMobile= (EditText) findViewById(R.id.et_mobile);
        etVerify= (EditText) findViewById(R.id.et_verify);
        etBorrowType= (EditText) findViewById(R.id.et_borrow_type);
        cbAgree= (CheckBox) findViewById(R.id.cb_agree);
        tvRefreshVerify= (TextView) findViewById(R.id.tv_refresh_verify);
        btnConfirm1= (Button) findViewById(R.id.btn_confirm1);
        btnConfirm2= (Button) findViewById(R.id.btn_confirm2);
        ivVerify= (MyImageView) findViewById(R.id.iv_verify);
        llSex= (LinearLayout) findViewById(R.id.ll_sex);
        etSex= (EditText) findViewById(R.id.et_sex);
        llSmsCode= (LinearLayout) findViewById(R.id.ll_sms_code);
        llRefreshVerify= (LinearLayout) findViewById(R.id.ll_refresh_verify);
        tvGetTextCode= (TextView) findViewById(R.id.tv_getTextCode);
        etSmsCode = (EditText) findViewById(R.id.et_sms_code);
    }

    public void getSmsCode() {
        String mobile = etMobile.getText().toString().trim();
        RequestParams params=new RequestParams();
        params.put("phonenum",mobile);
        HttpClient.post(BorrowServiceActivity.this,"http://mb.xidaiw.com/loan/getSMSCode",params,new GetSmsCodeResponseHandler());


    }

    private class MyOnclickListener implements View.OnClickListener{



        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ll_common_problem1:
                    if (isCommonProblem1){
                        ivCommonProblem1.setImageResource(R.mipmap.arrow_up);
                        tvCommonProblem1.setVisibility(View.VISIBLE);
                        isCommonProblem1 =false;
                    }else {
                        ivCommonProblem1.setImageResource(R.mipmap.arrow_down);
                        tvCommonProblem1.setVisibility(View.GONE);
                        isCommonProblem1 =true;
                    }
                    break;
                case R.id.ll_common_problem2:
                    if (isCommonProblem2){
                        ivCommonProblem2.setImageResource(R.mipmap.arrow_up);
                        tvCommonProblem2.setVisibility(View.VISIBLE);
                        isCommonProblem2 =false;
                    }else {
                        ivCommonProblem2.setImageResource(R.mipmap.arrow_down);
                        tvCommonProblem2.setVisibility(View.GONE);
                        isCommonProblem2 =true;
                    }
                    break;
                case R.id.ll_common_problem3:
                    if (isCommonProblem3){
                        ivCommonProblem3.setImageResource(R.mipmap.arrow_up);
                        tvCommonProblem3.setVisibility(View.VISIBLE);
                        isCommonProblem3 =false;
                    }else {
                        ivCommonProblem3.setImageResource(R.mipmap.arrow_down);
                        tvCommonProblem3.setVisibility(View.GONE);
                        isCommonProblem3 =true;
                    }
                    break;
                case R.id.ll_common_problem4:
                    if (isCommonProblem4){
                        ivCommonProblem4.setImageResource(R.mipmap.arrow_up);
                        tvCommonProblem4.setVisibility(View.VISIBLE);
                        isCommonProblem4 =false;
                    }else {
                        ivCommonProblem4.setImageResource(R.mipmap.arrow_down);
                        tvCommonProblem4.setVisibility(View.GONE);
                        isCommonProblem4 =true;
                    }
                    break;
                case R.id.rl_application_requirement:
                    if (isApplication1){
                        isApplication1=false;
                        ivApplicationRequirement.setImageResource(R.mipmap.jt1);
                        tvApplicationRequirement.setVisibility(View.VISIBLE);
                    }else{
                        isApplication1=true;
                        ivApplicationRequirement.setImageResource(R.mipmap.jt2);
                        tvApplicationRequirement.setVisibility(View.GONE);
                    }
                    break;
                case R.id.rl_application_data:
                    if (isApplication2){
                        isApplication2=false;
                        ivApplicationData.setImageResource(R.mipmap.jt1);
                        tvApplicationData.setVisibility(View.VISIBLE);
                    }else{
                        isApplication2=true;
                        ivApplicationData.setImageResource(R.mipmap.jt2);
                        tvApplicationData.setVisibility(View.GONE);
                    }
                    break;
                case R.id.rl_common_problems:
                    if (isApplication3){
                        isApplication3=false;
                        ivCommonProblems.setImageResource(R.mipmap.jt1);
                        llCommonProblems.setVisibility(View.VISIBLE);
                    }else{
                        isApplication3=true;
                        ivCommonProblems.setImageResource(R.mipmap.jt2);
                        llCommonProblems.setVisibility(View.GONE);
                    }
                    break;
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.tv_user_protocol:
                    Intent userProtocol=new Intent(BorrowServiceActivity.this, UserProtocolActivity.class);
                    startActivity(userProtocol);
                    break;
                case R.id.tv_refresh_verify:
                    ivVerify.setImageURL("http://mb.xidaiw.com/Index/verify");
                    break;
                case R.id.btn_confirm1:
                    type = etBorrowType.getText().toString().trim();
                    city = etCity.getText().toString().trim();
                    mobile = etMobile.getText().toString().trim();
                    verify = etVerify.getText().toString().trim();
                    sex = etSex.getText().toString().trim();

                    if (TextUtils.isEmpty(city)){
                        Toast.makeText(BorrowServiceActivity.this, "请选择您所在的城市", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(mobile)){
                        Toast.makeText(BorrowServiceActivity.this, "请输入您的手机号码", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(verify)){
                        Toast.makeText(BorrowServiceActivity.this, "请输入图片验证码", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (!cbAgree.isChecked()){
                        Toast.makeText(BorrowServiceActivity.this, "请同意《喜袋网用户使用协议》", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        checkMobile();
                    }
                    break;
                case R.id.btn_confirm2:
                    type = etBorrowType.getText().toString().trim();
                    city = etCity.getText().toString().trim();
                    mobile = etMobile.getText().toString().trim();
                    sex = etSex.getText().toString().trim();
                    smsCode = etSmsCode.getText().toString().trim();

                    if (TextUtils.isEmpty(city)){
                        Toast.makeText(BorrowServiceActivity.this, "请选择您所在的城市", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(mobile)){
                        Toast.makeText(BorrowServiceActivity.this, "请输入您的手机号码", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(smsCode)){
                        Toast.makeText(BorrowServiceActivity.this, "请输入动态密码", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (!cbAgree.isChecked()){
                        Toast.makeText(BorrowServiceActivity.this, "请同意《喜袋网用户使用协议》", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        RequestParams params=new RequestParams();
                        params.put("mortgage",type);
                        params.put("city",city);
                        params.put("mobile",mobile);
                        params.put("sms_code",smsCode);
                        params.put("sex",sex);
                        HttpClient.post(BorrowServiceActivity.this,"http://mb.xidaiw.com/loan/checkSMSCode",params,new CheckSmsCodeResponseHandler());
                    }
                    break;
                case R.id.iv_verify:
                    ivVerify.setImageURL("http://mb.xidaiw.com/Index/verify");
                    break;
                case R.id.ll_city:

                    break;
                case R.id.ll_verify:

                    break;
                case R.id.ll_mobile:

                    break;
                case R.id.tv_getTextCode:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 59; i >= 0; i--) {
                                Message msg = handler.obtainMessage();
                                msg.arg1 = i;
                                handler.sendMessage(msg);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();
                    break;
            }
        }
    }

    private class CheckVerifyResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.d(TAG, "CheckVerifyResponseHandler: "+s);
            if (s.equals("\"img_code_verfi_fail\"")){
                llSmsCode.setVisibility(View.VISIBLE);
                btnConfirm2.setVisibility(View.VISIBLE);
                btnConfirm1.setVisibility(View.GONE);
                tvGetTextCode.setVisibility(View.VISIBLE);
                llRefreshVerify.setVisibility(View.GONE);
                llVerify.setVisibility(View.GONE);
                getSmsCode();
            }
        }
    }

    private void checkMobile(){
        String mobile = etMobile.getText().toString().trim();
        RequestParams params = new RequestParams();
        params.put("mobile",mobile);
        HttpClient.post(BorrowServiceActivity.this,"http://mb.xidaiw.com/loan/checkphone",params,new CheckMobileResponseHandler());
    }

    private class CheckMobileResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.d(TAG, "CheckMobileResponseHandler: "+s);
            if (s.equals("\"mobile_have_register\"")){
                Toast.makeText(BorrowServiceActivity.this, "该手机号已经注册过了!", Toast.LENGTH_SHORT).show();
                return;
            }else if (s.equals("\"mobile_no_register\"")){
                RequestParams params=new RequestParams();
                params.put("mortgage",type);
                params.put("city",city);
                params.put("mobile",mobile);
                params.put("verify",verify);
                params.put("sex",sex);
                HttpClient.post(BorrowServiceActivity.this, "http://mb.xidaiw.com/Index/loan",params,new CheckVerifyResponseHandler());
            }
        }
    }

    private class CheckSmsCodeResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.d(TAG, "CheckSmsCodeResponseHandler: "+s);
            if (s.equals("\"sms_code_verfi_fail\"")){
                Toast.makeText(BorrowServiceActivity.this, "短信密码不正确!", Toast.LENGTH_SHORT).show();
                return;
            }else if (s.equals("\"sms_code_overtime\"")){
                Toast.makeText(BorrowServiceActivity.this, "短信密码已失效,请重新获取!", Toast.LENGTH_SHORT).show();
                return;
            }else if (s.equals("\"sms_code_verfi_ture\"")){
                AlertDialog.Builder dialog=new AlertDialog.Builder(BorrowServiceActivity.this);
                dialog.setMessage("你已经申请成功，稍后喜袋网工作人员和你联系，请保持手机畅通！");
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
                dialog.show();
            }
        }
    }

    private class GetSmsCodeResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.d(TAG, "GetSmsCodeResponseHandler: "+s);
            if (s.equals("\"code_send_success\"")){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 59; i >= 0; i--) {
                            Message msg = handler.obtainMessage();
                            msg.arg1 = i;
                            handler.sendMessage(msg);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }else{
                Toast.makeText(BorrowServiceActivity.this, "获取短息密码失败!", Toast.LENGTH_SHORT).show();
                return;
            }

        }
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (borrowTypePop!=null&&borrowTypePop.isShowing()){
//            borrowTypePop.dismiss();
//            borrowTypePop=null;
//        }
//        return super.onTouchEvent(event);
//
//    }
}
