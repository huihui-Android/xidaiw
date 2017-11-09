package xidaiw.index.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.xidaiw.btj.R;

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
                break;
            case R.id.ll_goldmore:
                break;
            case R.id.ll_invite:
                break;
            case R.id.rl_helpcenter:
                break;
            case R.id.rl_sigin:
                break;
            case R.id.rl_borrowservice:
                break;
            case R.id.rl_wx:
                break;
            case R.id.rl_xdtool:
                break;
            case R.id.rl_news:
                break;
        }
    }
}
