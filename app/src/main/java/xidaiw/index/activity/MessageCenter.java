package xidaiw.index.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.xidaiw.btj.R;

public class MessageCenter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_message_center);
    }
}
