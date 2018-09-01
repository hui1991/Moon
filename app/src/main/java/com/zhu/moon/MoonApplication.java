package com.zhu.moon;

import android.app.Application;
import com.zhu.moon.base.http.APi;
import com.zhu.moon.base.http.cookies.AddCookiesInterceptor;
import com.zhu.moon.base.http.cookies.ReceivedCookiesInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Application
 * Created by zhuguangjun on 2018/7/10.
 */

public class MoonApplication extends Application {

    private Retrofit mRetrofit;

    private OkHttpClient mOkHttpClient;

    private static MoonApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor())
                .addInterceptor(new ReceivedCookiesInterceptor())
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(APi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build();
    }

    public static synchronized MoonApplication getInstance() {
        return instance;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public AppDatabase getAppDatabase(){
        return AppDatabase.getInstance(this);
    }


}
