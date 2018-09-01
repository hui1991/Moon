package com.zhu.moon.utils;

import android.text.TextUtils;

/**
 * Created by zhuguangjun on 2018/8/22.
 */

public class StringUtils {

    public static boolean isEmpty(String string){
        if (string==null || string.equals("") || string.trim().equals("")){
            return true;
        }
        return false;
    }
}
