package xidaiw.index.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xidaiw.btj.R;

import xidaiw.mine.activity.SafeCenterActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMine extends Fragment implements View.OnClickListener{
    //账户页面的控件
    private ImageView ivHelp;
    private ImageView ivAvanta;
    private TextView tvYesterdEarn1;
    private TextView tvYesterdayEarn2;
    private TextView tvAvailablBalance;
    private TextView tvTotalBalance;
    private TextView tvDetail;
    private TextView tvPhone;
    private Button btnWithDraw;
    private Button btnRecharge;
    private LinearLayout llMyjl;
    private LinearLayout llAutoBid;
    private LinearLayout llMysafety;
    private LinearLayout llMyInvite;



    public FragmentMine() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = this.getActivity();
        initViews();
        //content里面的点击事件
        ivAvanta.setOnClickListener(this);
        ivHelp.setOnClickListener(this);
        tvDetail.setOnClickListener(this);
        btnRecharge.setOnClickListener(this);
        btnWithDraw.setOnClickListener(this);
        llMyjl.setOnClickListener(this);
        llAutoBid.setOnClickListener(this);
        llMysafety.setOnClickListener(this);
        llMyInvite.setOnClickListener(this);


    }

    private void initViews() {
        //content里面的viewgroup
        ivAvanta=getActivity().findViewById(R.id.iv_avanty);
        ivHelp=getActivity().findViewById(R.id.iv_help);
        tvPhone=getActivity().findViewById(R.id.tv_phone);
        tvYesterdEarn1=getActivity().findViewById(R.id.tv_yesterdayEarn1);
        tvYesterdayEarn2=getActivity().findViewById(R.id.tv_yesterdayEarn2);
        tvAvailablBalance=getActivity().findViewById(R.id.tv_availableBalance);
        tvTotalBalance=getActivity().findViewById(R.id.tv_totalBalance);
        tvDetail=getActivity().findViewById(R.id.tv_detail);
        btnWithDraw=getActivity().findViewById(R.id.btn_widthdraw);
        btnRecharge=getActivity().findViewById(R.id.btn_recharge);
        llMyjl=getActivity().findViewById(R.id.ll_myjl);
        llAutoBid=getActivity().findViewById(R.id.ll_autobid);
        llMysafety=getActivity().findViewById(R.id.ll_safety);
        llMyInvite=getActivity().findViewById(R.id.ll_myinvit);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_avanty:
                //发送广播通知MainActivity打开侧滑菜单
                Intent intent1 =new Intent("com.xidaiw.SlideMenuToggle");
                getActivity().sendBroadcast(intent1);
                break;
           case R.id.iv_help:

                break;
            case R.id.tv_detail:

                break;
            case R.id.btn_widthdraw:

                break;
            case R.id.btn_recharge:

                break;
            case R.id.ll_myjl:

                break;
            case R.id.ll_autobid:

                break;
            case R.id.ll_safety:
                Intent intent=new Intent(getActivity(), SafeCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_myinvit:

                break;

        }
    }
}
