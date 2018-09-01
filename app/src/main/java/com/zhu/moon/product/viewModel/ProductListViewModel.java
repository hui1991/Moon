package com.zhu.moon.product.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.zhu.moon.MoonApplication;
import com.zhu.moon.createOrder.entity.ProductBean;
import java.util.List;



/**
 * 产品列表页面viewModel
 * Created by zhuguangjun on 2018/8/24.
 */

public class ProductListViewModel extends AndroidViewModel {

    public static final String TAG = "ProductListViewModel";

    public ProductListViewModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<List<ProductBean>> mProductListLiveData;


    public MutableLiveData<List<ProductBean>> getProductListLiveData(){
        if (mProductListLiveData==null){
            mProductListLiveData = new MutableLiveData<>();
        }
        return mProductListLiveData;
    }

    public void requestProductList(){
        List<ProductBean> productBeanList = MoonApplication.getInstance().getAppDatabase().productDao().loadAllUserInfo();
        mProductListLiveData.setValue(productBeanList);
    }
}
