package com.zhu.moon.createOrder.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zhu.moon.R;
import com.zhu.moon.base.widget.BaseAdapter;
import com.zhu.moon.createOrder.entity.ClientInfo;
import java.util.List;

/**
 * Created by zhuguangjun on 2018/8/24.
 */

public class ClientListAdapter extends BaseAdapter<ClientListAdapter.ClientViewHolder> {

    private Context mContext;

    private List<ClientInfo> mData;

    public ClientListAdapter(Context context, List<ClientInfo> data) {
        mContext = context;
        mData = data;
    }

    public void setData(List<ClientInfo> data){
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClientViewHolder(LayoutInflater.from(mContext).inflate(R.layout.create_order_client_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ClientViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.clientName.setText(mData.get(position).ddwname);
        holder.clientAddress.setText(mData.get(position).addressps);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class ClientViewHolder extends RecyclerView.ViewHolder{
        TextView clientName;
        TextView clientAddress;
        public ClientViewHolder(View itemView) {
            super(itemView);
            clientName = itemView.findViewById(R.id.client_name);
            clientAddress = itemView.findViewById(R.id.client_address);
        }
    }
}
