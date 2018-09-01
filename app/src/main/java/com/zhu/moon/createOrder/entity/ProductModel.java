package com.zhu.moon.createOrder.entity;

import com.zhu.moon.createOrder.entity.ProductBean;

import java.util.List;

/**
 * Created by zhuguangjun on 2018/8/26.
 */

public class ProductModel {

    public String success;

    public List<ProductBean> data;

    @Override
    public String toString() {
        return "ProductModel{" +
                "success='" + success + '\'' +
                ", data=" + data +
                '}';
    }
}
