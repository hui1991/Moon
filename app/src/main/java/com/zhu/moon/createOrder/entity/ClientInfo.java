package com.zhu.moon.createOrder.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * 客户信息实体类
 * Created by zhuguangjun on 2018/8/24.
 */

@Entity(tableName = "clientInfo")
public class ClientInfo {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String ddwid;
    public String shkfkfs;
    public String DDW00000408;
    public String vdmessage;
    public String ddwname;
    public String addressps;
    public String lxr;
    public String yingshye;
    public String kehulb;
    public String yushk;
    public String zjm;

    @Override
    public String toString() {
        return "ClientInfo{" +
                "shkfkfs='" + shkfkfs + '\'' +
                ", DDW00000408='" + DDW00000408 + '\'' +
                ", vdmessage='" + vdmessage + '\'' +
                ", ddwname='" + ddwname + '\'' +
                ", addressps='" + addressps + '\'' +
                ", lxr='" + lxr + '\'' +
                ", yingshye='" + yingshye + '\'' +
                ", kehulb='" + kehulb + '\'' +
                ", yushk='" + yushk + '\'' +
                ", zjm='" + zjm + '\'' +
                '}';
    }
}
