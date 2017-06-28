package com.example.administrator.news.app;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2017/5/25 0025.
 */

public class NewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,"e53d9e5f28247644b54c593859073312");
    }
}
