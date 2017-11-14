package btj.util;

import android.content.Context;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.protocol.HttpContext;

public class HttpClient {

	private static AsyncHttpClient httpClient = new AsyncHttpClient();
	
	public static void post(Context context,String url,RequestParams params,AsyncHttpResponseHandler responseHandler){
		if(CheckNetWork.isNetworkAvailable(context)){
			httpClient.setTimeout(6000);//注释，源码是60000
			httpClient.post(url, params, responseHandler);
		}else{
			Toast.makeText(context, "网络已断开，请检查您的网络", Toast.LENGTH_SHORT).show();
		}
		
	}
	public static HttpContext getHttpContext(){
		return httpClient.getHttpContext();
	}
	
	public static void get(Context context,String url,AsyncHttpResponseHandler responseHandler){
		if(CheckNetWork.isNetworkAvailable(context)){
			httpClient.setTimeout(6000);//注释，源码是60000
			httpClient.get(url, responseHandler);
		}else{
			Toast.makeText(context, "网络已断开，请检查您的网络", Toast.LENGTH_SHORT).show();
		}
	}
}
