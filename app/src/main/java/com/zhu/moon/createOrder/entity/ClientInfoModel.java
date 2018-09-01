package com.zhu.moon.createOrder.entity;

import com.zhu.moon.createOrder.entity.ClientInfo;

import java.util.List;

/**
 * Created by zhuguangjun on 2018/8/24.
 */

public class ClientInfoModel {
    public List<ClientInfo> data;
    public String succcess;

    @Override
    public String toString() {
        return "ClientInfoModel{" +
                "data=" + data +
                ", succcess='" + succcess + '\'' +
                '}';
    }
}
