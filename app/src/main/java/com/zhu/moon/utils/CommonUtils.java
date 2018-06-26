package com.zhu.moon.utils;

import android.hardware.Camera;

/**
 * Created by zhuguangjun on 2018/6/19.
 */

public class CommonUtils {
    private static long FIRST_TIME = 0;
    /**
     * 上一个button id
     */
    private static int PRE_BUTTON_ID = -1;


    public static boolean isFastDoubleTwoClick() {
        long currentTime = System.currentTimeMillis();
        long mTime_step = currentTime - FIRST_TIME;
        if (mTime_step > 0 && mTime_step < 1000) {
            return true;
        }
        FIRST_TIME = currentTime;
        return false;
    }

    /**
     * 是否快速点击
     * @param buttonId 触发点击事件按钮id，用来判断是否是同一个按钮的点击事件
     * @return
     */
    public static boolean isFastDoubleTwoClick(int buttonId) {
        long currentTime = System.currentTimeMillis();
        long mTime_step = currentTime - FIRST_TIME;
        if (PRE_BUTTON_ID == buttonId && mTime_step > 0 && mTime_step < 1000) {
            return true;
        }
        FIRST_TIME = currentTime;
        PRE_BUTTON_ID = buttonId;
        return false;
    }

    /**
     * 通过尝试打开相机的方式判断有无拍照权限（在6.0以下使用拥有root权限的管理软件可以管理权限）
     *
     * @return 是否有相机权限.
     */
    public static boolean cameraIsCanUse() {

        boolean isCanUse = true;
        Camera mCamera = null;
        try {
            mCamera = Camera.open();
            Camera.Parameters mParameters = mCamera.getParameters();
            mCamera.setParameters(mParameters);
        } catch (Exception e) {
            isCanUse = false;
        }

        if (mCamera != null) {
            try {
                mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
                return isCanUse;
            }
        }
        return isCanUse;
    }
}
