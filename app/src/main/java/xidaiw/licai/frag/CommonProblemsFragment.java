package xidaiw.licai.frag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xidaiw.btj.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommonProblemsFragment extends Fragment {


    public CommonProblemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_common_problems, container, false);
    }

}
