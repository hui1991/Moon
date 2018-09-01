package com.zhu.moon.createOrder.entity;

import java.util.List;

/**
 * Created by zhuguangjun on 2018/8/26.
 */

public class ProductSubmitModel {
//    	"data": [{
//        "msg": "校验通过",
//                "pass": 2,
//                "title": "校验提示！"
//    }],
//            "success": true

    public String success;

    public List<ProductSubmit> data;

    class ProductSubmit{
        public String msg;
        public String pass;
        public String title;

        @Override
        public String toString() {
            return "ProductSubmit{" +
                    "msg='" + msg + '\'' +
                    ", pass='" + pass + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ProductSubmitModel{" +
                "success='" + success + '\'' +
                ", data=" + data +
                '}';
    }
}
