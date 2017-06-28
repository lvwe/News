package com.example.administrator.news.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.administrator.news.R;

public class GuideActivity extends Activity {

    private ViewFlipper mViewFlipper;
    private TextView mTextView;
    private CustomGestureDetectorListener mGestureDetectorListener;
    private GestureDetector mGestureDetector;

    Animation leftInAnimation;
    Animation leftOutAnimation;
    Animation rightInAnimation;
    Animation rightOutAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mViewFlipper = (ViewFlipper) findViewById(R.id.id_guide_flipper);
        mTextView = (TextView) findViewById(R.id.id_guide_textView);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this,TopActivity.class));
                finish();
            }
        });
        mGestureDetectorListener = new CustomGestureDetectorListener();
        mGestureDetector = new GestureDetector(GuideActivity.this,mGestureDetectorListener);
//        动画效果
        leftInAnimation = AnimationUtils.loadAnimation(GuideActivity.this,R.anim.left_in);
        leftOutAnimation = AnimationUtils.loadAnimation(GuideActivity.this,R.anim.left_out);
        rightInAnimation = AnimationUtils.loadAnimation(GuideActivity.this,R.anim.right_in);
        rightOutAnimation = AnimationUtils.loadAnimation(GuideActivity.this,R.anim.right_out);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    class CustomGestureDetectorListener extends GestureDetector.SimpleOnGestureListener{
//        按下（onDown）： 刚刚手指接触到触摸屏的那一刹那，就是触的那一下。
//        抛掷（onFling）： 手指在触摸屏上迅速移动，并松开的动作。
//        长按（onLongPress）： 手指按在持续一段时间，并且没有松开。
//        滚动（onScroll）： 手指在触摸屏上滑动。
//        按住（onShowPress）： 手指按在触摸屏上，它的时间范围在按下起效，在长按之前。
//        抬起（onSingleTapUp）：手指离开触摸屏的那一刹那。

        /**
         *
         * @param e1 第1个ACTION_DOWN MotionEvent 并且只有一个
         * @param e2  最后一个ACTION_MOVE MotionEvent
         * @param velocityX X轴上的移动速度，像素/秒
         * @param velocityY  Y轴上的移动速度，像素/秒
         * @return
         */
//        抛掷（onFling）： 手指在触摸屏上迅速移动，并松开的动作。
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() > e2.getX()){
                mViewFlipper.setInAnimation(leftInAnimation);
                mViewFlipper.setOutAnimation(leftOutAnimation);
                mViewFlipper.showNext();
            }
            if (e1.getX() < e2.getX()){
                mViewFlipper.setInAnimation(rightInAnimation);
                mViewFlipper.setOutAnimation(rightOutAnimation);
                mViewFlipper.showPrevious();
            }


            return super.onFling(e1, e2, velocityX, velocityY);

        }
/*
        tap:利用;
        美式：[tæp];英式：[tæp];
        vt. 轻敲；轻打；装上嘴子
        vi. 轻拍；轻击；轻叩
        n. 水龙头；轻打
        n. (Tap)人名；(柬)塔；(朝)塔
        网络释义：
        tap : 水龙头,水龙头,攻丝,
        tap in : 托球入篮,将很短的推击击球入洞,托球进篮,
        Tap Tap : 手机游戏,音乐工坊,表演者,*/
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return super.onSingleTapUp(e);
        }


        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }


    }
}
