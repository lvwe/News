package com.example.administrator.news.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.news.R;
import com.example.administrator.news.fragment.JokeFragment;
import com.example.administrator.news.fragment.MainFragment;
import com.example.administrator.news.fragment.MyFragment;
import com.example.administrator.news.fragment.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

public class TopActivity extends FragmentActivity implements View.OnClickListener {
    private static final String TAG = "TopActivity";
    private ViewPager mTopViewPager;
    private TextView mTvNews, mTvJoke, mTvWeather, mTvMy;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private TopViewPagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        initTabFragmentList();
        initBottomView();
        mPagerAdapter = new TopViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mTopViewPager.setAdapter(mPagerAdapter);
        mTopViewPager.setOffscreenPageLimit(4);
        mTopViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        onChangeTextViewColor(position, mTvNews, mTvJoke, mTvWeather, mTvMy);
                        break;
                    case 1:

                        onChangeTextViewColor(position, mTvJoke, mTvNews, mTvWeather, mTvMy);
                        break;
                    case 2:

                        onChangeTextViewColor(position, mTvWeather, mTvNews, mTvJoke, mTvMy);
                        break;
                    case 3:

                        onChangeTextViewColor(position, mTvMy, mTvNews, mTvWeather, mTvJoke);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initTabFragmentList() {
        mTopViewPager = (ViewPager) findViewById(R.id.id_top_viewPager);

        MainFragment mf = new MainFragment();
        mFragmentList.add(mf);

        JokeFragment jf = new JokeFragment();
        mFragmentList.add(jf);


        WeatherFragment wf = new WeatherFragment();
        mFragmentList.add(wf);

        MyFragment myf = new MyFragment();
        mFragmentList.add(myf);

    }


    private void initBottomView() {
        mTvNews = (TextView) findViewById(R.id.id_tob_tab_news);
        mTvJoke = (TextView) findViewById(R.id.id_tob_tab_joke);
        mTvWeather = (TextView) findViewById(R.id.id_tob_tab_weather);
        mTvMy = (TextView) findViewById(R.id.id_tob_tab_my);
        mTvNews.setBackgroundColor(Color.parseColor("#F0E68C"));

        mTvNews.setOnClickListener(this);
        mTvJoke.setOnClickListener(this);
        mTvWeather.setOnClickListener(this);
        mTvMy.setOnClickListener(this);
    }

    public void onChangeTextViewColor(int position, TextView tv0, TextView tv1, TextView tv2, TextView tv3) {
        mTopViewPager.setCurrentItem(position);
        tv0.setBackgroundColor(Color.parseColor("#F0E68C"));
        tv1.setBackgroundColor(Color.WHITE);
        tv2.setBackgroundColor(Color.WHITE);
        tv3.setBackgroundColor(Color.WHITE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tob_tab_news:
                onChangeTextViewColor(0, mTvNews, mTvJoke, mTvWeather, mTvMy);
                break;
            case R.id.id_tob_tab_joke:

                onChangeTextViewColor(1, mTvJoke, mTvNews, mTvWeather, mTvMy);

                break;
            case R.id.id_tob_tab_weather:

                onChangeTextViewColor(2, mTvWeather, mTvNews, mTvJoke, mTvMy);

                break;
            case R.id.id_tob_tab_my:

                onChangeTextViewColor(3, mTvMy, mTvNews, mTvWeather, mTvJoke);

                break;
        }
    }
}
