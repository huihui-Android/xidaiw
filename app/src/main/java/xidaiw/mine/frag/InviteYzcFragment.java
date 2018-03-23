package xidaiw.mine.frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import java.util.List;

import xidaiw.mine.entity.MyInviteInfo;
import xidaiw.util.GlobalUtils;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

/**
 * A simple {@link Fragment} subclass.
 */
public class InviteYzcFragment extends Fragment {
    private RecyclerView recyclerView;
    private static final String TAG = "InviteYzcFragment";
    private List<MyInviteInfo.DataBean.TotalBean> list;

    public InviteYzcFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invite_yzc, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        recyclerView=activity.findViewById(R.id.rv_recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        HttpClient.get(getActivity(), Urls.getHost()+"/myinvite",new InviteYzcResponseHandler());
    }
    public class YzcRecyclerAdapter extends RecyclerView.Adapter<YzcRecyclerAdapter.ViewHolder>{
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView tvMobile,tvTime,tvLevel,tvAwardMoney;
            public ViewHolder(View itemView) {
                super(itemView);
                tvMobile=itemView.findViewById(R.id.tv_mobile);
                tvTime=itemView.findViewById(R.id.tv_time);
                tvLevel=itemView.findViewById(R.id.tv_level);
                tvAwardMoney=itemView.findViewById(R.id.tv_award_money);
            }
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(getActivity(), R.layout.invitefriend_item, null);
            ViewHolder holder=new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            MyInviteInfo.DataBean.TotalBean items = list.get(position);
            holder.tvMobile.setText(items.getMobile());
            holder.tvTime.setText(items.getAwardTime().substring(0,10));
            holder.tvLevel.setText(items.getLevel()+"");
            holder.tvAwardMoney.setText(GlobalUtils.NumberFormatTranferTwo(items.getAwardMoney()+"")+"元");
        }

        @Override
        public int getItemCount() {
            return list==null?0:list.size();
        }
    }

    private class InviteYzcResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "onSuccess: "+s);
            MyInviteInfo myInviteInfo = JSON.parseObject(s, MyInviteInfo.class);
            if (myInviteInfo.isSuccess()){
                MyInviteInfo.DataBean data = myInviteInfo.getData();
                list = data.getTotal();
                recyclerView.setAdapter(new YzcRecyclerAdapter());
            }
        }
    }
}
