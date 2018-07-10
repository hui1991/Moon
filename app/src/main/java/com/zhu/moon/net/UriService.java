package com.zhu.moon.net;

import com.zhu.moon.data.model.ArticleModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 * Created by zhuguangjun on 2018/7/5.
 */

public interface UriService {

    /**
     * 获取首页文章列表
     * @param page 页数
     * @return
     */
    @GET("article/list/{page}/json")
    Call<ArticleModel> getHomeList(@Path("page") int page);
}
