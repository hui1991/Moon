package com.zhu.moon.module.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhu.moon.R;
import com.zhu.moon.base.BaseFragment;

import butterknife.BindView;

/**
 * tools fragment
 * Created by zhuguangjun on 2018/6/12.
 */

public class ToolsFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.tools_fragment_view)
    Button view;


    @BindView(R.id.tools_fragment_material_design)
    Button materialDesign;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view.setOnClickListener(this);
        materialDesign.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tools;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tools_fragment_view:
                Toast.makeText(getActivity(),"view",Toast.LENGTH_LONG).show();
                break;
            case R.id.tools_fragment_material_design:
                Toast.makeText(getActivity(),"materialDesign",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
