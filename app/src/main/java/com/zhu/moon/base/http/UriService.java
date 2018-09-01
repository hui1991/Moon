package com.zhu.moon.base.http;


import com.zhu.moon.createOrder.entity.ClientInfoModel;
import com.zhu.moon.login.entity.LoginModel;
import com.zhu.moon.createOrder.entity.ProductModel;
import com.zhu.moon.createOrder.entity.ProductSubmitModel;
import com.zhu.moon.main.entity.UserInfoModel;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 * Created by zhuguangjun on 2018/7/5.
 */

public interface UriService {


    /**
     * 登录接口
     * @param userCode
     * @param userPass
     * @return
     */
    @POST("login")
    Call<LoginModel> login(@Query("userCode") String userCode, @Query("userPass") String userPass);


    /**
     * init接口
     * @return
     */
    @POST("init")
    Call<UserInfoModel> init();

    /**
     * 客户列表
     * @param keyword
     * @return
     */
    @POST("svr_SelxsdwGsp")
    Call<ClientInfoModel> clientList(@Query("caozy") String userName,@Query("org_id") String id,@Query("val") String keyword);


    /**
     * 商品列表
     * @param userName
     * @param invoiceType
     * @param keyword
     * @param ddwid
     * @return
     */
    @POST("sppc_list")
    Call<ProductModel> productList(@Query("caozy") String userName, @Query("faptype") String invoiceType, @Query("val") String keyword, @Query("ddwid") String ddwid);


    /**
     * 提交产品
     * @param userName
     * @param djbs
     * @param price
     * @param count
     * @param dspid
     * @param dkfid
     * @param picih
     * @param ddwid
     * @param invoiceType
     * @param type_kp
     * @return
     */
    @POST("svr_SYS_ChK_HsjShul")
    Call<ProductSubmitModel> productSubmit(@Query("caozy") String userName, @Query("djbs") String djbs, @Query("fld_hsj") String price,
                                           @Query("fld_shul") String count, @Query("dspid") String dspid, @Query("dkfid") String dkfid,
                                           @Query("picih") String picih, @Query("ddwid") String ddwid, @Query("is_zzs") String invoiceType, @Query("type_kp") String type_kp);

}
