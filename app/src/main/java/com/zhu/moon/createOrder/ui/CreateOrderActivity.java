package com.zhu.moon.createOrder.ui;


import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhu.moon.MoonApplication;
import com.zhu.moon.R;
import com.zhu.moon.base.ui.BaseActivity;
import com.zhu.moon.base.widget.OnRecyclerViewItemClickListener;
import com.zhu.moon.createOrder.entity.ClientInfo;
import com.zhu.moon.createOrder.entity.ProductBean;
import com.zhu.moon.createOrder.viewModel.CreateOrderViewModel;
import com.zhu.moon.createOrder.entity.ClientInfoModel;
import com.zhu.moon.createOrder.entity.ProductModel;
import com.zhu.moon.createOrder.entity.ProductSubmitModel;
import com.zhu.moon.utils.StringUtils;
import com.zhu.moon.widget.ItemOffsetsDecoration;
import com.zhu.moon.widget.MaxWidthDialog;
import com.zhu.moon.widget.ProductSelectDialog;
import com.zhu.moon.widget.ProductView;
import com.zhu.moon.widget.SingleWheelPopView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import butterknife.BindView;

/**
 * 创建订单
 */
public class CreateOrderActivity extends BaseActivity implements View.OnClickListener, OnRecyclerViewItemClickListener,ProductSelectDialog.OnProductSelect {

    /**
     * 客户名称
     */
    @BindView(R.id.client_name_edit)
    EditText mClientName;

    /**
     *  根据客户名称搜索
     */
    @BindView(R.id.client_name_search)
    Button mClientNameSearch;

    /**
     * 联系人
     */
    @BindView(R.id.contact_edit)
    TextView mContact;

    /**
     * 收款方式
     */
    @BindView(R.id.payment_methods_edit)
    TextView mPaymentMethods;

    /**
     * 发票类型
     */
    @BindView(R.id.invoice_type_edit)
    TextView mInvoiceType;

    /**
     * 收货地址
     */
    @BindView(R.id.delivery_address_edit)
    TextView mDeliveryAddress;

    /**
     * 选择产品
     */
    @BindView(R.id.choose_products_edit)
    EditText mChooseProducts;

    /**
     * 搜索产品
     */
    @BindView(R.id.choose_products_search)
    Button mProductSearch;

    /**
     * 日期
     */
    @BindView(R.id.date_value)
    TextView mDate;

    /**
     * 总价
     */
    @BindView(R.id.total_prices)
    TextView mTotalPrices;

    /**
     * 创建产品布局
     */
    @BindView(R.id.commodity_list_layout)
    LinearLayout mCommodityListLayout;

    /**
     * 保存按钮
     */
    @BindView(R.id.save)
    Button mSaveButton;


    private CreateOrderViewModel mViewModel;

    private Dialog mDialog;

    private RecyclerView mRecyclerView;

    private ClientInfo mClientInfo;

    private ClientListAdapter mClientListAdapter;

    private int mProductPosition;

    private List<ProductBean> mProductBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        mProductBeanList = new ArrayList<>();
        mViewModel = ViewModelProviders.of(this).get(CreateOrderViewModel.class);
        mViewModel.getClientLiveData().observe(this, new Observer<ClientInfoModel>() {
            @Override
            public void onChanged(@Nullable ClientInfoModel clientInfoModel) {
                showClientList(clientInfoModel);
            }
        });

        mViewModel.getProductLiveData().observe(this, new Observer<ProductModel>() {
            @Override
            public void onChanged(@Nullable ProductModel productModel) {
                ProductSelectDialog.getInstance(CreateOrderActivity.this)
                        .setmProductData(productModel.data)
                        .setmInvoiceType(mInvoiceType.getText().toString().trim())
                        .setmClientId(mClientInfo.ddwid)
                        .setOnProductSelect(CreateOrderActivity.this)
                        .show();
            }
        });

