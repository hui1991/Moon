package com.zhu.moon.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.zhu.moon.R;
import com.zhu.moon.createOrder.entity.ProductBean;

/**
 * Created by zhuguangjun on 2018/8/24.
 */

public class ProductView {
    private Context mContext;

    private View mView;


    public ProductView(Context context, View view, ProductBean productBean) {
        this.mContext = context;
        this.mView = view;
        initView(productBean);
    }

    private void initView(ProductBean productBean) {
        ((TextView)mView.findViewById(R.id.product_name_value)).setText(productBean.dspname);
        ((TextView)mView.findViewById(R.id.specification_value)).setText(productBean.dspspgg);
        ((TextView)mView.findViewById(R.id.warehouse_value)).setText(productBean.dkfname);
        ((TextView)mView.findViewById(R.id.manufacturers_value)).setText(productBean.shengccj);
        ((TextView)mView.findViewById(R.id.inventory_value)).setText(productBean.kcsl);
        ((TextView)mView.findViewById(R.id.batch_number_value)).setText(productBean.pihao);
        ((TextView)mView.findViewById(R.id.product_data_value)).setText(productBean.baozhiqi);
        ((TextView)mView.findViewById(R.id.price_value)).setText(productBean.hsj);
        ((TextView)mView.findViewById(R.id.guide_price_value)).setText(productBean.zdcbj);
        ((TextView)mView.findViewById(R.id.reference_price_value)).setText(productBean.zdckj);
        ((TextView)mView.findViewById(R.id.last_value)).setText(productBean.zhshj);

    }
}
