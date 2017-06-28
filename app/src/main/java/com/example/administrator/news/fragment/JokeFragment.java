package com.example.administrator.news.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.news.adapter.JokeRecyclerViewAdapter;
import com.example.administrator.news.bean.JokesData;
import com.example.administrator.news.R;
import com.example.administrator.news.util.RecycleViewDivider;
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

public class JokeFragment extends Fragment{
    private static final String TAG = "JokeFragment";
    private static final int GET_JOKE_DATA = 1003;
    private RecyclerView mRecyclerView;
    private String apiUrl = "http://japi.juhe.cn/joke/content/list.from?key=7a979503b290b4ed8d3d30c219827280&page=2&pagesize=10&sort=asc&time=1418745237";
    private List<JokesData.ResultBean.DataBean> mJokeBeanList = new ArrayList<>();
    private JokeRecyclerViewAdapter mAdapter;
    private Handler mHandler;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getJokeData();
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == GET_JOKE_DATA){
                    mAdapter.changeData(mJokeBeanList);
                    return true;
                }else {
                    return false;
                }
            }
        });
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_joke_recyclerView);
        mAdapter = new JokeRecyclerViewAdapter(mJokeBeanList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(getContext(),LinearLayoutManager.HORIZONTAL, 2, Color.BLUE));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getContext(),
                LinearLayoutManager.HORIZONTAL,R.drawable.divider_bg));
        return view;
    }
    private void getJokeData() {
        OkHttpClient client = new OkHttpClient();
        final Request request;
        request = new Request.Builder().url("http://japi.juhe.cn/joke/content/list.from?key=7a979503b290b4ed8d3d30c219827280&page=2&pagesize=10&sort=asc&time=1418745237").build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                JokesData jokesData = gson.fromJson(response.body().string(),JokesData.class);
                mJokeBeanList = jokesData.result.data;
                mHandler.sendEmptyMessage(GET_JOKE_DATA);

            }
        });
    }
}