        mViewModel.getProductSubmitLiveData().observe(this, new Observer<ProductSubmitModel>() {
            @Override
            public void onChanged(@Nullable ProductSubmitModel productSubmitModel) {
                addProductItem();
            }
        });
    }

    private void initView() {
        mInvoiceType.setText(initInvoiceTypeData().get(0));
        mPaymentMethods.setText(initPaymentMethodsData().get(0));
    }

    private void initListener() {
        mClientNameSearch.setOnClickListener(this);
        mPaymentMethods.setOnClickListener(this);
        mInvoiceType.setOnClickListener(this);
        mProductSearch.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.create_order_activity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.client_name_search:
                String keywords = mClientName.getText().toString();
                mViewModel.requestClientInfoData(StringUtils.isEmpty(keywords)?"":keywords);
                break;
            case R.id.payment_methods_edit:
                showPop(initPaymentMethodsData(), mPaymentMethods,"请选择收款方式");
                break;
            case R.id.invoice_type_edit:
                showPop(initInvoiceTypeData(), mInvoiceType,"请选择发票类型");
                break;
            case R.id.choose_products_search:
                String productKeywords = mChooseProducts.getText().toString();
                mViewModel.requestProductData(StringUtils.isEmpty(productKeywords)?"":productKeywords, mPaymentMethods.getText().toString().trim());
                break;
            case R.id.save:
                MoonApplication.getInstance().getAppDatabase().clientInfoDao().insert(mClientInfo);
                MoonApplication.getInstance().getAppDatabase().productDao().insertAll(mProductBeanList);
                finish();
                break;

        }
    }

    private void showClientList(ClientInfoModel clientInfoModel){
        if (mDialog ==null){
            mDialog = new MaxWidthDialog(this);
        }

        if (mRecyclerView ==null){
            mRecyclerView = new RecyclerView(this);
            mClientListAdapter = new ClientListAdapter(this,clientInfoModel.data);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mClientListAdapter);
            mRecyclerView.addItemDecoration(new ItemOffsetsDecoration());
            mRecyclerView.setBackgroundColor(this.getResources().getColor(R.color.base_bg));
            mDialog.addContentView(mRecyclerView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            mClientListAdapter.setOnRecyclerViewItemClickListener(this);
        }

        mDialog.show();
    }


    private void addProductItem(){
        ProductBean productBean = mViewModel.getProductLiveData().getValue().data.get(mProductPosition);
        mProductBeanList.add(productBean);
        View view = LayoutInflater.from(this).inflate(R.layout.product_list_item, mCommodityListLayout, false);
        new ProductView(this,view,productBean);
        mCommodityListLayout.addView(view);
        mCommodityListLayout.addView(LayoutInflater.from(this).inflate(R.layout.temp, mCommodityListLayout, false));
    }

    @Override
    public void onRecyclerViewItemClick(int position) {
        if (mDialog.isShowing()){
            mDialog.dismiss();
        }
        mClientInfo = mViewModel.getClientLiveData().getValue().data.get(position);
        mClientName.setText(mClientInfo.ddwname);
        mContact.setText(mClientInfo.lxr);
        mDeliveryAddress.setText(mClientInfo.addressps);
    }

    private void showPop(List list, TextView textView, String tip){
        View popView = View.inflate(this, R.layout.widget_single_wheel_pop, null);
        PopupWindow datePop = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        new SingleWheelPopView(this,popView,datePop,textView,list,tip);
        datePop.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        datePop.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        datePop.setBackgroundDrawable(new BitmapDrawable());
        datePop.setOutsideTouchable(true);
        View rootView = this.getWindow().getDecorView();
        datePop.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
    }

    private List<String> initPaymentMethodsData() {
        return Arrays.asList(this.getResources().getStringArray(R.array.payment_methods));
    }

    private List<String> initInvoiceTypeData() {
        return Arrays.asList(this.getResources().getStringArray(R.array.invoice_type));
    }


    @Override
    public void onProductSelect(int position) {
        mProductPosition = position;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
