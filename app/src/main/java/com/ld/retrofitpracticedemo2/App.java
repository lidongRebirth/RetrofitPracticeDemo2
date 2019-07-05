package com.ld.retrofitpracticedemo2;

import android.app.Application;

/**
 * @Author
 * @Time 2019/7/5 12:23
 * @Describe
 * @Modify
 */
public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance(){
        return instance;
    }
}
