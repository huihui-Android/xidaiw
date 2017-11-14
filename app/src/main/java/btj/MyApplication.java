package btj;

import android.app.Application;

import java.io.IOException;

import btj.util.Urls;

/**
 * Created by admin on 2017/10/26.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Urls.parse(getResources().getAssets().open("urls.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
