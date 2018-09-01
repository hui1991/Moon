package com.zhu.moon.createOrder.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.zhu.moon.createOrder.entity.ProductBean;
import java.util.List;

/**
 * Created by zhuguangjun on 2018/8/24.
 */

@Dao
public interface ProductDao {

    @Query("SELECT * FROM products")
    List<ProductBean> loadAllUserInfo();

    @Insert
    void insert(ProductBean productBean);

    @Insert
    void insertAll(List<ProductBean> productBeanList);



}
