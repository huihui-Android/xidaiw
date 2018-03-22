package xidaiw.licai.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

import xidaiw.licai.entity.ProductInfo;
import xidaiw.licai.frag.CommonProblemsFragment;
import xidaiw.licai.frag.ContractFragment;
import xidaiw.licai.frag.ProductDescFragment;
import xidaiw.util.GlobalUtils;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

public class LoanDetailActivity extends AppCompatActivity{
    private static final String TAG = "LoanDetailActivity";
    private ImageView ivBack;
    private TextView tvHeader;
    private TextView tvProductName,tvInterestNormal,tvInterestAward,tvProductAmount,tvProductDuration,tvProductSales,tvProductRemain;
    private TextView tvPaybackPer,tvBidDuration;//每万元收益,募集期限
    private TextView tvJiahao,tvBaifenhao;

    private LinearLayout llProductDesc,llContract,llCommonProblems;
    private TextView tvProductDesc,tvContract,tvCommonProblems;
    private ImageView ivProductDesc,ivContract,ivCommonProblems;
    private ViewPager vp;
    private List<Fragment> frameList;
    public String productId;
    private TextView tvBuyNow;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_detail);
        Intent intent = getIntent();
        productId = intent.getStringExtra("productId");
        Log.d(TAG, "onCreate: "+ productId);
        initView();
        bindEvents();
        frameList=new ArrayList<>(3);
        ProductDescFragment productDescFragment = new ProductDescFragment();
        ContractFragment contractFragment = new ContractFragment();
        CommonProblemsFragment commonProblemsFragment = new CommonProblemsFragment();
        frameList.add(productDescFragment);
        frameList.add(contractFragment);
        frameList.add(commonProblemsFragment);
        tvHeader.setText("项目详情");

        //vp.setOffscreenPageLimit(3);//缓存两个页面
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        vp.setCurrentItem(0);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    tvProductDesc.setTextColor(Color.parseColor("#eb5c62") );
                    ivProductDesc.setVisibility(View.VISIBLE);
                    tvContract.setTextColor(Color.parseColor("#898989"));
                    ivContract.setVisibility(View.INVISIBLE);
                    tvCommonProblems.setTextColor(Color.parseColor("#898989"));
                    ivCommonProblems.setVisibility(View.INVISIBLE);
                }else if (position==1){
                    tvProductDesc.setTextColor(Color.parseColor("#898989") );
                    ivProductDesc.setVisibility(View.INVISIBLE);
                    tvContract.setTextColor(Color.parseColor("#eb5c62"));
                    ivContract.setVisibility(View.VISIBLE);
                    tvCommonProblems.setTextColor(Color.parseColor("#898989"));
                    ivCommonProblems.setVisibility(View.INVISIBLE);
                }else if (position==2){
                    tvProductDesc.setTextColor(Color.parseColor("#898989") );
                    ivProductDesc.setVisibility(View.INVISIBLE);
                    tvContract.setTextColor(Color.parseColor("#898989"));
                    ivContract.setVisibility(View.INVISIBLE);
                    tvCommonProblems.setTextColor(Color.parseColor("#eb5c62"));
                    ivCommonProblems.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        HttpClient.get(this, Urls.getHost()+"/product/productInfo?productId="+ productId,new ProductInfoResponseHandler());
    }
    private void bindEvents() {
        MyOnclickListener listener=new MyOnclickListener();
        ivBack.setOnClickListener(listener);
        llProductDesc.setOnClickListener(listener);
        llContract.setOnClickListener(listener);
        llCommonProblems.setOnClickListener(listener);
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

        llProductDesc= (LinearLayout) findViewById(R.id.ll_product_desc);
        llContract= (LinearLayout) findViewById(R.id.ll_contract);
        llCommonProblems= (LinearLayout) findViewById(R.id.ll_common_problems);
        tvProductDesc= (TextView) findViewById(R.id.tv_product_desc);
        tvContract= (TextView) findViewById(R.id.tv_contract);
        tvCommonProblems= (TextView) findViewById(R.id.tv_common_problems);
        ivProductDesc= (ImageView) findViewById(R.id.iv_product_desc);
        ivContract= (ImageView) findViewById(R.id.iv_contract);
        ivCommonProblems= (ImageView) findViewById(R.id.iv_common_problems);
        vp= (ViewPager) findViewById(R.id.vp);
        tvBuyNow= (TextView) findViewById(R.id.tv_buy_now);
    }
    private class MyOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.ll_product_desc:
                    tvProductDesc.setTextColor(Color.parseColor("#eb5c62") );
                    ivProductDesc.setVisibility(View.VISIBLE);
                    tvContract.setTextColor(Color.parseColor("#898989"));
                    ivContract.setVisibility(View.INVISIBLE);
                    tvCommonProblems.setTextColor(Color.parseColor("#898989"));
                    ivCommonProblems.setVisibility(View.INVISIBLE);
                    vp.setCurrentItem(0);
                    break;
                case R.id.ll_contract:
                    tvProductDesc.setTextColor(Color.parseColor("#898989") );
                    ivProductDesc.setVisibility(View.INVISIBLE);
                    tvContract.setTextColor(Color.parseColor("#eb5c62"));
                    ivContract.setVisibility(View.VISIBLE);
                    tvCommonProblems.setTextColor(Color.parseColor("#898989"));
                    ivCommonProblems.setVisibility(View.INVISIBLE);
                    vp.setCurrentItem(1);
                    break;
                case R.id.ll_common_problems:
                    tvProductDesc.setTextColor(Color.parseColor("#898989") );
                    ivProductDesc.setVisibility(View.INVISIBLE);
                    tvContract.setTextColor(Color.parseColor("#898989"));
                    ivContract.setVisibility(View.INVISIBLE);
                    tvCommonProblems.setTextColor(Color.parseColor("#eb5c62"));
                    ivCommonProblems.setVisibility(View.VISIBLE);
                    vp.setCurrentItem(2);
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
                if (product.getProductStatus().equals("SALES")){
                    tvBuyNow.setText("立即抢购");
                    tvBuyNow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(LoanDetailActivity.this,BuyNowActivity.class);
                            intent.putExtra("productId",productId);
                            startActivity(intent);
                        }
                    });
                }else{
                    tvBuyNow.setClickable(false);
                    tvBuyNow.setText("已售罄");
                    tvBuyNow.setBackgroundColor(Color.parseColor("#898989"));
                }
            }
        }
    }
    private class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return frameList.get(position);
        }

        @Override
        public int getCount() {
            return frameList.size();
        }
        public Fragment currentFragment;

        @Override

        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
            currentFragment = (Fragment) object;
        }
    }
}
