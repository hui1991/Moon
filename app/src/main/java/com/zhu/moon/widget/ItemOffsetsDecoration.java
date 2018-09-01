package com.zhu.moon.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zhu.moon.utils.UiUtils;

/**
 * 自定义ItemDecoration 设置item边界 类似padding  margin 的效果
 * Created by zhuguangjun on 2018/7/9.
 */

public class ItemOffsetsDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        float topOffsets = 3;
        float bottomOffsets = 3;
        //得到count
        int count = parent.getAdapter().getItemCount();
        //得到当前view的position
        int position = ((RecyclerView.LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
        if (position==0){
            topOffsets = 6;
        }
        if (position==count-1){
            bottomOffsets = 6;
        }
        outRect.set(0, UiUtils.dp2px(parent.getContext(),topOffsets),0, UiUtils.dp2px(parent.getContext(),bottomOffsets));
    }
}
