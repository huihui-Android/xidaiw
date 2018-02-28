package xidaiw.index.frag;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xidaiw.btj.R;

import java.util.ArrayList;

import xidaiw.index.entity.MessageList2;
import xidaiw.mine.activity.LoginActivity;
import xidaiw.mine.activity.RegistActivity;
import xidaiw.util.HttpClient;
import xidaiw.util.Urls;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageCenterFragment2 extends Fragment {


    private PullToRefreshAdapterViewBase listView;
    private static final String TAG = "MessageCenterFragment2";
    private ArrayList<MessageList2.DataBean.ListBean> list;
    private MyAdapter adapter;
    private LinearLayout llNoLogin;
    private RelativeLayout rl_no_message;
    private Button btnLogin;
    private Button btnRegister;

    public MessageCenterFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_center_2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = getActivity().findViewById(R.id.list_view2);
        rl_no_message = getActivity().findViewById(R.id.rl_no_message);
        llNoLogin = getActivity().findViewById(R.id.ll_no_login);
        btnLogin = getActivity().findViewById(R.id.btn_login);
        btnRegister = getActivity().findViewById(R.id.btn_register);
        HttpClient.get(getActivity(), Urls.getHost()+"/message/awardList",new MessageCenterFrame2HttpResponseHandler());
    }

    private class MessageCenterFrame2HttpResponseHandler extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int i, String s) {
            Log.i(TAG, "onSuccess:"+s);
            MessageList2 messageList2 = JSON.parseObject(s, MessageList2.class);
            if (messageList2.isSuccess()){
                list = (ArrayList<MessageList2.DataBean.ListBean>) messageList2.getData().getList();
                if (list==null){
                    rl_no_message.setVisibility(View.VISIBLE);
                    llNoLogin.setVisibility(View.INVISIBLE);
                }
                adapter = new MyAdapter();
                listView.setAdapter(adapter);
            }else{
                listView.setVisibility(View.INVISIBLE);
                rl_no_message.setVisibility(View.VISIBLE);
                llNoLogin.setVisibility(View.VISIBLE);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                    }
                });
                btnRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getActivity(), RegistActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list==null?0:list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHoder hoder=null;
            if (convertView==null){
                convertView= android.view.View.inflate(getActivity(),R.layout.frag_message_center_2_item,null);
                hoder=new ViewHoder();
                hoder.tvTitle=convertView.findViewById(R.id.tv_title);
                hoder.tvTime=convertView.findViewById(R.id.tv_time);
                hoder.ivIsRead=convertView.findViewById(R.id.iv_isRead);
                convertView.setTag(hoder);
            }else{
                hoder = (ViewHoder) convertView.getTag();
            }
            if (list.get(position).getIsRead()==0){
                hoder.ivIsRead.setVisibility(View.VISIBLE);
            }else{
                hoder.ivIsRead.setVisibility(View.INVISIBLE);
            }
            hoder.tvTitle.setText(list.get(position).getTitle());
            hoder.tvTime.setText(list.get(position).getCreateTime().substring(0,10));
            return convertView;
        }
    }
    private class ViewHoder{
        public TextView tvTitle;
        public TextView tvTime;
        public ImageView ivIsRead;
    }
}
