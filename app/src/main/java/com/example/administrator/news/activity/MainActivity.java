package com.example.administrator.news.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Toast;

import com.example.administrator.news.fragment.NewsFragment;
import com.example.administrator.news.R;
import com.example.administrator.news.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";
    private long exitTime = 0;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mPagerAdapter;
    private ArrayList<NewsFragment> mFragmentList = new ArrayList<NewsFragment>();
    private ArrayList<String> mTitleList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_RIGHT_ICON);
//        if (getSupportActionBar() != null){
//            getSupportActionBar().hide();
//        }
        setContentView(R.layout.activity_main);
        initFragmentList();
        initTitleList();

        mTabLayout = (TabLayout) findViewById(R.id.id_main_tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.id_main_viewPager);

//
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),mFragmentList,mTitleList);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);

        mTabLayout.setupWithViewPager(mViewPager);


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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if (System.currentTimeMillis() - exitTime > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
