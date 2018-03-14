package xidaiw.index.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.xidaiw.btj.R;

import xidaiw.find.activity.Attention2WxActivity;
import xidaiw.find.activity.BorrowServiceActivity;
import xidaiw.find.activity.GoldMallActivity;
import xidaiw.find.activity.HelpCenterActivity;
import xidaiw.find.activity.NewsCenterActivity;
import xidaiw.index.activity.InviteAwardActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFind extends Fragment implements View.OnClickListener{
    private ImageView ivHelp;
    private LinearLayout llGoldMore;
    private LinearLayout llInvite;
    private RelativeLayout rlHelpCenter;
    private RelativeLayout rlSigin;
    private RelativeLayout rlBorrow;
    private RelativeLayout rlWx;
    private RelativeLayout rlXdTool;
    private RelativeLayout rlNews;

    public FragmentFind() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        ivHelp.setOnClickListener(this);
        llGoldMore.setOnClickListener(this);
        llInvite.setOnClickListener(this);
        rlHelpCenter.setOnClickListener(this);
        rlSigin.setOnClickListener(this);
        rlBorrow.setOnClickListener(this);
        rlWx.setOnClickListener(this);
        rlXdTool.setOnClickListener(this);
        rlNews.setOnClickListener(this);

    }

    private void initViews() {
        ivHelp=getActivity().findViewById(R.id.iv_help);
        llGoldMore=getActivity().findViewById(R.id.ll_goldmore);
        llInvite=getActivity().findViewById(R.id.ll_invite);
        rlHelpCenter=getActivity().findViewById(R.id.rl_helpcenter);
        rlSigin=getActivity().findViewById(R.id.rl_sigin);
        rlBorrow=getActivity().findViewById(R.id.rl_borrowservice);
        rlWx=getActivity().findViewById(R.id.rl_wx);
        rlXdTool=getActivity().findViewById(R.id.rl_xdtool);
        rlNews=getActivity().findViewById(R.id.rl_news);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_help:
                Toast.makeText(getActivity(), "帮助", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_goldmore:
                Intent goldMall=new Intent(getActivity(), GoldMallActivity.class);
                startActivity(goldMall);
                break;
            case R.id.ll_invite:
                Intent invite=new Intent(getActivity(), InviteAwardActivity.class);
                startActivity(invite);
                break;
            case R.id.rl_helpcenter:
                Intent helpCenter=new Intent(getActivity(), HelpCenterActivity.class);
                startActivity(helpCenter);
                break;
            case R.id.rl_sigin:
                Toast.makeText(getActivity(), "暂未开通", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_borrowservice:
                Intent borrowService=new Intent(getActivity(),BorrowServiceActivity.class);
                startActivity(borrowService);
                break;
            case R.id.rl_wx:
                Intent attentionWX=new Intent(getActivity(), Attention2WxActivity.class);
                startActivity(attentionWX);
                break;
            case R.id.rl_xdtool:
                Toast.makeText(getActivity(), "暂未开通", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_news:
                Intent newsCenter=new Intent(getActivity(), NewsCenterActivity.class);
                startActivity(newsCenter);
                break;
        }
    }
}
