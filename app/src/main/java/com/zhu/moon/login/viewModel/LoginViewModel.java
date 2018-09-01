package com.zhu.moon.login.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;
import com.zhu.moon.MoonApplication;
import com.zhu.moon.base.http.UriService;
import com.zhu.moon.login.entity.LoginModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 登录界面viewModel
 * Created by zhuguangjun on 2018/8/22.
 */

public class LoginViewModel extends AndroidViewModel {

    public static final String TAG = "LoginViewModel";

    private MutableLiveData<LoginModel> mLoginLiveData;



    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<LoginModel> getLoginLiveData(){
        if (mLoginLiveData==null){
            mLoginLiveData = new MutableLiveData<>();
        }
        return mLoginLiveData;
    }


    public void requestLoginData(String userCode,String userPass){
        UriService uriService = MoonApplication.getInstance().getRetrofit().create(UriService.class);
        Call<LoginModel> call = uriService.login(userCode,userPass);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                Log.e(TAG,response.body().toString());
                getLoginLiveData().setValue(response.body());
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
}
