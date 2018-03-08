package xidaiw.util;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by admin on 2017/10/17.
 */

public class SlidingMenu extends HorizontalScrollView {
    /**
     * 屏幕宽度
     */
    private int mScreenWidth;
    /**
     * dp
     */
    private int mMenuRightPadding = 100;
    /**
     * 菜单的宽度
     */
    private int mMenuWidth;
    private int mHalfMenuWidth;
    private boolean isOpen;
    private boolean once;
    //一般用2个参数的构造函数,如果有使用自定义属性就用3个参数的构造函数
    public SlidingMenu(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        //此处用到了ScreenUtils工具方法,用来获取系统屏幕的宽度和高度
        mScreenWidth = ScreenUtils.getScreenWidth(context);//此处用到了ScreenUtils工具方法测量屏幕的宽度
    }
    //有使用自定义属性就用3个参数的构造函数,第三个参数就是自定义的样式
//    public SlidingMenu(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        mScreenWidth = ScreenUtils.getScreenWidth(context);
//
//        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
//                R.styleable.SlidingMenu, defStyle, 0);
//        int n = a.getIndexCount();
//        for (int i = 0; i < n; i++)
//        {
//            int attr = a.getIndex(i);
//            switch (attr)
//            {
//                case R.styleable.SlidingMenu_rightPadding:
//                    // 默认50
//                    mMenuRightPadding = a.getDimensionPixelSize(attr,
//                            (int) TypedValue.applyDimension(
//                                    TypedValue.COMPLEX_UNIT_DIP, 50f,
//                                    getResources().getDisplayMetrics()));// 默认为10DP
//                    break;
//            }
//        }
//        a.recycle();
//    }

    //自定义控件的第一步:onMeasurec测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        /**
         * 显示的设置一个宽度
         */
        if (!once)
        {
            LinearLayout wrapper = (LinearLayout) getChildAt(0);//获取父布局的的第一个儿子.其实呢,父布局里面只有一个子布局
            ViewGroup menu = (ViewGroup) wrapper.getChildAt(0);//获取子布局里的第一个孙布局,第一个孙布局就是我们要隐藏的菜单布局(menu)
            ViewGroup content = (ViewGroup) wrapper.getChildAt(1);//获取子布局的第二个孙布局,第二个孙布局就是我们要显示的内容布局(content)
            // dp to px
            mMenuRightPadding = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, mMenuRightPadding, content
                            .getResources().getDisplayMetrics());

            mMenuWidth = mScreenWidth - mMenuRightPadding;
            mHalfMenuWidth = mMenuWidth / 2;
            menu.getLayoutParams().width = mMenuWidth;//设置menu的宽度
            content.getLayoutParams().width = mScreenWidth;//设置content的宽度为屏幕的宽度

        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 自定义控件的第二部:onLayout,监听布局的变化
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {

        super.onLayout(changed, l, t, r, b);
        if (changed)
        {
            // 将菜单隐藏
            Log.i("FragmentAccount","onlayout");
            smoothScrollBy(mMenuWidth, 0);
//            scrollTo(mMenuWidth, 0);
            Log.i("FragmentAccount","mMenuWidth:"+mMenuWidth);
            Log.i("FragmentAccount","mScreenWidth:"+mScreenWidth);
            once = true;
        }
    }
    /**
     * 自定义控件的第三部:onTouchEvent监听手势触摸事件
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        int action = ev.getAction();
        switch (action)
        {
            // Up时，进行判断，如果显示区域大于菜单宽度一半则完全显示，否则隐藏
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();//获取x方向的滚动的距离
                if (scrollX > mHalfMenuWidth)
                    this.smoothScrollTo(mMenuWidth, 0);
                else
                    this.smoothScrollTo(0, 0);
                return true;
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }
        return super.onTouchEvent(ev);
    }
    /**
     * 打开菜单
     */
    public void openMenu()
    {
        if (isOpen)
            return;
        this.smoothScrollTo(0, 0);
        isOpen = true;
    }

    /**
     * 关闭菜单
     */
    public void closeMenu()
    {
        if (isOpen)
        {
            this.smoothScrollTo(mMenuWidth, 0);
            isOpen = false;
        }
    }

    /**
     * 切换菜单状态
     */
    public void toggle()
    {
        if (isOpen)
        {
            closeMenu();
            //openMenu();
        } else
        {
            openMenu();
            //closeMenu();
        }
    }
}
