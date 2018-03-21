package xidaiw.licai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import xidaiw.licai.entity.ProductInfo;
import xidaiw.util.GlobalUtils;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

public class LoanDetailActivity extends AppCompatActivity {
    private static final String TAG = "LoanDetailActivity";
    private ImageView ivBack;
    private TextView tvHeader;
    private TextView tvProductName,tvInterestNormal,tvInterestAward,tvProductAmount,tvProductDuration,tvProductSales,tvProductRemain;
    private TextView tvPaybackPer,tvBidDuration;
    private TextView tvJiahao,tvBaifenhao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_detail);
        Intent intent = getIntent();
        String productId = intent.getStringExtra("productId");
        Log.d(TAG, "onCreate: "+productId);
        initView();
        bindEvents();
        tvHeader.setText("项目详情");
        HttpClient.get(this, Urls.getHost()+"/product/productInfo?productId="+productId,new ProductInfoResponseHandler());
    }

    private void bindEvents() {
        MyOnclickListener listener=new MyOnclickListener();
        ivBack.setOnClickListener(listener);
    }

    private void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvHeader = (TextView) findViewById(R.id.tv_header);
        tvProductName= (TextView) findViewById(R.id.tv_productName);
        tvInterestNormal= (TextView) findViewById(R.id.tv_interest_normal);
        tvInterestAward= (TextView) findViewById(R.id.tv_interest_award);
        tvProductAmount= (TextView) findViewById(R.id.tv_productAmount);
        tvProductDuration= (TextView) findViewById(R.id.tv_productDuration);
        tvProductSales= (TextView) findViewById(R.id.tv_productSales);
        tvProductRemain= (TextView) findViewById(R.id.tv_productRemain);
        tvPaybackPer= (TextView) findViewById(R.id.tv_payback_per);
        tvBidDuration= (TextView) findViewById(R.id.tv_bid_duration);
        tvJiahao= (TextView) findViewById(R.id.tv_jiahao);
        tvBaifenhao= (TextView) findViewById(R.id.tv_baifenhao);

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

    private class ProductInfoResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.d(TAG, "onSuccess: "+s);
            ProductInfo productInfo = JSON.parseObject(s, ProductInfo.class);
            if (productInfo.isSuccess()){
                ProductInfo.DataBean.ProductBean product = productInfo.getData().getProduct();
                tvProductName.setText(product.getProductName());
                tvInterestNormal.setText(GlobalUtils.NumberFormatTranferTwo(product.getNormalInterest() + ""));
                if (product.getProductTypeName().equals("短期体验产品")){
                    tvInterestAward.setVisibility(View.GONE);
                    tvJiahao.setVisibility(View.GONE);
                    tvBaifenhao.setVisibility(View.GONE);
                }else{
                    tvInterestAward.setVisibility(View.VISIBLE);
                    tvInterestAward.setText(product.getAwardInterest()+"");
                    tvJiahao.setVisibility(View.VISIBLE);
                    tvBaifenhao.setVisibility(View.VISIBLE);
                }
                tvProductAmount.setText(product.getTotalAmount()+"");
                tvProductDuration.setText(product.getMaturityDuration());
                tvProductSales.setText("已投"+product.getSaleAmount()+"份");
                tvProductRemain.setText("剩余"+product.getRemainingAmount()+"份");

            }
        }
    }
}
