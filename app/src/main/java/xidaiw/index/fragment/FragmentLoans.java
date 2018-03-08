package xidaiw.index.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

import xidaiw.licai.adapter.LoansAdapter11;
import xidaiw.licai.bean.LoanPageAdapter;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;
import xidaiw.widget.RoundProgressBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLoans extends Fragment {
    private PullToRefreshListView listView;
    //当前页
    private int currenPage=1;
    private boolean isNotPull = true;
    private List<LoanPageAdapter.DataBean.ListBean> loanList;
    private int pageSize=10;
    private RoundProgressBar roundProgressBar,roundProgressBar2;
    LoansAdapter11 adapter;

    public FragmentLoans() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loans, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        listView = (PullToRefreshListView) activity.findViewById(R.id.list_view);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        //设置上下拉刷新属性
        ILoadingLayout startLabels = listView.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");
        startLabels.setRefreshingLabel("正在刷新...");
        startLabels.setReleaseLabel("释放立即刷新");
        ILoadingLayout endLabels = listView.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉加载更多");
        endLabels.setRefreshingLabel("正在加载...");
        endLabels.setReleaseLabel("释放立即刷新");
        RefreshLoanlist();
        //设置上下拉刷新事件
        listView.setOnRefreshListener(new LoanListOnRefreshListener2());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
//                Intent intent = new Intent(getActivity(),LoanDetailActivity.class);
//                intent.putExtra("loanId", loanList.get(position-1).getId());
//                getActivity().startActivity(intent);
            }
        });
    }

    public  void RefreshLoanlist(){
        RequestParams params = new RequestParams();
        currenPage = 1;
        params.put("productChannelId", 2+"");
        params.put("pageNow", "1");
        params.put("pageSize", "10");
        HttpClient.post(getActivity(), Urls.getHost()+"/product/list", params, new LoansAsyncResponseHandler());
    }
    class LoanListOnRefreshListener2<ListView> implements PullToRefreshBase.OnRefreshListener2 {

        //手指下滑，加载上一页
        @Override
        public void onPullDownToRefresh(PullToRefreshBase refreshView){
            isNotPull =false;
            currenPage = 1;//初始值
            if(loanList!=null){
                loanList.clear();//清空
                if(loanList.size()==0){
                    isNotPull =true;
                }
            }
            RefreshLoanlist();

        }
        //手指上滑,加载下一页
        @Override
        public void onPullUpToRefresh(PullToRefreshBase refreshView){
            isNotPull = false;
            currenPage = currenPage+1;
//            if (currenPage>=2){currenPage=2;}
            RequestParams params = new RequestParams();
            params.put("productChannelId", 2+"");
            params.put("pageNow", currenPage+"");
            params.put("pageSize", pageSize+"");
            HttpClient.post(getActivity(),Urls.getHost()+"/product/list", params, new LoansAsyncResponseHandler());
        }
    }
//    private View newHand = null;
    public class LoansAsyncResponseHandler extends AsyncHttpResponseHandler {
        public void onStart() {
            super.onStart();
        }
        public void onSuccess(int arg0, String json) {
            super.onSuccess(arg0, json);
            LoanPageAdapter loanPageAdapter = JSON.parseObject(json,LoanPageAdapter.class);
            LoanPageAdapter.DataBean data = loanPageAdapter.getData();
            ArrayList<LoanPageAdapter.DataBean.ListBean> list = data.getList();
            if(list.size()==0){
                Toast.makeText(getActivity(), "无更多数据！", Toast.LENGTH_LONG).show();
                return;
            }
            if(loanList==null){
                loanList = new ArrayList<LoanPageAdapter.DataBean.ListBean>();
                Log.i("FragmentLoans",loanList.toString());
            }
            loanList.addAll(list);
            if(adapter==null){
                adapter = new LoansAdapter11(getActivity(),loanList);
            }
            if(isNotPull){//第二页无需重新绑定
//                newHand = LayoutInflater.from(getActivity()).inflate(R.layout.productlist_item_newhand, null);
//                listView.getRefreshableView().addHeaderView(newHand);
                listView.setAdapter(adapter);
            }
            adapter.notifyDataSetChanged();
            listView.onRefreshComplete();
        }
    }
}
