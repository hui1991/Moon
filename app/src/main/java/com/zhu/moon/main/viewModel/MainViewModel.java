package com.zhu.moon.main.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;
import com.zhu.moon.MoonApplication;
import com.zhu.moon.base.http.UriService;
import com.zhu.moon.main.entity.UserInfoModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhuguangjun on 2018/8/23.
 */

public class MainViewModel extends AndroidViewModel {

    public static final String TAG = "MainViewModel";

    private MutableLiveData<UserInfoModel> mUserLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<UserInfoModel> getUserLiveData(){
        if (mUserLiveData==null){
            mUserLiveData = new MutableLiveData<>();
        }
        return mUserLiveData;
    }

    public void requestUserData(){

        UriService uriService = MoonApplication.getInstance().getRetrofit().create(UriService.class);
        Call<UserInfoModel> call = uriService.init();
        call.enqueue(new Callback<UserInfoModel>() {
            @Override
            public void onResponse(Call<UserInfoModel> call, Response<UserInfoModel> response) {
                Log.e(TAG,response.body().toString());
                getUserLiveData().setValue(response.body());
                MoonApplication.getInstance().getAppDatabase().userInfoDao().insert(response.body().user);
            }

            @Override
            public void onFailure(Call<UserInfoModel> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
}
