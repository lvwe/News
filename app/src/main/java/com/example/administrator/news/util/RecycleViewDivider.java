package com.example.administrator.news.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

public class RecycleViewDivider extends RecyclerView.ItemDecoration {
    private static final String TAG = "RecycleViewDivider";
    private Paint mPaint;
    private Drawable mDivider;
    private int mDividerHeight = 2;//分割线高度
    private int mOrientation;  //列表的方向LinearLayoutManager.VERTICAL或LinearLayoutManager.HORIZONTAL
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

    public RecycleViewDivider(Context context, int orientation) {
        if (orientation != LinearLayoutManager.VERTICAL && orientation != LinearLayoutManager.HORIZONTAL) {
            throw new IllegalArgumentException("请输入正确的参数");
        }
        mOrientation = orientation;
//        一定要确保调用  recycle()函数 。用于检索从这个结构对应于给定的属性位置到obtainStyledAttributes中的值
//        public TypedArray obtainStyledAttributes (AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes)
//        public TypedArray obtainAttributes (AttributeSet set, int[] attrs)（说明此函数）
//        说明：返回一个由AttributeSet获得的一系列的基本的属性值，不需要用用一个主题或者/和样式资源执行样式。
//        参数：
//        set：现在检索的属性值；
//        attrs：制定的检索的属性值
//        public void recycle()
//        返回先前检索的数组，稍后再用。

//        包含函数 obtainStyledAttributes(AttributeSet, int[], int, int) 或者 obtainAttributes(AttributeSet, int[])检索的数组值。
//        想获取Android的资源文件，可以使用context.getresource.getXXX得到，也可以通过TypedArray得到,
//        TypedArray是存储资源数组的容器，他可以通过obtaiStyledAttributes()方法创建出来。不过创建完后，如果不在使用了，请注意调用recycle()方法把它释放。
//        他可以通过检索res资源中结构的特定值的索引的到对应的资源。所以换句话说，通过他能够得到我们想要的资源
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
//        调用obtainStyledAttributes方法，会返回一个TypedArray,持有属性排序的属性值
        mDivider = a.getDrawable(0);
        a.recycle();
    }

//    调用资源文件
    public RecycleViewDivider(Context context, int orientation, int drawableId) {
        this(context, orientation);
        mDivider = ContextCompat.getDrawable(context, drawableId);
//        intrinsic:内在;
//        美式：[ɪn'trɪnsɪk];英式：[ɪn'trɪnsɪk];
//        adj. 本质的，固有的
//        网络释义：
//        intrinsic : 固有的,内在,本征的,
//                intrinsic equation : 内蕴方程,内禀方程,本性方程式,
//                Intrinsic 31 : 内在三一
// 用来取得Drawable的固有的宽度和高度,
        mDividerHeight = mDivider.getIntrinsicHeight();
    }

    public RecycleViewDivider(Context context, int orientation, int dividerHeight, int dividerColor) {
        this(context, orientation);
        mDividerHeight = dividerHeight;
//        1.Paint.Style.STROKE：描边 。2.Paint.Style.FILL_AND_STROKE：描边并填充 。3.Paint.Style.FILL：填充 。
//        Paint.ANTI_ALIAS_FLAG  －－用于绘制时抗锯齿
//        setAlpha(int a): 用于设置Paint 的透明度；
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(dividerColor);
//        Style.FILL：实心。
//        Style.STROKE：空心。
        mPaint.setStyle(Paint.Style.FILL);
        /**
         * stroke:中风;
         美式：[strok];英式：[strəʊk];
         n. 中风；冲程；笔画；打击；尝试；轻抚
         vt. 抚摸；敲击；划尾桨；划掉
         vi. 击球；作尾桨手；敲击键盘
         网络释义：
         Stroke : 行程,中风,击球,
         Sheffer stroke : 谢费尔竖线,谢费尔竖线,薛佛冲程,
         intake stroke : 进气行程,进气冲程,吸入冲程,
         */
//        mPaint.setStyle(Paint.Style.STROKE);
    }

    //    获取分割线尺寸
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, mDividerHeight);
    }

    //    绘制分割线
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        final int left = parent.getPaddingLeft();  //=0
        final int right = parent.getMeasuredWidth() - parent.getPaddingRight(); // =1080
        final int childSize = parent.getChildCount();//界面显示RecyclerView个数

        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom()+layoutParams.bottomMargin;
            Log.d(TAG, "drawHorizontal: "+child.getBottom());
            final int bottom = top + mDividerHeight;
            if (mDivider != null){
// setBounds(x,y,width,height); x:组件在容器X轴上的起点 y:组件在容器Y轴上的起点 width:组件的长度 height:组件的高度
                mDivider.setBounds(left,top,right,bottom);
                mDivider.draw(canvas);
            }
            if (mPaint != null){
                canvas.drawRect(left,top,right,bottom,mPaint);
            }
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView parent) {

        final int top = parent.getPaddingLeft();
        final int bottom = parent.getMeasuredWidth() - parent.getPaddingRight();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getHeight()+layoutParams.rightMargin;
            final int right = left + mDividerHeight;
            if (mDivider != null){
                mDivider.setBounds(left,top,right,bottom);
                mDivider.draw(canvas);
            }
            if (mPaint != null){
                canvas.drawRect(left,top,right,bottom,mPaint);
            }
        }
    }
}
