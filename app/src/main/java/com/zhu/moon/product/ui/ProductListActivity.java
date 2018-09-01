package com.zhu.moon.product.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.zhu.moon.R;
import com.zhu.moon.base.ui.BaseActivity;
import com.zhu.moon.createOrder.entity.ProductBean;
import com.zhu.moon.createOrder.ui.ProductListAdapter;
import com.zhu.moon.product.viewModel.ProductListViewModel;
import com.zhu.moon.widget.ItemOffsetsDecoration;
import java.util.List;
import butterknife.BindView;

/**
 * 产品列表页面
 */
public class ProductListActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private ProductListAdapter mAdapter;

    private ProductListViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(ProductListViewModel.class);
        mViewModel.getProductListLiveData().observe(this, new Observer<List<ProductBean>>() {
            @Override
            public void onChanged(@Nullable List<ProductBean> productBeanList) {
                if (productBeanList!=null){
                    mAdapter = new ProductListAdapter(ProductListActivity.this,productBeanList);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(ProductListActivity.this));
                    mRecyclerView.addItemDecoration(new ItemOffsetsDecoration());
                    mRecyclerView.setAdapter(mAdapter);
                }
            }
        });
        mViewModel.requestProductList();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.product_list_activity;
    }
}
