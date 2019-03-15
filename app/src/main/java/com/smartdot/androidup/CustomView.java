package com.smartdot.androidup;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

public class CustomView extends View {
    private int lastx;
    private int lasty;
    private Scroller mScroller;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();


        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();

        }

    }

    public void smootheScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        mScroller.startScroll(scrollX, 0, delta, 0, 2000);
        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastx = x;
                lasty = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetx = x - lastx;
                int offsety = y - lasty;
//                layout(getLeft() + offsetx, getTop() + offsety, getRight() + offsetx, getBottom() + offsety);
//                offsetLeftAndRight(offsetx);
//                offsetTopAndBottom(offsety);
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
//                layoutParams.leftMargin = getLeft() + offsetx;
//                layoutParams.topMargin = getTop() + offsety;
//                setLayoutParams(layoutParams);
                ((View) getParent()).scrollBy(-offsetx, -offsety);

                break;
        }


        return true;
    }


}
