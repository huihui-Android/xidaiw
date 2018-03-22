package xidaiw.licai.frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xidaiw.btj.R;

import xidaiw.licai.activity.LoanDetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDescFragment extends Fragment {


    public ProductDescFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_desc, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LoanDetailActivity activity = (LoanDetailActivity) getActivity();
        final String productId = activity.getProductId();
        WebView wv= (WebView) activity.findViewById(R.id.wv_product_desc);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://m.xidaiw.com/wap/product/productDetail?showNav=0&productId="+productId);
    }
}
