package com.zhu.moon.createOrder.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.zhu.moon.createOrder.entity.ClientInfo;
import java.util.List;

/**
 * Created by zhuguangjun on 2018/8/24.
 */

@Dao
public interface ClientInfoDao {

    @Query("SELECT * FROM clientInfo")
    List<ClientInfo> loadAllclientInfo();

    @Insert
    void insert(ClientInfo clientInfo);


    @Delete()
    void delete(ClientInfo clientInfo);
}
