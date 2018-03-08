package xidaiw.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.xidaiw.btj.R;

/**
 * Created by admin on 2017/11/9.ll_wx_share
 */

public class RewritePopwindow extends PopupWindow {

    private View mView;

    public RewritePopwindow(Activity context, View.OnClickListener itemsOnClick) {
        super(context);
        initView(context, itemsOnClick);
    }

    private void initView(final Activity context, View.OnClickListener itemsOnClick) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mInflater.inflate(R.layout.invite_share, null);
        LinearLayout wxFriend = (LinearLayout) mView.findViewById(R.id.ll_wxFriends);
        LinearLayout wxShare = (LinearLayout) mView.findViewById(R.id.ll_wx_share);
        LinearLayout textMessage = (LinearLayout) mView.findViewById(R.id.ll_textMessage);
        LinearLayout qqShare = (LinearLayout) mView.findViewById(R.id.ll_qq);
        LinearLayout qqZoneShare = (LinearLayout) mView.findViewById(R.id.ll_qq_zone);
        LinearLayout canaleShare = (LinearLayout) mView.findViewById(R.id.ll_cancel_share);
        canaleShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //销毁弹出框
                dismiss();
                backgroundAlpha(context, 1f);
            }
        });

        //设置按钮监听
        wxFriend.setOnClickListener(itemsOnClick);
        wxShare.setOnClickListener(itemsOnClick);
        textMessage.setOnClickListener(itemsOnClick);
        qqShare.setOnClickListener(itemsOnClick);
        qqZoneShare.setOnClickListener(itemsOnClick);

        //设置SelectPicPopupWindow的View
        this.setContentView(mView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置PopupWindow可触摸
        this.setTouchable(true);
        //设置非PopupWindow区域是否可触摸
        this.setOutsideTouchable(false);
        //设置SelectPicPopupWindow弹出窗体动画效果
        setAnimationStyle(R.style.invite_popup_anim);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        backgroundAlpha(context, 0.5f);//0.0-1.0
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                // TODO Auto-generated method stub
                backgroundAlpha(context, 1f);
            }
        });
    }
    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }

}

