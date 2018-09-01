package com.zhu.moon.main.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.zhu.moon.R;
import com.zhu.moon.base.ui.BaseActivity;
import com.zhu.moon.main.entity.UserInfoModel;
import com.zhu.moon.main.viewModel.MainViewModel;
import com.zhu.moon.product.ui.ProductListActivity;
import com.zhu.moon.createOrder.ui.CreateOrderActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.create_order)
    Button mCreateOrder;

    @BindView(R.id.product_list)
    Button mProductList;

    private MainViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getUserLiveData().observe(this, new Observer<UserInfoModel>() {
            @Override
            public void onChanged(@Nullable UserInfoModel userInfoModel) {

            }
        });
        mViewModel.requestUserData();
    }

    private void initListener(){
        mCreateOrder.setOnClickListener(this);
        mProductList.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_order:
                startActivity(CreateOrderActivity.class);
                break;
            case R.id.product_list:
                startActivity(ProductListActivity.class);
                break;
        }
    }
}
