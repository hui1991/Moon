package com.zhu.moon.utils;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

/**
 * Created by zhuguangjun on 2018/6/28.
 */

public class IntentUtils {

    /**
     * 返回应用信息页面的intent
     * @param packageName
     * @return
     */
    public static Intent getApplicationInformationIntent(String packageName){
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.fromParts("package", packageName, null));
        return intent;
    }
}
