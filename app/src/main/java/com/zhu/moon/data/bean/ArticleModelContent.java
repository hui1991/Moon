package com.zhu.moon.data.bean;

import java.util.List;

/**
 * Created by zhuguangjun on 2018/7/6.
 */

public class ArticleModelContent {
    public String curPage;
    public String offset;
    public boolean over;
    public String pageCount;
    public String size;
    public String total;
    public List<ArticleBean> datas;

    @Override
    public String toString() {
        return "ArticleModelContent{" +
                "curPage='" + curPage + '\'' +
                ", offset='" + offset + '\'' +
                ", over=" + over +
                ", pageCount='" + pageCount + '\'' +
                ", size='" + size + '\'' +
                ", total='" + total + '\'' +
                ", datas=" + datas +
                '}';
    }
}
