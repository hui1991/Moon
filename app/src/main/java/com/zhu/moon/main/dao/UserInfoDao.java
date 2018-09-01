package com.zhu.moon.main.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.zhu.moon.main.entity.UserInfo;
import java.util.List;


/**
 * Created by zhuguangjun on 2018/8/24.
 */

@Dao
public interface UserInfoDao {

     @Query("SELECT * FROM userInfo")
     List<UserInfo> loadAllUserInfo();

     @Insert
     void insert(UserInfo userInfo);

     @Delete()
     void delete(UserInfo userInfo);

}
