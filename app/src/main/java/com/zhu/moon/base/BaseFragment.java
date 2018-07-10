package com.zhu.moon.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseFragment
 * Created by zhuguangjun on 2018/6/11.
 */

public abstract class BaseFragment extends Fragment {

    public final String TAG = getClass().getName();

    private Unbinder bind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        View rootView = inflater.inflate(getLayoutId(), container, false);
        bind = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG,"onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
        bind.unbind();
    }

    /**
     * 获取当前fragment的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 展示正常view
     */
    protected void showNormalView(){

    }

    /**
     * 展示错误view
     */
    protected void showErrorView(){

    }
}
