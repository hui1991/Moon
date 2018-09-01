package com.zhu.moon.createOrder.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zhu.moon.R;
import com.zhu.moon.base.widget.BaseAdapter;
import com.zhu.moon.createOrder.entity.ProductBean;
import java.util.List;

/**
 * Created by zhuguangjun on 2018/8/26.
 */

public class ProductListAdapter extends BaseAdapter<ProductListAdapter.ProductViewHolder> {

    private Context mContext;

    private List<ProductBean> mData;

    public ProductListAdapter(Context context,List<ProductBean> data) {
        this.mContext = context;
        mData = data;
    }

    public ProductListAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<ProductBean> data){
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(mContext).inflate(R.layout.product_list_item,parent,false));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.productName.setText(mData.get(position).dspname);
        holder.specification.setText(mData.get(position).dspspgg);
        holder.warehouse.setText(mData.get(position).dkfname);
        holder.manufacturers.setText(mData.get(position).shengccj);
        holder.inventory.setText(mData.get(position).kcsl);
        holder.batch_number.setText(mData.get(position).pihao);
        holder.productData.setText(mData.get(position).baozhiqi);
        holder.price.setText(mData.get(position).hsj);
        holder.guidePrice.setText(mData.get(position).zdcbj);
        holder.referencePrice.setText(mData.get(position).zdckj);
        holder.price.setText(mData.get(position).zhshj);
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView productName;
        TextView specification;
        TextView warehouse;
        TextView manufacturers;
        TextView inventory;
        TextView batch_number;
        TextView productData;
        TextView price;
        TextView guidePrice;
        TextView referencePrice;
        TextView last;
        public ProductViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name_value);
            specification = itemView.findViewById(R.id.specification_value);
            warehouse = itemView.findViewById(R.id.warehouse_value);
            manufacturers = itemView.findViewById(R.id.manufacturers_value);
            inventory = itemView.findViewById(R.id.inventory_value);
            batch_number = itemView.findViewById(R.id.batch_number_value);
            productData = itemView.findViewById(R.id.product_data_value);
            price = itemView.findViewById(R.id.price_value);
            guidePrice = itemView.findViewById(R.id.guide_price_value);
            referencePrice = itemView.findViewById(R.id.reference_price_value);
            last = itemView.findViewById(R.id.last_value);
        }
    }
}
