package xidaiw.licai.frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.xidaiw.btj.R;

import xidaiw.index.entity.ProductAgreementInfo;
import xidaiw.licai.activity.LoanDetailActivity;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContractFragment extends Fragment {

    private static final String TAG = "ContractFragment";
    private WebView wv;
    public ContractFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contract, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LoanDetailActivity activity = (LoanDetailActivity) getActivity();
        final String productId = activity.getProductId();
        wv = (WebView) activity.findViewById(R.id.wv_contract);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        RequestParams params=new RequestParams();
        params.put("productId",productId);
        HttpClient.post(activity,Urls.getHost()+"/product/productAgreementTemplate",params,new ProductAgreementResponseHandler());
    }

    private class ProductAgreementResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "onSuccess: "+s);
            ProductAgreementInfo productAgreementInfo = JSON.parseObject(s, ProductAgreementInfo.class);
            if (productAgreementInfo.isSuccess()){
                String agreementContent = productAgreementInfo.getData().getAgreementTemplate().getAgreementContent();
                wv.loadData(agreementContent, "text/html; charset=UTF-8", null);
            }
        }
    }
}
