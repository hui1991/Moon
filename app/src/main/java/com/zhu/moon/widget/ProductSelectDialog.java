package com.zhu.moon.widget;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.zhu.moon.R;
import com.zhu.moon.base.widget.OnRecyclerViewItemClickListener;
import com.zhu.moon.createOrder.entity.ProductBean;
import com.zhu.moon.createOrder.ui.CreateOrderActivity;
import com.zhu.moon.createOrder.viewModel.CreateOrderViewModel;
import com.zhu.moon.createOrder.ui.ProductListAdapter;
import java.util.List;

/**
 * Created by zhuguangjun on 2018/8/25.
 */

public class ProductSelectDialog extends MaxWidthDialog implements View.OnClickListener, OnRecyclerViewItemClickListener {

    private static  volatile ProductSelectDialog mInstance;

    private Context mContext;

    RecyclerView mRecyclerView;

    TextView mProduct;

    TextView mManufacturers;

    TextView mBatchNumber;

    TextView mProductData;

    TextView mPrice;

    TextView mCount;

    Button mConfirm;

    Button mCancel;

    private View mRootView;

    private ProductListAdapter mAdapter;

    private List<ProductBean> mData;

    private ProductBean mProductBean;

    private String mInvoiceType;

    private String mClientId;

    private OnProductSelect mOnProductSelect;

    private int mProductPosition;

    private ProductSelectDialog(@NonNull Context context) {
        super(context);
    }

    public static ProductSelectDialog getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ProductSelectDialog.class) {
                if (mInstance == null) {
                    mInstance = new ProductSelectDialog(context);
                    mInstance.init(context);
                }
            }
        }

        return mInstance;
    }

    private  void init(Context context) {
        mInstance.mContext = context;
        initView();
        initListener();
    }

    private void initView() {
        mRootView = View.inflate(mContext,R.layout.create_order_product_select_layout,null);
        mRecyclerView = mRootView.findViewById(R.id.recyclerView);
        mProduct = mRootView.findViewById(R.id.product_name_value);
        mManufacturers = mRootView.findViewById(R.id.manufacturers_value);
        mBatchNumber = mRootView.findViewById(R.id.batch_number_value);
        mProductData = mRootView.findViewById(R.id.product_data_value);
        mPrice = mRootView.findViewById(R.id.price_edit);
        mCount = mRootView.findViewById(R.id.count_edit);
//        price_down = mRootView.findViewById(R.id.price_arrow_down);
//        price_up = mRootView.findViewById(R.id.price_arrow_up);
//        count_down = mRootView.findViewById(R.id.count_arrow_down);
//        count_up = mRootView.findViewById(R.id.count_arrow_up);
        mCancel = mRootView.findViewById(R.id.cancel);
        mConfirm = mRootView.findViewById(R.id.confirm);
        mAdapter = new ProductListAdapter(mContext);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new ItemOffsetsDecoration());
        mRecyclerView.setAdapter(mAdapter);

        addContentView(mRootView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
    }

    private void initListener() {
//        price_down.setOnClickListener(this);
//        price_up.setOnClickListener(this);
//        count_down.setOnClickListener(this);
//        count_up.setOnClickListener(this);
        mConfirm.setOnClickListener(this);
        mCancel.setOnClickListener(this);
        mAdapter.setOnRecyclerViewItemClickListener(this);
    }


    public ProductSelectDialog setmProductData(List<ProductBean> data){
        mData = data;
        mAdapter.setData(mData);
        return this;
    }


    public ProductSelectDialog setmInvoiceType(String mInvoiceType) {
        this.mInvoiceType = mInvoiceType;
        return this;
    }

    public ProductSelectDialog setmClientId(String mClientId) {
        this.mClientId = mClientId;
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.price_arrow_down:
//
//                break;
//            case R.id.price_arrow_up:
//
//                break;
//            case R.id.count_arrow_down:
//
//                break;
//            case R.id.count_arrow_up:
//
//                break;
            case R.id.confirm:
                if (mOnProductSelect!=null){
                    mOnProductSelect.onProductSelect(mProductPosition);
                }
                ViewModelProviders.of(((CreateOrderActivity)mContext)).get(CreateOrderViewModel.class).requestProductSubmitData(mInvoiceType, mProductBean, mPrice.getText().toString(), mCount.getText().toString(), mClientId);
                if (mInstance.isShowing()){
                    mInstance.dismiss();
                }
                break;
            case R.id.cancel:
                if (mInstance.isShowing()){
                    mInstance.dismiss();
                }
                break;
        }
    }

    @Override
    public void onRecyclerViewItemClick(int position) {
        mProductPosition = position;
        mProductBean = mData.get(position);
        if (mProductBean !=null){
            mProduct.setText(mProductBean.dspname);
            mManufacturers.setText(mProductBean.shengccj);
            mBatchNumber.setText(mProductBean.pihao);
            mProductData.setText(mProductBean.baozhiqi);
            mPrice.setText(mProductBean.hsj);
            mCount.setText("1.00");
        }
    }

    public ProductSelectDialog setOnProductSelect(OnProductSelect onProductSelect) {
        mOnProductSelect = onProductSelect;
        return this;
    }

    public interface OnProductSelect{
        void onProductSelect(int position);
    }
}
