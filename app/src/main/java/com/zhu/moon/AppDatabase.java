package com.zhu.moon;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.zhu.moon.createOrder.dao.ClientInfoDao;
import com.zhu.moon.createOrder.dao.ProductDao;
import com.zhu.moon.main.dao.UserInfoDao;
import com.zhu.moon.createOrder.entity.ClientInfo;
import com.zhu.moon.createOrder.entity.ProductBean;
import com.zhu.moon.main.entity.UserInfo;
import java.util.List;

/**
 * Created by zhuguangjun on 2018/8/24.
 */

@Database(entities = {UserInfo.class,ClientInfo.class, ProductBean.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "TSM";

    public static AppDatabase instance;


    public abstract UserInfoDao userInfoDao();

    public abstract ClientInfoDao clientInfoDao();

    public abstract ProductDao productDao();

    public static AppDatabase getInstance(Context context){
        if (instance==null){
            synchronized (AppDatabase.class){
                if (instance==null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }


    public UserInfo getUserInfo(){
        List<UserInfo> userInfos = userInfoDao().loadAllUserInfo();
        if (userInfos!=null&&userInfos.size()!=0){
            return userInfos.get(0);
        }
        return null;
    }

    public ClientInfo getClientInfo(){
        List<ClientInfo> clientInfos = clientInfoDao().loadAllclientInfo();
        if (clientInfos!=null&&clientInfos.size()!=0){
            return clientInfos.get(0);
        }
        return null;
    }

}
