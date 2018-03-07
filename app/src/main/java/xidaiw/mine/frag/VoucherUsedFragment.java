package xidaiw.mine.frag;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import java.util.List;

import xidaiw.mine.entity.VoucherInfo;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

/**
 * A simple {@link Fragment} subclass.
 */
public class VoucherUsedFragment extends Fragment {
    private ImageView ivGetTime1,ivGetTime2,ivOverTime1,ivOverTime2;
    private RelativeLayout rlGetTime,rlOverTime;
    private ListView lv;
    private TextView tvGetTime,tvOverTime;
    private boolean getTimeFlag=true,overTimeFlag=true;
    private List<VoucherInfo.DataBean.ListBean> list;
    private static final String TAG = "VoucherUsedFragment";

    public VoucherUsedFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_voucher_used, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        tvGetTime=activity.findViewById(R.id.tv_getTime);
        tvOverTime=activity.findViewById(R.id.tv_overTime);
        rlGetTime = activity.findViewById(R.id.rl_getTime);
        rlOverTime=activity.findViewById(R.id.rl_overTime);
        ivGetTime1=activity.findViewById(R.id.iv_getTime_1);
        ivGetTime2=activity.findViewById(R.id.iv_getTime_2);
        ivOverTime1=activity.findViewById(R.id.iv_overTime_1);
        ivOverTime2=activity.findViewById(R.id.iv_overTime_2);
        lv=activity.findViewById(R.id.list_view);
        MyOnclickListener listener = new MyOnclickListener();
        rlGetTime.setOnClickListener(listener);
        rlOverTime.setOnClickListener(listener);
        HttpClient.get(activity, Urls.getHost()+"/ticket/listAllGuoqiDJQ",new VoucherUsedAsyncHttpResponseHandler());

    }
    private class MyOnclickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.rl_getTime:
                    if (!getTimeFlag){
                        getTimeFlag=true;
                        ivGetTime1.setImageResource(R.mipmap.sjs);
                        ivGetTime2.setImageResource(R.mipmap.sjx2);
                    }else{
                        getTimeFlag=false;
                        ivGetTime1.setImageResource(R.mipmap.sjs2);
                        ivGetTime2.setImageResource(R.mipmap.sjx);
                    }
                    tvGetTime.setTextColor(Color.parseColor("#eb5c62") );
                    tvOverTime.setTextColor(Color.parseColor("#707070"));
                    ivOverTime1.setImageResource(R.mipmap.sjs);
                    ivOverTime2.setImageResource(R.mipmap.sjx);
                    break;
                case R.id.rl_overTime:
                    if (!overTimeFlag){
                        overTimeFlag=true;
                        ivOverTime1.setImageResource(R.mipmap.sjs);
                        ivOverTime2.setImageResource(R.mipmap.sjx2);
                    }else{
                        overTimeFlag=false;
                        ivOverTime1.setImageResource(R.mipmap.sjs2);
                        ivOverTime2.setImageResource(R.mipmap.sjx);
                    }
                    tvOverTime.setTextColor(Color.parseColor("#eb5c62") );
                    tvGetTime.setTextColor(Color.parseColor("#707070"));
                    ivGetTime1.setImageResource(R.mipmap.sjs);
                    ivGetTime2.setImageResource(R.mipmap.sjx);
                    break;
            }
        }
    }
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list ==null?0: list.size();
        }

        @Override
        public Object getItem(int position) {
            return list ==null?0:list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(getActivity(),R.layout.voucher_used_item,null);
                holder.tvTitle=convertView.findViewById(R.id.tv_title);
                holder.tvValue=convertView.findViewById(R.id.tv_value);
                holder.tvDuration=convertView.findViewById(R.id.tv_duration);
                holder.btnUse=convertView.findViewById(R.id.btn_use);
                holder.tvVoucherDesc=convertView.findViewById(R.id.tv_voucher_desc);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            if (list !=null){
                if ("已使用".equals(list.get(position).getTicketUseStatus())){
                    holder.tvTitle.setText(list.get(position).getTicketName());
                    holder.tvValue.setText(list.get(position).getValue()+"");
                    holder.tvDuration.setText(list.get(position).getStartDate().replace("-", ".")+"-"+ list.get(position).getEndDate().replace("-", "."));
                    holder.tvVoucherDesc.setText("满"+list.get(position).getUseLimit()+"元可用... >");
                    return convertView;
                }
                return null;
            }
            return null;
        }
    }

    private class VoucherUsedAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "VoucherAsyncHttpResponseHandler: "+s);
            VoucherInfo voucherInfo = JSON.parseObject(s, VoucherInfo.class);
            if (voucherInfo.isSuccess()){
                list = voucherInfo.getData().getList();
                Log.i(TAG, "VoucherAsyncHttpResponseHandler: "+ list.size());
                lv.setAdapter(new MyAdapter());
            }else {
                Toast.makeText(getActivity(), voucherInfo.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    private class ViewHolder{
        public TextView tvTitle;
        public TextView tvDuration;
        public TextView tvValue;
        public Button btnUse;
        public TextView tvVoucherDesc;
    }

    private class OpenRedPacketResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            super.onSuccess(i, s);
            Log.i(TAG, "OpenRedPacketResponseHandler: "+s);
            AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
            dialog.setMessage("打开红包成功!");
            dialog.show();
        }
    }
}
