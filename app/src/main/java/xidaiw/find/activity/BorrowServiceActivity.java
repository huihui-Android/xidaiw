package xidaiw.find.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xidaiw.btj.R;

import xidaiw.mine.activity.UserProtocolActivity;
import xidaiw.util.DensityUtil;
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

    private LinearLayout llCity,llMobile,llVerify,llBorrowType;
    private EditText etCity,etMobile,etVerify,etBorrowType;

    private CheckBox cbAgree;
    private TextView tvRefreshVerify;

    private Button btnConfirm1,btnConfirm2;
    private MyImageView ivVerify;
    private PopupWindow borrowTypepop=null;

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
                borrowTypepop = new PopupWindow(BorrowServiceActivity.this);
                View view = View.inflate(BorrowServiceActivity.this, R.layout.borrow_money_type, null);
                borrowTypepop.setContentView(view);
                borrowTypepop.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
                borrowTypepop.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
                borrowTypepop.setBackgroundDrawable(new BitmapDrawable());
                borrowTypepop.showAsDropDown(llBorrowType,0, DensityUtil.dip2px(BorrowServiceActivity.this,5));
                view.findViewById(R.id.tv_borrow_money_type_1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etBorrowType.setText("车辆抵押贷款");
                        borrowTypepop.dismiss();
                    }
                });
                view.findViewById(R.id.tv_borrow_money_type_2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etBorrowType.setText("企事业公务员信用贷款");
                        borrowTypepop.dismiss();
                    }
                });
                view.findViewById(R.id.tv_borrow_money_type_3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etBorrowType.setText("二手车分期贷款");
                        borrowTypepop.dismiss();
                    }
                });
                view.findViewById(R.id.tv_borrow_money_type_4).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etBorrowType.setText("新车分期贷款");
                        borrowTypepop.dismiss();
                    }
                });
                //borrowTypepop.setOutsideTouchable(true);
                //borrowTypepop.setFocusable(true);
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
        llBorrowType.setOnClickListener(listener);
        llCity.setOnClickListener(listener);
        llMobile.setOnClickListener(listener);
        llVerify.setOnClickListener(listener);
        //etBorrowType.setOnClickListener(listener);

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
                    String city = etCity.getText().toString().trim();
                    String mobile = etMobile.getText().toString().trim();
                    String verify = etVerify.getText().toString().trim();
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
                    Toast.makeText(BorrowServiceActivity.this, "确认1", Toast.LENGTH_SHORT).show();
                    btnConfirm2.setVisibility(View.VISIBLE);
                    btnConfirm1.setVisibility(View.GONE);
                    break;
                case R.id.btn_confirm2:
                    Toast.makeText(BorrowServiceActivity.this, "提交成功!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.iv_verify:
                    ivVerify.setImageURL("http://mb.xidaiw.com/Index/verify");
                    break;
                case R.id.et_borrow_type:
                    borrowTypepop = new PopupWindow(BorrowServiceActivity.this);

                    View view = View.inflate(BorrowServiceActivity.this, R.layout.borrow_money_type, null);
                    borrowTypepop.setContentView(view);
                    borrowTypepop.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
                    borrowTypepop.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
                    borrowTypepop.setBackgroundDrawable(null);
                    borrowTypepop.showAsDropDown(llBorrowType,0, DensityUtil.dip2px(BorrowServiceActivity.this,5));
                    view.findViewById(R.id.tv_borrow_money_type_1).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            etBorrowType.setText("车辆抵押贷款");
                            borrowTypepop.dismiss();
                        }
                    });
                    view.findViewById(R.id.tv_borrow_money_type_2).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            etBorrowType.setText("企事业公务员信用贷款");
                            borrowTypepop.dismiss();
                        }
                    });
                    view.findViewById(R.id.tv_borrow_money_type_3).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            etBorrowType.setText("二手车分期贷款");
                            borrowTypepop.dismiss();
                        }
                    });
                    view.findViewById(R.id.tv_borrow_money_type_4).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            etBorrowType.setText("新车分期贷款");
                            borrowTypepop.dismiss();
                        }
                    });
                    borrowTypepop.setOutsideTouchable(true);
                break;
                case R.id.ll_city:

                    break;
                case R.id.ll_verify:

                    break;
                case R.id.ll_mobile:

                    break;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (borrowTypepop!=null&&borrowTypepop.isShowing()){
            borrowTypepop.dismiss();
            borrowTypepop=null;
        }
        return super.onTouchEvent(event);

    }
}
