package com.ld.retrofitpracticedemo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ld.retrofitpracticedemo2.bean.UserBean;
import com.ld.retrofitpracticedemo2.interceptor.ReceivedCookiesInterceptor;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author LD
 * @Time 2019.7.5
 * @Describe 拦截器的使用
 * @Modify
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity_ceshi";

    private EditText etUsername, etPwd;
    private Button btnLogin;


    private Retrofit retrofitLogin;
    private Api loginApi;


    //登录地址
    private String loginUrl = "https://www.wanandroid.com/user/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initView();

    }

    private void init() {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ReceivedCookiesInterceptor())
                .build();

        retrofitLogin = new Retrofit.Builder()
                .baseUrl("https://a/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        loginApi = retrofitLogin.create(Api.class);
    }



    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                if (!TextUtils.isEmpty(etUsername.getText()) && !TextUtils.isEmpty(etPwd.getText())) {
                    Map<String, String> param = new HashMap<>();
                    param.put("username", etUsername.getText().toString());
                    param.put("password", etPwd.getText().toString());
                    Log.i(TAG, "onClick: 此时的账号为：" + etUsername.getText().toString() + "密码：" + etPwd.getText().toString());
                    loginApi.login(loginUrl, param).enqueue(new Callback<UserBean>() {
                        @Override
                        public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                            if (response != null && response.body() != null) {
                                if (response.body().getErrorCode() == 0) {
                                    Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(MainActivity.this,EssayActivity.class));
                                } else {
                                    Toast.makeText(getApplicationContext(), "登录失败" + response.body().getErrorCode() + response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        @Override
                        public void onFailure(Call<UserBean> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "登录失败"+t, Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(this, "请输入完整的用户信息", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }
    }
}
