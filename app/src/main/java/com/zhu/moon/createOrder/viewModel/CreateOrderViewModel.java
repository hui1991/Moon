package com.zhu.moon.createOrder.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;
import com.zhu.moon.MoonApplication;
import com.zhu.moon.base.http.UriService;
import com.zhu.moon.createOrder.entity.ProductBean;
import com.zhu.moon.createOrder.entity.ClientInfoModel;
import com.zhu.moon.createOrder.entity.ProductModel;
import com.zhu.moon.createOrder.entity.ProductSubmitModel;
import com.zhu.moon.main.entity.UserInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 创建订单页面viewModel
 * Created by zhuguangjun on 2018/8/24.
 */

public class CreateOrderViewModel extends AndroidViewModel {

    public static final String TAG = "CreateOrderViewModel";

    private MutableLiveData<ClientInfoModel> mClientLiveData;

    private MutableLiveData<ProductModel> mProductLiveData;

    private MutableLiveData<ProductSubmitModel> mProductSubmitLiveData;

    private UserInfo mUserInfo;

    public CreateOrderViewModel(@NonNull Application application) {
        super(application);
        mUserInfo = MoonApplication.getInstance().getAppDatabase().getUserInfo();
    }

    public MutableLiveData<ClientInfoModel> getClientLiveData(){
        if (mClientLiveData ==null){
            mClientLiveData = new MutableLiveData<>();
        }
        return mClientLiveData;
    }


    public MutableLiveData<ProductModel> getProductLiveData(){
        if (mProductLiveData ==null){
            mProductLiveData = new MutableLiveData<>();
        }
        return mProductLiveData;
    }

    public MutableLiveData<ProductSubmitModel> getProductSubmitLiveData(){
        if (mProductSubmitLiveData ==null){
            mProductSubmitLiveData = new MutableLiveData<>();
        }
        return mProductSubmitLiveData;
    }

    public void requestClientInfoData(String keyword){
        UriService uriService = MoonApplication.getInstance().getRetrofit().create(com.zhu.moon.base.http.UriService.class);
        Call<ClientInfoModel> call = uriService.clientList(mUserInfo.getUser_name(),mUserInfo.getOrg_id(),keyword);
        call.enqueue(new Callback<ClientInfoModel>() {
            @Override
            public void onResponse(Call<ClientInfoModel> call, Response<ClientInfoModel> response) {
                Log.e(TAG,response.body().toString());
                getClientLiveData().setValue(response.body());
            }

            @Override
            public void onFailure(Call<ClientInfoModel> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }


    public void requestProductData(String keyword,String invoiceType){
        UriService uriService = MoonApplication.getInstance().getRetrofit().create(UriService.class);
        Call<ProductModel> call = uriService.productList(mUserInfo.getUser_name(),invoiceType,keyword,"");
        call.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                getProductLiveData().setValue(response.body());
                Log.e(TAG,response.body().toString());
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }

    public void requestProductSubmitData(String invoiceType, ProductBean productBean,String price,String count,String clientId){
        UriService uriService = MoonApplication.getInstance().getRetrofit().create(UriService.class);
        Call<ProductSubmitModel> call = uriService.productSubmit(mUserInfo.getUser_name(),"djbs",price,count,productBean.dspid,productBean.dkfid,productBean.picih,clientId,invoiceType,"");
        call.enqueue(new Callback<ProductSubmitModel>() {
            @Override
            public void onResponse(Call<ProductSubmitModel> call, Response<ProductSubmitModel> response) {
                getProductSubmitLiveData().setValue(response.body());
                Log.e(TAG,response.body().toString());
            }

            @Override
            public void onFailure(Call<ProductSubmitModel> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
}
