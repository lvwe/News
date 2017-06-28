package com.example.administrator.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.news.bean.NewsData;
import com.example.administrator.news.util.OnItemClickListener;
import com.example.administrator.news.R;
import com.example.administrator.news.adapter.RecycleViewAdapter;
import com.example.administrator.news.activity.ShowNewsActivity;
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
 * Created by Administrator on 2017/5/23 0023.
 */

public class NewsFragment extends Fragment {
    private static final String TAG = "NewsFragment";
    private int mType;
    private String text;
    private View mView;
    private TextView mTextView;
    private static final int GET_NEW_MSG = 1001;
    private List<NewsData.ResultBean.NewsBean> mNewsBeanList = new ArrayList<>();
    private RecycleViewAdapter mRecycleViewAdapter;
    private RecyclerView mRecyclerView;
    private final String URL1 = "http://v.juhe.cn/toutiao/index?type=top&key=951120925db65e7801656e888efa6c4c";
    private final String URL2 = "http://v.juhe.cn/toutiao/index?type=yule&key=951120925db65e7801656e888efa6c4c";
    private final String URL3 = "http://v.juhe.cn/toutiao/index?type=tiyu&key=951120925db65e7801656e888efa6c4c";
    private final String URL4 = "http://v.juhe.cn/toutiao/index?type=keji&key=951120925db65e7801656e888efa6c4c";

    private Handler mHandler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mType = getArguments().getInt("NEWSTYPE");

        getNewsFromJuhe();
        initHandle();





    }

    private void initHandle() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
            if (msg.what == GET_NEW_MSG){
                mRecycleViewAdapter.changeData(mNewsBeanList);
                return true;
            }
                return false;
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        if (mView == null){
            mView = inflater.inflate(R.layout.fragment_news,container,false);

        }
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.id_fragment_reView);

        mRecycleViewAdapter = new RecycleViewAdapter(mNewsBeanList);
        mRecyclerView.setAdapter(mRecycleViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycleViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                String url = mNewsBeanList.get(position).getUrl();
                String key = mNewsBeanList.get(position).getUniquekey();
                String titlt = mNewsBeanList.get(position).getTitle();
                Intent intent = new Intent(getContext(),ShowNewsActivity.class);
                intent.putExtra(ShowNewsActivity.URL_EXTRA,url);
                intent.putExtra(ShowNewsActivity.KEY_EXTRA,key);
                intent.putExtra(ShowNewsActivity.TITLE_EXTRA,titlt);
                startActivity(intent);

            }
        });


        return mView;
    }
    private void getNewsFromJuhe() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request;
        switch (mType){
            case 1:
                request = new Request.Builder().url(URL1).build();

                Log.d(TAG, "getNewsFromJuhe: case1");
                break;
            case 2:
                request = new Request.Builder().url(URL2).build();
                Log.d(TAG, "getNewsFromJuhe: case2");
                break;
            case 3:
                request = new Request.Builder().url(URL3).build();
                Log.d(TAG, "getNewsFromJuhe: case3");
                break;
            case 4:
                request = new Request.Builder().url(URL4).build();
                Log.d(TAG, "getNewsFromJuhe: case4");
                break;
            default:
                request = new Request.Builder().url(URL1).build();
                Log.d(TAG, "getNewsFromJuhe: default");
                break;

        }
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Gson gson = new Gson();
                NewsData newsData = gson.fromJson(response.body().string(),NewsData.class);
                mNewsBeanList = newsData.getResult().getData();
                mHandler.sendEmptyMessage(GET_NEW_MSG);
            }
        });
}
}

