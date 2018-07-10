package com.zhu.moon.module.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zhu.moon.R;
import com.zhu.moon.data.bean.ArticleBean;
import com.zhu.moon.web.WebViewActivity;

import java.util.List;

/**
 * Created by zhuguangjun on 2018/7/9.
 */

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder>{

    private Context mContext;
    private List<ArticleBean> mData;


    public HomeListAdapter(Context context, List<ArticleBean> data) {
        this.mContext = context;
        this.mData = data;
    }

    public void setData(List<ArticleBean> data){
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mData.get(position).title);
        holder.author.setText(mData.get(position).author);
        holder.time.setText(mData.get(position).niceDate);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int viewLayoutPosition = ((RecyclerView.LayoutParams) v.getLayoutParams()).getViewLayoutPosition();
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra(WebViewActivity.URL,mData.get(viewLayoutPosition).link);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView author;
        TextView time;
        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.home_list_item_title);
            author = itemView.findViewById(R.id.home_list_item_author);
            time = itemView.findViewById(R.id.home_list_item_time);
        }
    }
}
