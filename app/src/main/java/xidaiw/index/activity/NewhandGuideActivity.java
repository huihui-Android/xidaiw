package xidaiw.index.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.xidaiw.btj.R;

public class NewhandGuideActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_newhand_guide);
    }
}
