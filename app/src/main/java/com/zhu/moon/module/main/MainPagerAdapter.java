package com.zhu.moon.module.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.zhu.moon.base.BaseFragment;
import java.util.ArrayList;

/**
 *
 * Created by zhuguangjun on 2018/6/13.
 */

public class MainPagerAdapter extends FragmentPagerAdapter{

    private ArrayList<BaseFragment> data;

    public MainPagerAdapter(FragmentManager fm,ArrayList<BaseFragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
