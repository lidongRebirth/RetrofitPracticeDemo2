package com.ld.retrofitpracticedemo2;


import com.ld.retrofitpracticedemo2.bean.MyCollectionBean;
import com.ld.retrofitpracticedemo2.bean.UserBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * @Author
 * @Time 2019/7/5 14:33
 * @Describe 接口
 * @Modify
 */
public interface Api {

    //登录
    @FormUrlEncoded
    @POST
    Call<UserBean> login(@Url String url, @FieldMap Map<String, String> param);


    //获取收藏列表
    @GET("lg/collect/list/{page}/json")
    Call<MyCollectionBean> getCollecEssay(@Path("page") int page);
}
