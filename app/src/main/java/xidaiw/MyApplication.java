package xidaiw;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

import java.io.IOException;

import xidaiw.util.Urls;

/**
 * Created by admin on 2017/10/26.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Urls.parse(getResources().getAssets().open("urls.xml"));
            UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
