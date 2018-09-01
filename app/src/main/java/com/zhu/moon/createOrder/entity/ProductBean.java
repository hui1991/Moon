package com.zhu.moon.createOrder.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * 产品信息
 * Created by zhuguangjun on 2018/8/23.
 */

@Entity(tableName = "products" )
public class ProductBean {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String ddwid;
    public String baozhiqi;
    public String kcsl;
    public String danwei;
    public String pihao;
    public String dspname;
    public String shengccj;
    public String zdcbj;
    public String hescbj;
    public String dkfid;
    public String cbj;
    public String dspid;
    public String zhshj;
    public String picih;
    public String sxrq;
    public String dspspgg;
    public String vdmessage;
    public String vdvalue;
    public String dspcd;
    public String jwh;
    public String dkfname;
    public String hsj;
    public String zdckj;

    @Override
    public String toString() {
        return "ProductBean{" +
                "id=" + id +
                ", ddwid='" + ddwid + '\'' +
                ", baozhiqi='" + baozhiqi + '\'' +
                ", kcsl='" + kcsl + '\'' +
                ", danwei='" + danwei + '\'' +
                ", pihao='" + pihao + '\'' +
                ", dspname='" + dspname + '\'' +
                ", shengccj='" + shengccj + '\'' +
                ", zdcbj='" + zdcbj + '\'' +
                ", hescbj='" + hescbj + '\'' +
                ", dkfid='" + dkfid + '\'' +
                ", cbj='" + cbj + '\'' +
                ", dspid='" + dspid + '\'' +
                ", zhshj='" + zhshj + '\'' +
                ", picih='" + picih + '\'' +
                ", sxrq='" + sxrq + '\'' +
                ", dspspgg='" + dspspgg + '\'' +
                ", vdmessage='" + vdmessage + '\'' +
                ", vdvalue='" + vdvalue + '\'' +
                ", dspcd='" + dspcd + '\'' +
                ", jwh='" + jwh + '\'' +
                ", dkfname='" + dkfname + '\'' +
                ", hsj='" + hsj + '\'' +
                ", zdckj='" + zdckj + '\'' +
                '}';
    }
}
