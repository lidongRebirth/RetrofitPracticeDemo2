package com.ld.retrofitpracticedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ld.retrofitpracticedemo2.bean.MyCollectionBean;
import com.ld.retrofitpracticedemo2.interceptor.AddCookiesInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author LD
 * @Time
 * @Describe 获取文章列表的活动
 * @Modify
 */
public class EssayActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "EssayActivity_ceshi";

    private Retrofit retrofitCollect;
    private Api getCollectApi;

    private Button btnGetCollectEssay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay);

        init();
        initView();
    }

    private void initView() {

        btnGetCollectEssay = findViewById(R.id.btn_getCollectedEssay);

        btnGetCollectEssay.setOnClickListener(this);
    }


    //待会写
    private void init() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor())
                .build();

        retrofitCollect = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        getCollectApi = retrofitCollect.create(Api.class);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getCollectedEssay:


                getCollectApi.getCollecEssay(0).enqueue(new Callback<MyCollectionBean>() {
                    @Override
                    public void onResponse(Call<MyCollectionBean> call, Response<MyCollectionBean> response) {
                        if (response != null && response.body() != null) {
                            if (response.body().getErrorCode() == 0) {
                                Toast.makeText(getApplicationContext(), "获取文章列表成功", Toast.LENGTH_SHORT).show();
                                Log.i(TAG, "onResponse: 获取文章列表成功");

                                for (int i = 0; i < response.body().getData().getDatas().size(); i++) {
                                    Log.i(TAG, "\nonResponse: 收藏的标题名为：" + response.body().getData().getDatas().get(i).getTitle());
                                }

                            } else {
                                Log.i(TAG, "onResponse: 获取文章列表成功"+response.body().getErrorMsg());
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<MyCollectionBean> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "获取文章列表失败" + t, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            default:
                break;
        }
    }
}
