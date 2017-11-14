package btj.util.progressBar;

import android.app.ProgressDialog;
import android.content.Context;

public class AsyncDialog {

	private static ProgressDialog dialog;
	
	public static void show(Context context,String message){
		
		
		dialog = new ProgressDialog(context);
		
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setMessage(message);
		dialog.setIndeterminate(true);
		dialog.setCancelable(false);  
		dialog.show();
	}
	
	public static void hide(){
		if(dialog!=null){
			dialog.dismiss();
			dialog=null;
		}
	}
}
