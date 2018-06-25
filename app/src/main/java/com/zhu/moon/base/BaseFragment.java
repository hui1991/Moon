package com.zhu.moon.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zhuguangjun on 2018/6/11.
 */

public abstract class BaseFragment extends Fragment {
    private Unbinder bind;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        bind = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    /**
     * 获取当前fragment的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();


}
