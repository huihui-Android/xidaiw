package xidaiw.mine.frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;
import java.util.List;
import xidaiw.mine.entity.InvestRecordGoingInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

/**
 * A simple {@link Fragment} subclass.
 */
public class InvestRecordGoingFragment extends Fragment {
    private ListView listView;
    private List<InvestRecordGoingInfo.DataBean.ProductAccountListBean> productAccountList;
    private static final String TAG = "InvestRecordGoingFragme";
    public InvestRecordGoingFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invest_record_going, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        listView=activity.findViewById(R.id.list_view);
        HttpClient.get(getActivity(), Urls.getHost()+"/mycurrPlan1?showNav=0",new InvestRecordGoingResponseHandler());

    }
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return productAccountList.size();
        }

        @Override
        public Object getItem(int position) {
            return productAccountList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView==null){
                convertView=View.inflate(getActivity(),R.layout.invest_record_going_item,null);
                holder=new ViewHolder();
                holder.tvTitle=convertView.findViewById(R.id.tv_title);
                holder.tvAmount=convertView.findViewById(R.id.tv_amount);
                holder.tvInterest=convertView.findViewById(R.id.tv_interest);
                holder.tvCreateTime=convertView.findViewById(R.id.tv_create_time);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tvTitle.setText(productAccountList.get(position).getProductName());
            holder.tvAmount.setText(productAccountList.get(position).getTotalBuyAmount());
            holder.tvCreateTime.setText(productAccountList.get(position).getBuyTime());
            return convertView;
        }
    }

    private class InvestRecordGoingResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "InvestRecordGoingResponseHandler: "+s);
            InvestRecordGoingInfo investRecordGoingInfo = JSON.parseObject(s, InvestRecordGoingInfo.class);
            if (investRecordGoingInfo.isSuccess()){
                productAccountList = investRecordGoingInfo.getData().getProductAccountList();
                if (productAccountList==null){
                    Toast.makeText(getActivity(), "暂无投资记录", Toast.LENGTH_SHORT).show();
                }else{
                    listView.setAdapter(new MyAdapter());
                }
            }
        }
    }
    private class ViewHolder{
        public TextView tvTitle;
        public TextView tvAmount;
        public TextView tvInterest;
        public TextView tvCreateTime;
    }
}
