package com.zhu.moon.base.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 封装item点击监听的recyclerView  adapter
 * Created by zhuguangjun on 2018/8/25.
 */

public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener){
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int viewLayoutPosition = ((RecyclerView.LayoutParams) v.getLayoutParams()).getViewLayoutPosition();
                if (mOnRecyclerViewItemClickListener!=null){
                    mOnRecyclerViewItemClickListener.onRecyclerViewItemClick(viewLayoutPosition);
                }
            }
        });
    }
}
