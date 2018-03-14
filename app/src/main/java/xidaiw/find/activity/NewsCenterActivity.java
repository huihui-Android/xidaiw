package xidaiw.find.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import java.util.List;

import xidaiw.find.entity.NewsListInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;
import xidaiw.widget.MyImageView;

public class NewsCenterActivity extends AppCompatActivity {
    private PullToRefreshListView listView;
    private ImageView ivBack;
    private TextView tvHeader;
    private static final String TAG = "NewsCenterActivity";
    private List<NewsListInfo.DataBean.ListBean> list;
    private List<NewsListInfo.DataBean.ListBean> containerList;
    private int currenPage=1;
    private boolean isNotPull=true;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_center);
        listView= (PullToRefreshListView) findViewById(R.id.list_view);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvHeader = (TextView) findViewById(R.id.tv_header);
        tvHeader.setText("新闻资讯");
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
                HttpClient.get(NewsCenterActivity.this, Urls.getHost()+"/message/newsList?productChannelId=2&pageSize=5&pageNow=2",new NewsListResponseHandler());
            }
        });

    }
    private void RefreshLoanlist() {
        HttpClient.get(this, Urls.getHost()+"/message/newsList?productChannelId=2&pageSize=5&pageNow=1",new NewsListResponseHandler());
    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list==null?0:list.size();
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
                convertView = View.inflate(NewsCenterActivity.this, R.layout.news_center_item, null);
                holder.tvPublishTime=convertView.findViewById(R.id.tv_create_time);
                holder.tvNewsTitle=convertView.findViewById(R.id.tv_news_title);
                holder.imageView=convertView.findViewById(R.id.iv_image);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }
            String content = list.get(position).getContent();
            int start = content.indexOf("http://101.37.174.8/ftp_user/");
            int end = content.indexOf(".jpg");
            if(end==-1){
                end=content.indexOf(".png");
            }else if(end-start>50){
                end=content.indexOf(".png");
            }
            String url=content.substring(start,end+4);
            holder.tvPublishTime.setText(list.get(position).getCreateTime().substring(0,10).replace("-","."));
            holder.tvNewsTitle.setText(list.get(position).getName());
            holder.imageView.setImageURL(url);
            return convertView;
        }
    }

    private class NewsListResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "onSuccess: "+s);
            NewsListInfo newsListInfo = JSON.parseObject(s, NewsListInfo.class);
            if (newsListInfo.isSuccess()){
                NewsListInfo.DataBean data = newsListInfo.getData();
                list = data.getList();
                if (list.size()==0){
                    Toast.makeText(NewsCenterActivity.this, "无更多数据！", Toast.LENGTH_LONG).show();
                    listView.onRefreshComplete();
                    return;
                }
                if (adapter ==null){
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
    private class ViewHolder{
        TextView tvPublishTime;
        TextView tvNewsTitle;
        MyImageView imageView;
        int id;
    }
}
