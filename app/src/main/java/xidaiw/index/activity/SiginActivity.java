package xidaiw.index.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xidaiw.btj.R;

import java.util.ArrayList;
import java.util.List;

public class SiginActivity extends Activity {
    private SwipeRefreshLayout srf;
    private ListView lv;
    private List<String> arrayList=new ArrayList<String>();
    private String str="标的";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sigin);
        for (int i=0;i<100;i++){
            arrayList.add(str+i);
        }
        srf=findViewById(R.id.srf);
        lv=findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,arrayList));
    }
}
