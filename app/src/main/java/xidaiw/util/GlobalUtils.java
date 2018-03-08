package xidaiw.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GlobalUtils {

	/**
	 * 金钱格式转换
	 * @param money
	 * @return
     */
	public static String NumberFormatTransfer(String money){
		NumberFormat nf = new DecimalFormat("#,###");
	    String str = nf.format(Double.valueOf(money));
		return str;
	}
	
	public static double StringTransferDouble(String str){
		return (new BigDecimal(str)).doubleValue();
	}
	
	public static int StringTransferInteger(String str){
		return (new BigDecimal(str)).intValue();
	}
	/**
	 * 指定时间距现在的时间差
	 * @param time
	 * @return
	 */
	public static Long getTime(String time){
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
			return date.getTime() - new Date().getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 保留两位小数
	 */
	public static String NumberFormatTranferTwo(String money){
		if(money==null || "".equals(money)){
			return "0.00";
		}
		return (new DecimalFormat("0.00")).format(new BigDecimal(money));
	}

	
	//343,535.34
	public static String moneyWithDouble(double money){
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(2);
		return format.format(money);
	}
	
	/**
	 * 双击退出函数
	 */
	private static Boolean isExit = false;

	public static  void exitBy2Click(Activity activity) {
		Timer tExit = null;
		if (isExit == false) {
			isExit = true; // 准备退出
			Toast.makeText(activity, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			tExit = new Timer();
			tExit.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false; // 取消退出
				}
			}, 2000); //如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

		} else {
			activity.finish();
			//System.exit(0);
		}
	}
	
	/**
	 * 获取网络图片的数据
	 * @param path 网络图片路径
	 * @return
	 */
	public static byte[] getImageToByte(String path) throws Exception{
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();//基于HTTP协议连接对象
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		if(conn.getResponseCode() == 200){
			InputStream inStream = conn.getInputStream();
			return read(inStream);
		}
		return null;
	}
	
	/**
	 * 读取流中的数据
	 * @param inStream
	 * @return
	 * @throws Exception
	 */
	public static byte[] read(InputStream inStream) throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while( (len = inStream.read(buffer)) != -1){
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}
	/**
	 * 异步获取图片
	 * @param imagePath
	 * @param view
	 */
	private ImageView view;
	public void setImageToImageView( final String imagePath, ImageView view){
		this.view = view;
		final Handler mHandler = new ImageHandler();//作用：向创建该handler对象所在线程发送消息
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					byte[] data = getImageToByte(imagePath);
					Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
					Message msg = new Message();
					mHandler.obtainMessage(1, bitmap).sendToTarget();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		thread.start();
		
	}
	
	  class  ImageHandler extends Handler{
		  //主线程中消息队列接受到消息，会在主线程中调用handleMessage
		public void handleMessage(Message msg){
		     super.handleMessage(msg);   
		     Bitmap bitmap = (Bitmap) msg.obj;
		     view.setImageBitmap(bitmap);
		}
	}
	/**
	 * 校验手机号
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }  
	
	public static void sendBrodCast(String action,Context context,String key,String value){
		Intent intent = new Intent();
		intent.setAction(action);
		if(key!=null && value!=null){
		  intent.putExtra(key, value);
		}
		context.sendBroadcast(intent);
	}
	
	public static String getSafeUserName(String userName){
		String index = userName.substring(0, 1);
		String last = userName.substring(userName.length()-1);
		String mid = "";
		if(userName.length()>2){
			for (int i=0;i<userName.length()-2;i++) {
				mid=mid+"*";
			}
		}
		userName = index+mid+last;
		return userName;
	}
}
