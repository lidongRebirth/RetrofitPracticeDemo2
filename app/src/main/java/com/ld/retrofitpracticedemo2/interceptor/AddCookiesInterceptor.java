package com.ld.retrofitpracticedemo2.interceptor;

import android.content.Context;

import com.ld.retrofitpracticedemo2.App;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author LD
 * @Time 2019/7/5 15:41
 * @Describe 访问时自动加上此拦截器
 * @Modify
 */
public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> perferences = (HashSet) App.getInstance().getSharedPreferences("cookieData", Context.MODE_PRIVATE).getStringSet("cookie", null);
        if (perferences != null) {
            for (String cookie : perferences) {
                builder.addHeader("Cookie", cookie);
            }
        }
        return chain.proceed(builder.build());
    }
}
