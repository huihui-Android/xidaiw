package xidaiw.index.frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xidaiw.btj.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AwardFragment1 extends Fragment {
    private String html1="1.被邀请人在7天内完成首笔投资满<font color=#ff350d>5000</font>元(仅限活动标),被邀请人在30天内完成复投满<font color=#ff350d>10000</font>元(仅限活动标),邀请人可以获得相应面额红包奖励:";
    private String html2="3.<font color=#ff350d>奖励为现金红包,可直接提现</font>,将于T+1个工作日发放到喜袋网账户中;";
    private TextView textView1;
    private TextView textView2;
    public AwardFragment1() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_award1, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        textView1 = activity.findViewById(R.id.text1);
        textView2=activity.findViewById(R.id.text2);
        textView1.setText(Html.fromHtml(html1));
        textView2.setText(Html.fromHtml(html2));
    }
}
