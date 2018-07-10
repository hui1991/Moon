package com.zhu.moon.module.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zhu.moon.R;
import com.zhu.moon.base.BaseFragment;
import com.zhu.moon.data.bean.ArticleBean;
import com.zhu.moon.data.bean.ArticleModelContent;
import com.zhu.moon.view.ItemOffsetsDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 首页
 * Created by zhuguangjun on 2018/6/11.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private HomeViewModel mViewModel;

    private HomeListAdapter mAdapter;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new HomeListAdapter(getActivity(),new ArrayList<ArticleBean>());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new ItemOffsetsDecoration());
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        Observer<ArticleModelContent> articleListObserver = new Observer<ArticleModelContent>() {
            @Override
            public void onChanged(@Nullable ArticleModelContent articleModelContent) {
                if (articleModelContent==null || articleModelContent.datas==null || articleModelContent.datas.size()==0){
                    return;
                }
                mAdapter.setData(articleModelContent.datas);
            }
        };
        mViewModel.getLiveData().observe(this,articleListObserver);
        mViewModel.requestData();
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void showNormalView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
