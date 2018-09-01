package com.zhu.moon;

import android.os.Bundle;
import android.os.Handler;

import com.zhu.moon.R;
import com.zhu.moon.base.ui.BaseActivity;
import com.zhu.moon.login.ui.LoginActivity;

public class LaunchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    startActivity(LoginActivity.class);
                    finish();

            }
        },2000);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.launch_activity;
    }
}
