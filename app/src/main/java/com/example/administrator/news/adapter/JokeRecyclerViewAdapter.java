package com.example.administrator.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.news.bean.JokesData;
import com.example.administrator.news.R;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

public class JokeRecyclerViewAdapter extends RecyclerView.Adapter<JokeRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "JokeRecyclerViewAdapter";
    private List<JokesData.ResultBean.DataBean> mJokeBeanList;

    public JokeRecyclerViewAdapter(List<JokesData.ResultBean.DataBean> jokeBeanList) {
        this.mJokeBeanList = jokeBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //content
        JokesData.ResultBean.DataBean jokeBean = mJokeBeanList.get(position);
        holder.mTextView.setText("         "+jokeBean.content);
        Log.d(TAG, "onBindViewHolder: "+mJokeBeanList.size());
    }

    @Override
    public int getItemCount() {
        return mJokeBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.id_joke_item_tv);
        }
    }
    public void changeData(List<JokesData.ResultBean.DataBean> jokeBeanList){
        this.mJokeBeanList = jokeBeanList;
        notifyDataSetChanged();
    }
}
