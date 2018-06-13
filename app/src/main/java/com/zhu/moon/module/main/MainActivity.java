package com.zhu.moon.module.main;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import com.zhu.moon.R;
import com.zhu.moon.base.BaseActivity;
import com.zhu.moon.utils.BottomNavigationViewHelper;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_bottom_navigation)
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


}
