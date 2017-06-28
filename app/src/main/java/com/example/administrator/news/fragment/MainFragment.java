package com.example.administrator.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.news.R;
import com.example.administrator.news.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    private static final String TAG = "MainActivity";
    private long exitTime = 0;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mPagerAdapter;
    private ArrayList<NewsFragment> mFragmentList = new ArrayList<NewsFragment>();
    private ArrayList<String> mTitleList = new ArrayList<String>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTitleList();
        initFragmentList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container,false);
        mTabLayout = (TabLayout) view.findViewById(R.id.id_main_tabLayout);
        mViewPager = (ViewPager) view.findViewById(R.id.id_main_viewPager);
        if (mPagerAdapter == null){
            mPagerAdapter = new ViewPagerAdapter(getFragmentManager(),mFragmentList,mTitleList);
        }
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);

        return view;
    }

    private void initTitleList() {
        mTitleList.add("头条");
        mTitleList.add("娱乐");
        mTitleList.add("体育");
        mTitleList.add("科技");
    }

    private void initFragmentList() {
        NewsFragment fa = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("NEWSTYPE",1);
        fa.setArguments(bundle);

        NewsFragment fb = new NewsFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("NEWSTYPE",2);
        fb.setArguments(bundle2);

        NewsFragment fc = new NewsFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("NEWSTYPE",3);
        fc.setArguments(bundle3);

        NewsFragment fd = new NewsFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putInt("NEWSTYPE",4);
        fd.setArguments(bundle4);
        if (mFragmentList != null){
            mFragmentList.add(fa);
            mFragmentList.add(fb);
            mFragmentList.add(fc);
            mFragmentList.add(fd);
        }

    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
//            if (System.currentTimeMillis() - exitTime > 2000){
//                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                exitTime = System.currentTimeMillis();
//            }else {
//                finish();
//                System.exit(0);
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
