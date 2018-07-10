package com.zhu.moon.data.model;

import com.zhu.moon.data.bean.ArticleModelContent;

/**
 * 首页文章列表model
 * Created by zhuguangjun on 2018/7/6.
 */

public class ArticleModel extends BaseDataModel{
    public ArticleModelContent data;

    @Override
    public String toString() {
        return "ArticleModel{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
