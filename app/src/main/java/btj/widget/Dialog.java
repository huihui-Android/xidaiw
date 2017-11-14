package btj.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.xidaiw.btj.R;

import static com.xidaiw.btj.R.id.tv_confirm;

public class Dialog {

	/** 只带确定按钮，通用对话框，传Activity*//*
	public static void singleGeneralDialog(String message, Activity activity) {
		final AlertDialog dlg = new AlertDialog.Builder(activity).create();
		dlg.show();
		Window window = dlg.getWindow();
		window.setContentView(R.layout.dialog_paynotice);
		TextView tv_Confirm = (TextView) window.findViewById(R.id.tv_Confirm);
		TextView tv_message = (TextView) window.findViewById(R.id.tv_message);
		tv_message.setText(message);
		tv_Confirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dlg.cancel();
			}
		});
	}*/
	
	/** 只带确定按钮，通用对话框，传Context*/
	public static void singleGeneralDialog(String message, Context context) {
	    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
	    builder.setCancelable(false);
	    final AlertDialog  dialog = builder.create();
	    dialog.show();
	    Window window = dialog.getWindow();
		window.setContentView(R.layout.dialog_certificate);
		TextView tv_Confirm = (TextView) window.findViewById(tv_confirm);
		TextView tv_message = (TextView) window.findViewById(R.id.tv_message);
		tv_message.setText(message);
		tv_Confirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.cancel();
			}
		});
		
	}
	
}
