package com.zhu.moon.module.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import com.zhu.moon.R;
import com.zhu.moon.base.BaseActivity;
import com.zhu.moon.base.BaseFragment;
import com.zhu.moon.module.home.HomeFragment;
import com.zhu.moon.utils.BottomNavigationViewHelper;
import com.zhu.moon.view.NoScrollViewPager;
import java.util.ArrayList;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.main_bottom_navigation)
    BottomNavigationView mBottomNavigationView;

    @BindView(R.id.main_content)
    NoScrollViewPager mViewpager;

    private ArrayList<BaseFragment> mFragments;

    private MainPagerAdapter mMainPagerAdapter;

    private HomeFragment mHomeFragment;

    private ArticleFragment mArticleFragment;

    private ToolsFragment mToolsFragment;

    private MineFragment mMineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mHomeFragment = new HomeFragment();
        mArticleFragment = new ArticleFragment();
        mToolsFragment = new ToolsFragment();
        mMineFragment = new MineFragment();
        mFragments = new ArrayList<>(4);
        mFragments.add(mHomeFragment);
        mFragments.add(mArticleFragment);
        mFragments.add(mToolsFragment);
        mFragments.add(mMineFragment);
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewpager.setAdapter(mMainPagerAdapter);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_bottom_navigation_home:
                mViewpager.setCurrentItem(0);
                break;
            case R.id.main_bottom_navigation_article:
                mViewpager.setCurrentItem(1);
                break;
            case R.id.main_bottom_navigation_tools:
                mViewpager.setCurrentItem(2);
                break;
            case R.id.main_bottom_navigation_mine:
                mViewpager.setCurrentItem(3);
                break;
        }
        return true;
    }
}
