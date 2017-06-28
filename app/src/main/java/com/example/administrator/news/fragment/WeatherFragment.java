package com.example.administrator.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.news.R;
import com.example.administrator.news.bean.WeatherDate;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class WeatherFragment extends Fragment {
    private static final String TAG = "WeatherFragment";
    private String url= "http://v.juhe.cn/weather/geo?format=2&key=25833bf64191617c3ab01a9696540f67&lon=116.39277&lat=39.933748";
    public List<WeatherDate.ResultBean.FutureBean> mFutureBeen = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
//        getWeatherDate();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_weather,container,false);
        return view;
    }

    public void getWeatherDate() {
        OkHttpClient client = new OkHttpClient();
        final Request request;
        request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                WeatherDate weatherDate = gson.fromJson(response.body().string(),WeatherDate.class);
                mFutureBeen = weatherDate.result.future;
//                mHandler.sendEmptyMessage(GET_JOKE_DATA);
                Log.d(TAG, "onResponse: ++++++++++++++++"+mFutureBeen.size());

            }
        });
    }
}
