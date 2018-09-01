package com.zhu.moon.main.entity;

import com.zhu.moon.main.entity.UserInfo;
import java.util.List;

/**
 * Created by zhuguangjun on 2018/8/23.
 */

public class UserInfoModel {
    public String success;
    public UserInfo user;
    public List shkfs;

    @Override
    public String toString() {
        return "UserInfoModel{" +
                "success='" + success + '\'' +
                ", user=" + user +
                ", shkfs=" + shkfs +
                '}';
    }
}
