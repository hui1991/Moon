package com.zhu.moon.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhu.moon.utils.UIUtils;

/**
 * 自定义ItemDecoration 设置item边界 类似padding  margin 的效果
 * Created by zhuguangjun on 2018/7/9.
 */

public class ItemOffsetsDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        float topOffsets = 5;
        float bottomOffsets = 5;
        //得到count
        int count = parent.getAdapter().getItemCount();
        //得到当前view的position
        int position = ((RecyclerView.LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
        if (position==0){
            topOffsets = 10;
        }
        if (position==count-1){
            bottomOffsets = 10;
        }
        outRect.set(UIUtils.dp2px(parent.getContext(),5),UIUtils.dp2px(parent.getContext(),topOffsets),UIUtils.dp2px(parent.getContext(),5),UIUtils.dp2px(parent.getContext(),bottomOffsets));
    }
}
