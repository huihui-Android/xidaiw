package xidaiw.mine.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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

import xidaiw.mine.entity.WithdrawRecordInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

/**
 * Created by admin on 2018/3/5.
 */

public class WithdrawRecordActivity extends AppCompatActivity{
    private static final String TAG = "WithdrawRecordActivity";
    private ImageView ivBack;
    private TextView tvHeader;
    private PullToRefreshListView listView;
    private int currenPage=1;
    private boolean isNotPull=true;
    private List<WithdrawRecordInfo.DataBean.ListBean> recordList;
    private WithdrawRecordAdapter adapter;
    private List<WithdrawRecordInfo.DataBean.ListBean> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_record);
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        listView= (PullToRefreshListView) findViewById(R.id.list_view);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvHeader.setText("提现记录");
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
        RequestRecordList();
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                isNotPull =false;
                currenPage = 1;//初始值
                if(list!=null){
                    list.clear();//清空
                    if(list.size()==0){
                        isNotPull =true;
                    }
                }
                RequestRecordList();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                isNotPull = false;
                currenPage = currenPage+1;
                RequestParams params = new RequestParams();
                params.put("productChannelId", "2");
                params.put("pageNow", currenPage+"");
                params.put("pageSize", "10");
                HttpClient.get(WithdrawRecordActivity.this,Urls.getHost()+"/account/listWithdrawalRecord?productChannelId=2&pageSize=10&pageNow="+currenPage, new WithdrawRecordAsyncHttpResponseHandler());
            }
        });
    }

    private void RequestRecordList() {
        RequestParams params = new RequestParams();
        currenPage = 1;
        params.put("productChannelId", "2");
        params.put("pageNow", "1");
        params.put("pageSize", "10");
        HttpClient.get(WithdrawRecordActivity.this, Urls.getHost()+"/account/listWithdrawalRecord?productChannelId=2&pageSize=10&pageNow=1", new WithdrawRecordAsyncHttpResponseHandler());
    }

    private class WithdrawRecordAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "WithdrawRecordAsyncHttpResponseHandler: "+s);
            WithdrawRecordInfo withdrawRecordInfo = JSON.parseObject(s, WithdrawRecordInfo.class);
            if (withdrawRecordInfo.isSuccess()){
                WithdrawRecordInfo.DataBean data = withdrawRecordInfo.getData();
                recordList = data.getList();
                if (recordList.size()==0){
                    Toast.makeText(WithdrawRecordActivity.this, "无更多数据", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (list==null){
                    list = new ArrayList<WithdrawRecordInfo.DataBean.ListBean>();
                }
                list.addAll(recordList);
                if (adapter==null){
                    adapter = new WithdrawRecordAdapter();
                }
                if(isNotPull){//第二页无需重新绑定
                    listView.setAdapter(adapter);
                    Log.i(TAG, "WithdrawRecordAdapter: 你能看到我吗?");
                }
                adapter.notifyDataSetChanged();
                listView.onRefreshComplete();
            }
        }
    }
    private class WithdrawRecordAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(WithdrawRecordActivity.this,R.layout.recharge_record_item,null);
                holder.tvTime=convertView.findViewById(R.id.tv_time);
                holder.tvAmout=convertView.findViewById(R.id.tv_amount);
                holder.ivStatue=convertView.findViewById(R.id.iv_statue);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvTime.setText(list.get(position).getApplyTime());
            holder.tvAmout.setText(list.get(position).getAmount()+"元");
            if ( "WITHDRAWAL_SUCCESS".equals(list.get(position).getStatus())){
                holder.ivStatue.setImageResource(R.mipmap.withdraw_success);
            }else if ("WITHDRAWAL_FAILED".equals(list.get(position).getStatus())){
                holder.ivStatue.setImageResource(R.mipmap.withdraw_fail);
            }else if ("AUDITED_FAILED".equals(list.get(position).getStatus())){
                holder.ivStatue.setImageResource(R.mipmap.withdraw_fail);
            }else if ("AUDITED".equals(list.get(position).getStatus())){
                holder.ivStatue.setImageResource(R.mipmap.withdraw_checking);
            }
            return convertView;
        }
    }
    private static class ViewHolder{
        public TextView tvTime;
        public TextView tvAmout;
        public ImageView ivStatue;
    }
}
