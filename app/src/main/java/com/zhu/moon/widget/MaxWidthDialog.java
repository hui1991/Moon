package com.zhu.moon.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by zhuguangjun on 2018/8/26.
 */

public class MaxWidthDialog extends Dialog {

    public MaxWidthDialog(@NonNull Context context) {
        super(context);
        Window window = this.getWindow();
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = ((Activity) context).getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.MATCH_PARENT;

        this.onWindowAttributesChanged(wl);
        // 设置点击外围解散
        this.setCanceledOnTouchOutside(true);
    }
}
