package com.example.administrator.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.news.bean.NewsData;
import com.example.administrator.news.util.OnItemClickListener;
import com.example.administrator.news.R;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24 0024.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<NewsViewHolder> implements View.OnClickListener{


    private List<NewsData.ResultBean.NewsBean> mNewsBeanList;
    private OnItemClickListener mOnItemClickListener = null;


    public RecycleViewAdapter(List<NewsData.ResultBean.NewsBean> mNewsBeanList) {
        this.mNewsBeanList = mNewsBeanList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_view, parent, false);
        NewsViewHolder holder = new NewsViewHolder(view);
        view.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        final NewsData.ResultBean.NewsBean newsBean = mNewsBeanList.get(position);
        holder.mTextView.setText(newsBean.getTitle());
        Glide.with(holder.mImageView.getContext())
                .load(newsBean.getThumbnail_pic_s())
                .into(holder.mImageView);
        holder.itemView.setTag(position);


    }

    @Override
    public int getItemCount() {
        return mNewsBeanList.size();
    }

    public void changeData(List<NewsData.ResultBean.NewsBean> newsBeanList) {
        this.mNewsBeanList = newsBeanList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onClick(View v) {
     if (mOnItemClickListener != null){
         mOnItemClickListener.OnItemClick(v, (int)v.getTag());
     }
    }
}

class NewsViewHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView;
    public TextView mTextView;


    public NewsViewHolder(View itemView) {
        super(itemView);

        mImageView = (ImageView) itemView.findViewById(R.id.id_item_imgView);
        mTextView = (TextView) itemView.findViewById(R.id.id_item_textView);
    }
}
