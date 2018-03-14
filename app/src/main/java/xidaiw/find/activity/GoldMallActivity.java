package xidaiw.find.activity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import xidaiw.find.entity.ExchangeInfo;
import xidaiw.mine.entity.PersonInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

import static android.view.View.VISIBLE;

public class GoldMallActivity extends AppCompatActivity {
    private LinearLayout llTopup30,llTopup50,llTopup100,llTopup200,llFl,llPx,llPxItem,llFlItem,llMask;
    private TextView tvHeader,tvScore,tvHfll,tvOther,tvIconAsc,tvIconDesc;
    private ImageView ivBack,ivFl1,ivFl2,ivPx1,ivPx2;
    private CheckBox checkBox;
    private boolean flag=false;
    private PopupWindow popupWindow;
    private static final String TAG = "GoldMallActivity";
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_mall);
        initViews();
        tvHeader.setText("金币商城");
        bindViews();
        HttpClient.get(this, Urls.getHost()+"/account/indexNew",new GoldIconHttpResponseHandler());
        //HttpClient.get(this,Urls.getHost()+"/prize/listNew?pageNow=1&pageSize=10",new GoldIconItemsResponseHandler());
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
        tvIconAsc.setOnClickListener(listener);
        tvIconDesc.setOnClickListener(listener);
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
        llFlItem= (LinearLayout) findViewById(R.id.ll_fl_item);
        llPxItem= (LinearLayout) findViewById(R.id.ll_px_item);
        tvIconAsc= (TextView) findViewById(R.id.tv_icon_asc);
        tvIconDesc= (TextView) findViewById(R.id.tv_icon_desc);
        tvHfll= (TextView) findViewById(R.id.tv_llhf);
        tvOther= (TextView) findViewById(R.id.tv_other);
        llMask= (LinearLayout) findViewById(R.id.ll_mask);
        listView= (ListView) findViewById(R.id.list_view);
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
                        ivFl1.setVisibility(VISIBLE);
                        ivFl2.setVisibility(View.GONE);
                        ivPx1.setVisibility(View.GONE);
                        ivPx2.setVisibility(View.VISIBLE);
                        flag=true;
                        llMask.setVisibility(View.VISIBLE);
                        llFlItem.setVisibility(View.VISIBLE);
                    }else{
                        flag=false;
                        ivFl1.setVisibility(View.GONE);
                        ivFl2.setVisibility(View.VISIBLE);
                        ivPx1.setVisibility(View.GONE);
                        ivPx2.setVisibility(View.VISIBLE);
                        llFlItem.setVisibility(View.INVISIBLE);
                        llMask.setVisibility(View.INVISIBLE);
                    }
                    checkBox.setChecked(false);
                    llPxItem.setVisibility(View.INVISIBLE);
                    break;
                case R.id.ll_px:
                    if (!flag){
                        ivFl1.setVisibility(View.GONE);
                        ivFl2.setVisibility(View.VISIBLE);
                        ivPx1.setVisibility(View.VISIBLE);
                        ivPx2.setVisibility(View.GONE);
                        flag=true;
                        llMask.setVisibility(View.VISIBLE);
                        llPxItem.setVisibility(View.VISIBLE);
                    }else{
                        flag=false;
                        ivFl1.setVisibility(View.GONE);
                        ivFl2.setVisibility(View.VISIBLE);
                        ivPx1.setVisibility(View.GONE);
                        ivPx2.setVisibility(View.VISIBLE);
                        llPxItem.setVisibility(View.INVISIBLE);
                        llMask.setVisibility(View.INVISIBLE);
                    }
                    checkBox.setChecked(false);
                    llFlItem.setVisibility(View.INVISIBLE);
                    break;
                case R.id.checkbox:
                    if (checkBox.isChecked()){
                        Toast.makeText(GoldMallActivity.this,"选中",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(GoldMallActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                    ivFl1.setVisibility(View.GONE);
                    ivFl2.setVisibility(VISIBLE);
                    ivPx1.setVisibility(View.GONE);
                    ivPx2.setVisibility(VISIBLE);
                    flag=false;
                    llMask.setVisibility(View.INVISIBLE);
                    break;
                case R.id.ll_topup_30:
                    exchange(1);
                    break;
                case R.id.ll_topup_50:
                    exchange(2);
                    break;
                case R.id.ll_topup_100:
                    exchange(3);
                    break;
                case R.id.ll_topup_200:
                    exchange(4);
                    break;
                case R.id.tv_llhf:

                    break;
                case R.id.tv_other:

                    break;
                case R.id.tv_icon_asc:
                    Toast.makeText(GoldMallActivity.this, "从低到高", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tv_icon_desc:
                    Toast.makeText(GoldMallActivity.this, "从高到低", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
    private class GoldIconHttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "GoldIconHttpResponseHandler: "+s);
            PersonInfo personInfo = JSON.parseObject(s, PersonInfo.class);
            if (personInfo.isSuccess()){
                tvScore.setText(personInfo.getData().getCustomerAccount().getAvailableScore()+"");
            }else if (!personInfo.isSuccess()&&personInfo.getCode()==3){
                tvScore.setText("0");
                Toast.makeText(GoldMallActivity.this, "您还未登录,登录才能查看金币数量!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

    private class GoldIconItemsResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "GoldIconItemsResponseHandler: "+s);
        }
    }

    private class ExchangeResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "ExchangeResponseHandler: "+s);
            ExchangeInfo exchangeInfo = JSON.parseObject(s, ExchangeInfo.class);
            Toast.makeText(GoldMallActivity.this, exchangeInfo.getMessage(), Toast.LENGTH_SHORT).show();
//            if (exchangeInfo.isSuccess()){
//                Toast.makeText(GoldMallActivity.this, exchangeInfo.getMessage(), Toast.LENGTH_SHORT).show();
//            }else {
//                if ("积分不足".equals(exchangeInfo.getMessage())){
//                    Toast.makeText(GoldMallActivity.this, exchangeInfo.getMessage(), Toast.LENGTH_SHORT).show();
//                }else if ("登录超时或者未登录，请登录".equals(exchangeInfo.getMessage())){
//                    AlertDialog.Builder dialog=new AlertDialog.Builder(GoldMallActivity.this);
//                    dialog.setMessage("您还未登录");
//                    dialog.setPositiveButton("去登陆", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Intent login =new Intent(GoldMallActivity.this, LoginActivity.class);
//                            startActivity(login);
//                        }
//                    });
//                    dialog.setNegativeButton("取消",null);
//                    dialog.show();
//                }
//            }
        }
    }
    public void exchange(final int i){
        AlertDialog.Builder dialog=new AlertDialog.Builder(GoldMallActivity.this);
        dialog.setMessage("确定兑换吗?");
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HttpClient.get(GoldMallActivity.this,Urls.getHost()+"/winners/exchange?prizeId="+i,new ExchangeResponseHandler());
            }
        }).show();
    }
    private void requestData(){

    }
}
