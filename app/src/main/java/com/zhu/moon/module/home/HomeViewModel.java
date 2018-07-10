package com.zhu.moon.module.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;
import com.zhu.moon.data.bean.ArticleModelContent;
import com.zhu.moon.data.model.ArticleModel;
import com.zhu.moon.net.APi;
import com.zhu.moon.net.UriService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 首页viewModel
 * Created by zhuguangjun on 2018/7/6.
 */

public class HomeViewModel extends AndroidViewModel{

    public static final String TAG = "HomeViewModel";

    private MutableLiveData<ArticleModelContent> mLiveData;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<ArticleModelContent> getLiveData(){
        if (mLiveData==null){
            mLiveData = new MutableLiveData<>();
        }
        return mLiveData;
    }

    public void requestData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UriService uriService = retrofit.create(UriService.class);
        Call<ArticleModel> call = uriService.getHomeList(0);
        call.enqueue(new Callback<ArticleModel>() {
            @Override
            public void onResponse(Call<ArticleModel> call, Response<ArticleModel> response) {
                Log.e(TAG,response.body().toString());
                getLiveData().setValue(response.body().data);
            }

            @Override
            public void onFailure(Call<ArticleModel> call, Throwable t) {

            }
        });
    }
}
