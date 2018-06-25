package com.zhu.moon.module.main;

import android.support.v7.widget.RecyclerView;

import com.zhu.moon.R;
import com.zhu.moon.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by zhuguangjun on 2018/6/11.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
