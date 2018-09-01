package com.zhu.moon.main.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * 用户信息
 * Created by zhuguangjun on 2018/8/23.
 */

@Entity(tableName = "userInfo")
public class UserInfo {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String user_code;
    private String org_id;
    private String user_name;
    private String user_ddwid;
    private String user_addressps;
    private String org_name;
    private String org_code;
    private String user_ddwname;
    private String user_ddwcode;

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_ddwid(String user_ddwid) {
        this.user_ddwid = user_ddwid;
    }

    public void setUser_addressps(String user_addressps) {
        this.user_addressps = user_addressps;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public void setUser_ddwname(String user_ddwname) {
        this.user_ddwname = user_ddwname;
    }

    public void setUser_ddwcode(String user_ddwcode) {
        this.user_ddwcode = user_ddwcode;
    }

    public String getUser_code() {
        return user_code;
    }

    public String getOrg_id() {
        return org_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_ddwid() {
        return user_ddwid;
    }

    public String getUser_addressps() {
        return user_addressps;
    }

    public String getOrg_name() {
        return org_name;
    }

    public String getOrg_code() {
        return org_code;
    }

    public String getUser_ddwname() {
        return user_ddwname;
    }

    public String getUser_ddwcode() {
        return user_ddwcode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public UserInfo(String user_code, String org_id, String user_name, String user_ddwid, String user_addressps, String org_name, String org_code, String user_ddwname, String user_ddwcode) {
        this.user_code = user_code;
        this.org_id = org_id;
        this.user_name = user_name;
        this.user_ddwid = user_ddwid;
        this.user_addressps = user_addressps;
        this.org_name = org_name;
        this.org_code = org_code;
        this.user_ddwname = user_ddwname;
        this.user_ddwcode = user_ddwcode;
    }
}
