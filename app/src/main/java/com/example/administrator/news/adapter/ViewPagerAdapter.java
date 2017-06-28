package com.example.administrator.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.news.fragment.NewsFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "ViewPagerAdapter";

    private ArrayList<NewsFragment> mNewsFragmentArrayList;
    private ArrayList<String> mTitleList;

    public ViewPagerAdapter(FragmentManager fm,ArrayList<NewsFragment> mNewsFragmentArrayList,ArrayList<String> mTitleList) {
        super(fm);
        this.mNewsFragmentArrayList = mNewsFragmentArrayList;
        this.mTitleList = mTitleList;
    }

    @Override
    public Fragment getItem(int position) {
//        if (position > mNewsFragmentArrayList.size()){
//            Log.d(TAG, "getItem: pppppppppppppp");
//            return mNewsFragmentArrayList.get(position);
//
//        }
        if (position < mNewsFragmentArrayList.size()){
            return mNewsFragmentArrayList.get(position);
//
        }

        return null;
    }

    @Override
    public int getCount() {
        if (mNewsFragmentArrayList == null){
            return 0;
        }
//        Log.d(TAG, "getCount: Count"+mNewsFragmentArrayList.size());
        return mNewsFragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitleList != null && position<mTitleList.size()){
            return mTitleList.get(position);
        }
//        Log.d(TAG, "getPageTitle: mTitleList"+mTitleList.size());
        return "noTitle";
    }
/*
    E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.administrator.news, PID: 1757
    java.lang.NullPointerException
    at android.support.v4.app.BackStackRecord.doAddOp(BackStackRecord.java:380)
    at android.support.v4.app.BackStackRecord.add(BackStackRecord.java:375)
    at android.support.v4.app.FragmentPagerAdapter.instantiateItem(FragmentPagerAdapter.java:103)
    at android.support.v4.view.ViewPager.addNewItem(ViewPager.java:1034)
    at android.support.v4.view.ViewPager.populate(ViewPager.java:1182)
    at android.support.v4.view.ViewPager.populate(ViewPager.java:1116)
    at android.support.v4.view.ViewPager.onMeasure(ViewPager.java:1642)
    at android.view.View.measure(View.java:16508)
    at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5125)
    at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1404)
    at android.widget.LinearLayout.measureVertical(LinearLayout.java:695)
    at android.widget.LinearLayout.onMeasure(LinearLayout.java:588)
    at android.view.View.measure(View.java:16508)
    at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5125)
    at android.widget.FrameLayout.onMeasure(FrameLayout.java:310)
    at android.view.View.measure(View.java:16508)
    at android.widget.LinearLayout.measureVertical(LinearLayout.java:847)
    at android.widget.LinearLayout.onMeasure(LinearLayout.java:588)
    at android.view.View.measure(View.java:16508)
    at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5125)
    at android.widget.FrameLayout.onMeasure(FrameLayout.java:310)
    at com.android.internal.policy.impl.PhoneWindow$DecorView.onMeasure(PhoneWindow.java:2358)
    at android.view.View.measure(View.java:16508)
    at android.view.ViewRootImpl.performMeasure(ViewRootImpl.java:2010)
    at android.view.ViewRootImpl.measureHierarchy(ViewRootImpl.java:1207)
    at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:1389)
    at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1094)
    at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:5708)
    at android.view.Choreographer$CallbackRecord.run(Choreographer.java:761)
    at android.view.Choreographer.doCallbacks(Choreographer.java:574)
    at android.view.Choreographer.doFrame(Choreographer.java:544)
    at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:747)
    at android.os.Handler.handleCallback(Handler.java:733)
    at android.os.Handler.dispatchMessage(Handler.java:95)
    at android.os.Looper.loop(Looper.java:136)
    at android.app.ActivityThread.main(ActivityThread.java:5016)
    at java.lang.reflect.Method.invokeNative(Native Method)
    at java.lang.reflect.Method.invoke(Method.java:515)
    at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:795)
    at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:611)
    at dalvik.system.NativeStart.main(Native Method)*/
}
