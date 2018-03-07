package xidaiw.mine.activity;

import android.os.Bundle;
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
import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

import xidaiw.mine.entity.TransactionDetailInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

public class TransactionDetailActivity extends AppCompatActivity {
    private ImageView ivBack;
    private TextView tvHeader,tvRight,tvAccountMoney;
    private PullToRefreshListView listView;
    private boolean isNotPull=true;
    private int currentPage=1;
    private static final String TAG = "TransactionDetailActivi";
    private List<TransactionDetailInfo.DataBean.ListBean> list;
    private List<TransactionDetailInfo.DataBean.ListBean> recordList;
    private TransactionRecordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail);
        initViews();
        tvHeader.setText("交易明细");
        MyOnclickListener listener=new MyOnclickListener();
        ivBack.setOnClickListener(listener);
        tvRight.setOnClickListener(listener);
        //"/account/customerPointHistory"
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
                currentPage = 1;//初始值
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
                currentPage = currentPage+1;
                HttpClient.get(TransactionDetailActivity.this, Urls.getHost()+"/account/customerPointHistory?productChannelId=2&pageSize=10&pageNow="+currentPage, new TransactionDetailAsyncHttpResponseHandler());
            }
        });
    }

    private void RequestRecordList() {
        HttpClient.get(TransactionDetailActivity.this, Urls.getHost()+"/account/customerPointHistory?productChannelId=2&pageSize=10&pageNow=1", new TransactionDetailAsyncHttpResponseHandler());
    }

    private void initViews() {
        ivBack= (ImageView) findViewById(R.id.iv_back);
        tvHeader= (TextView) findViewById(R.id.tv_header);
        tvRight= (TextView) findViewById(R.id.tv_right);
        tvAccountMoney= (TextView) findViewById(R.id.tv_account_money);
        listView= (PullToRefreshListView) findViewById(R.id.list_view);
    }
    private class MyOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.tv_right:
                    Toast.makeText(TransactionDetailActivity.this, "我是筛选", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
    private class TransactionDetailAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "TransactionDetailAsyncHttpResponseHandler: "+s);
            TransactionDetailInfo transactionDetailInfo = JSON.parseObject(s, TransactionDetailInfo.class);
            if (transactionDetailInfo.isSuccess()){
                String ableWithdrawalAmount = transactionDetailInfo.getData().getAbleWithdrawalAmount();
                tvAccountMoney.setText(ableWithdrawalAmount);
                recordList = transactionDetailInfo.getData().getList();
                if (recordList.size()==0){
                    Toast.makeText(TransactionDetailActivity.this, "无更多数据", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (list ==null){
                    list=new ArrayList<>();
                }
                list.addAll(recordList);
                if (adapter ==null){
                    adapter = new TransactionRecordAdapter();
                }
                if(isNotPull){//第二页无需重新绑定
                    listView.setAdapter(adapter);
                    Log.i(TAG, "TransactionRecordAdapter: 你能看到我吗?");
                }
                adapter.notifyDataSetChanged();
                listView.onRefreshComplete();
            }
        }
    }
    private class TransactionRecordAdapter extends BaseAdapter {
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
        public View getView(int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(TransactionDetailActivity.this,R.layout.recharge_record_item,null);
                holder.tvTime=convertView.findViewById(R.id.tv_time);
                holder.tvAmout=convertView.findViewById(R.id.tv_amount);
                holder.ivStatue=convertView.findViewById(R.id.iv_statue);
                holder.tvDesc=convertView.findViewById(R.id.tv_desc);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvTime.setText(list.get(position).getCreateTime());
            holder.tvAmout.setText(list.get(position).getAmount()+"元");
            if ("提现成功".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("提现金额");
                holder.ivStatue.setVisibility(View.VISIBLE);
                holder.ivStatue.setImageResource(R.mipmap.withdraw_success);
            }else if ("申请提现".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("申请提现");
                holder.ivStatue.setVisibility(View.VISIBLE);
                holder.ivStatue.setImageResource(R.mipmap.withdraw_checking);
            }else if ("充值".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("充值金额");
                holder.ivStatue.setVisibility(View.VISIBLE);
                holder.ivStatue.setImageResource(R.mipmap.recharge_success);
            }else if ("提现失败".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("提现失败");
                holder.ivStatue.setVisibility(View.VISIBLE);
                holder.ivStatue.setImageResource(R.mipmap.withdraw_fail);
            }else if ("还款本金".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("还款本金");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("还款利息".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("还款利息");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("提现手续费冻结".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("提现手续费冻结");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("提现手续费".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("提现手续费");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("提现失败，解冻提现手续费".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("提现失败，解冻提现手续费");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("提现撤销".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("提现撤销");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("提现撤销,解冻提现手续费".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("提现撤销,解冻提现手续费");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("系统转账".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("系统转账");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("系统收款".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("系统收款");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("现金奖励".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("现金奖励");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("代金券使用投标冻结".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("代金券使用投标冻结");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("代金券使用放款解冻".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("代金券使用放款解冻");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("现金红包兑换".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("现金红包兑换");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }else if ("利息管理费".equals(list.get(position).getCustomerPointTypeName())){
                holder.tvDesc.setText("利息管理费");
                holder.ivStatue.setVisibility(View.INVISIBLE);
            }
            return convertView;
        }
    }
    private static class ViewHolder{
        public TextView tvTime;
        public TextView tvAmout;
        public ImageView ivStatue;
        public TextView tvDesc;
    }
}
