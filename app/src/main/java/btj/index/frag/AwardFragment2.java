package btj.index.frag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xidaiw.btj.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AwardFragment2 extends Fragment {
    private String html1="1.活动时间:<font color=#ff350d>2017年10月24日12:00-2017年11月24日12:00</font>;";
    private String html2="      肖美眉在2017年10月25日注册并投资30天标的10000元,那么她将获得【60元的正常投资收益+100元的新手代金券收益】,即肖美眉可以获得<font color=#ff350d>160元</font>的收益!";
    private String html3="      除此之外,肖美眉还邀请了吴大志来喜袋网投资,吴大志投资了喜袋网的90天标10000元,【吴大志将获得270元的正常投资收益+100元的新手代金券收益,共计<font color=#ff350d>370元</font>的收益】,则肖美眉又可以额外获得吴大志收益的20%,即54元的额外奖励,同时因为满足首投活动奖励20元,即<font color=#ff350d>肖美眉投资10000元的总收益为160+54+20元=234元</font>!若肖美眉继续邀请好友投资则可以获得更高的额外奖励!";
    private String html4="      与此同时,撕聪哥作为平台老客户看到大家赚到了如此多的收益,那么他立即邀请新新来喜袋网进行投资,新新投资了90天标的10000元,那么撕聪哥也可以额外获得新新收益的20%即54元的额外奖励+20元的首投奖励,共计<font color=#ff350d>74元</font>的收益!";
    public AwardFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_award2, container, false);
    }

}
