package com.example.administrator.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.news.R;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class MyFragment extends Fragment{

    /**
     *
     * @param inflater
     * @param container 继承父布局参数信息
     * @param savedInstanceState
     * 即container只用来创建母布局的参数信息。而为true，则添加到母布局。
     * 因为我们控制fragment时要手动add，所以此处attachToRoot一定是false。
     * @return
     */

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my,container,false);
         return view;
    }
}
