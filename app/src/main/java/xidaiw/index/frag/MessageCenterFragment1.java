package xidaiw.index.frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.xidaiw.btj.R;

import java.util.ArrayList;

import xidaiw.index.entity.MessageList1;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageCenterFragment1 extends Fragment {

    private MessageList1 messageList1;
    private PullToRefreshAdapterViewBase listView;
    private static final String TAG = "MessageCenterFragment1";
    private int currenPage=1;
    private boolean isNotPull = true;
    MyAdapter adapter;
    private ArrayList<MessageList1.DataBean.ListBean> list;

    public MessageCenterFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_center_1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = getActivity().findViewById(R.id.list_view);
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
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {

            //手指下滑，加载上一页
            @Override
            public void onPullDownToRefresh(PullToRefreshBase refreshView){
                currenPage = 1;//初始值
                isNotPull =false;
                if(list!=null){
                    list.clear();//清空
                    if(list.size()==0){
                        isNotPull =true;
                    }
                }
                RefreshLoanlist();
            }
            //手指上滑,加载下一页
            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView){
//                isNotPull = false;
                currenPage = currenPage+1;
                RequestParams params = new RequestParams();
                params.put("productChannelId", "2");
                params.put("pageNow", currenPage+"");
                params.put("pageSize", "10");
                HttpClient.post(getActivity(), Urls.getHost()+ "/message/list",params,new MessageCenterFrame1HttpResponseHandler());
            }
        });
    }

    private class MessageCenterFrame1HttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            Log.i(TAG, "onSuccess:"+s);
            messageList1 = JSON.parseObject(s, MessageList1.class);
            if (messageList1.isSuccess()){
                list = (ArrayList<MessageList1.DataBean.ListBean>) messageList1.getData().getList();
                if (list.size()==0){
                    Toast.makeText(getActivity(), "无更多数据！", Toast.LENGTH_LONG).show();
                    listView.onRefreshComplete();
                    return;
                }
                if (adapter==null){
                    adapter =new MyAdapter();
                }
                if(isNotPull){//第二页无需重新绑定
                    listView.setAdapter(adapter);
                }
                adapter.notifyDataSetChanged();
                listView.onRefreshComplete();
            }

        }
    }
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return messageList1.getData().getList().size();
        }

        @Override
        public Object getItem(int position) {
            return messageList1==null?0:list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder hoder=null;
            if (convertView==null){
                hoder=new ViewHolder();
                convertView = View.inflate(getActivity(), R.layout.frag_message_center_1_item, null);
                hoder.tvTitle = convertView.findViewById(R.id.tv_title);
                hoder.tvTime=convertView.findViewById(R.id.tv_time);
                convertView.setTag(hoder);
            }else{
                hoder = (ViewHolder) convertView.getTag();
            }
            hoder.tvTitle.setText(list.get(position).getMessageTitle());
            hoder.tvTime.setText(list.get(position).getCreateTime().substring(0,10));
            return convertView;
        }
    }
    private class ViewHolder {
        public TextView tvTitle;
        public TextView tvTime;
    }
    public  void RefreshLoanlist(){
        RequestParams params = new RequestParams();
        currenPage = 1;
        params.put("productChannelId", "2");
        params.put("pageNow", "1");
        params.put("pageSize", "10");
        HttpClient.post(getActivity(), Urls.getHost()+ "/message/list",params,new MessageCenterFrame1HttpResponseHandler());
    }
}
