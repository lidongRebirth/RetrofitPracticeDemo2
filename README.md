# 1. Cookie介绍

我个人理解：Cookie其实就是记录用户的一些信息、状态行为等。有这样一种场景，用户在登录成功后，服务端会返回Cookie,里面包含用户的登陆状态信息等，这样用户在访问自己的收藏列表时，加上这个Cookie，那么就可直接获取到文章列表，如果没有Cookie，那服务端怎么知道你是要获取哪个用户的文章列表呢。

在浏览器上，返回的Cookie会保存在浏览器中，在下次访问时会自动加上该段Cookie，而Android端，需要我们自己来保存服务端返回的Cookie，并在下次访问的时候自己添加上。至于如何保存(Cookie持久化)，方法很多，可以用数据库、文件、SharedPreferences、也可以使用Webview的CookieManager。

大家可以看这篇文章[Cookie介绍及在Android中的使用总结超详细，看这一篇就够了](https://blog.csdn.net/Kelaker/article/details/82751287)

Cookie访问时添加上其实就是使用header来添加头部信息，至于怎么添加[上篇文章](https://juejin.im/post/5d15d1a66fb9a07ece67e3af)已经介绍，但显然不能这样，总不能在每个需要Cookie的api上都写上头部信息或动态添加，那这样也太繁琐了，接下来我们将通过拦截器来动态添加。



# 2. 接口介绍 

本篇文章我将采用[Wandroid网站](https://www.wanandroid.com/blog/show/2)中的**登陆接口**和**收藏文章列表接口**

**登陆**

```java
https://www.wanandroid.com/user/login

方法：POST
参数：
	username，password
```

登录后会在cookie中返回账号密码，只要在客户端做cookie持久化存储即可自动登录验证。 

**收藏文章列表**

```java
https://www.wanandroid.com/lg/collect/list/0/json

方法：GET
参数： 页码：拼接在链接中，从0开始。
```

在网站上登录后，可以直接访问<https://www.wanandroid.com/lg/collect/list/0/json>查看自己收藏的文章。



**大家可以现在该[网站](https://www.wanandroid.com/index)上注册个账号并且收藏几篇文章，供下面使用。**



# 3. Retrofit和OkHttp的关系

为什么要说OkHttp呢，因为Retrofit底层就是使用OkHttp实现的，只是对其进行了封装，我们可以通过Okhttp中的Interceptor拦截器来设置请求头，然后通过retrofit.client(okhttpclient)对请求头进行修改，这样就省去了我们手动添加请求头的步骤。



# 4. 拦截器创建 

**这里我们创建两个拦截器，一个用于登录时接收Cookie保存在本地，另一个拦截器用于访问时在请求里添加Cookie。**

## 4.1 拦截Cookie保存到本地的拦截器

### 4.1.1 创建拦截器继承自Interceptor

```java
public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {    
        //拦截的cookie保存在originalResponse中
        Response originalResponse = chain.proceed(chain.request());
        //打印cookie信息
        Log.i(TAG, "intercept: "+ originalResponse.headers("Set-Cookie").toString());
        ...
        return originalResponse;
    }
}
```

通过`chain.proceed(chain.request())`获取到的response内保存了拦截到的cookie信息。

通过`Log.i(TAG, "intercept: "+ originalResponse.headers("Set-Cookie").toString());`打印头部信息日志


![](https://user-gold-cdn.xitu.io/2019/7/5/16bc1a9f089ff2fd?w=1233&h=183&f=png&s=50254)

我们可以看到网络请求返回的cookie信息，我们要做的就是将这个cookie保存在本地。

### 4.1.2 将cookie信息保存在本地 

这里我将采用sharepreference的方式来存储Cookie

* **先判断Set-Cookie的头部不为空**

  ```java
  if (!originalResponse.headers("Set-Cookie").isEmpty()) {
      ...
  }
  ```

* **通过循环将Cookie信息放入到HashSet集合中**

  ```java
  HashSet<String> cookies = new HashSet<>();
  for(String header: originalResponse.headers("Set-Cookie"))
  {
  	cookies.add(header);
  }
  ```

* **通过SharePreference将Cookie信息保存在本地**

  ```java
  //保存的sharepreference文件名为cookieData
  SharedPreferences sharedPreferences = context.getSharedPreferences("cookieData", Context.MODE_PRIVATE);								
  SharedPreferences.Editor editor = sharedPreferences.edit();
  editor.putStringSet("cookie", cookies);
  editor.commit();
  ```

### 4.1.3 完整代码

```java
public class ReceivedCookiesInterceptor implements Interceptor {
    
    public ReceivedCookiesInterceptor() {
        super();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {        
        Response originalResponse = chain.proceed(chain.request());
        //这里获取请求返回的cookie
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
          
            HashSet<String> cookies = new HashSet<>();
            for(String header: originalResponse.headers("Set-Cookie"))
            {
                LogUtil.i(TAG, "拦截的cookie是："+header);
                cookies.add(header);
            }
           //保存的sharepreference文件名为cookieData
            SharedPreferences sharedPreferences = App.getInstance().getSharedPreferences("cookieData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putStringSet("cookie", cookies);

            editor.commit();
        }

        return originalResponse;
    }
}
```

## 4.2 添加本地Cookie进行网络访问的拦截器 

### 4.2.1 创建拦截器继承自Interceptor

```java
public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {       
        ......      
    }
}
```

### 4.2.2 从Sharepreference中读取Cookie并添加到头部

```java
Request.Builder builder = chain.request().newBuilder();

HashSet<String> perferences = (HashSet) App.getInstance().getSharedPreferences("cookieData", Context.MODE_PRIVATE).getStringSet("cookie", null);
if (perferences != null) {
    for (String cookie : perferences) {
        builder.addHeader("Cookie", cookie);
    }
}
return chain.proceed(builder.build());
```

### 4.2.3 完整代码

```java
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
```



# 5. 应用

## 5.1 登录拦截Cookie

### 5.1.1 创建OkhttpClient对象

```java
OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ReceivedCookiesInterceptor())
                .build();
```

### 5.1.2 创建Retrofit对象，并添加此OkhttpClient对象

```java
private Retrofit retrofitLogin;
retrofitLogin = new Retrofit.Builder()
                .baseUrl("https://a/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
```

### 5.1.3 创建接口对象进行访问

```java
public interface Api {    
    //登录接口
    @FormUrlEncoded
    @POST
    Call<UserBean> login(@Url String url, @FieldMap Map<String, String> param);
}
```

```java
private Api loginApi;
loginApi = retrofitLogin.create(Api.class);
```

```java
Map<String, String> param = new HashMap<>();
param.put("username", etUsername.getText().toString());
param.put("password", etPwd.getText().toString());

loginApi.login(loginUrl, param).enqueue(new Callback<UserBean>() {
    @Override
    public void onResponse(Call<UserBean> call, Response<UserBean> response) {
        if (response != null && response.body() != null) {
            if (response.body().getErrorCode() == 0) {
                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();} 
            else {
                Toast.makeText(getApplicationContext(), "登录失败" + response.body().getErrorCode() + response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
            }            
        }
    }
    @Override
    public void onFailure(Call<UserBean> call, Throwable t) {
        Toast.makeText(getApplicationContext(), "登录失败"+t, Toast.LENGTH_SHORT).show();
    }
});
} 
else {
    Toast.makeText(this, "请输入完整的用户信息", Toast.LENGTH_SHORT).show();
}
```

## 5.2 获取收藏列表附加本地Cookie

### 5.2.1 创建OkhttpClient对象

```java
OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor())
                .build();
```

### 5.2.2 创建Retrofit对象，并添加此OkhttpClient对象

```java
retrofitCollect = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();        
```

### 5.2.3 创建接口对象进行访问

```java
public interface Api {
    //获取收藏列表
    @GET("lg/collect/list/{page}/json")
    Call<MyCollectionBean> getCollecEssay(@Path("page") int page);
}
```

```java
private Retrofit retrofitCollect;
private Api getCollectApi;
getCollectApi = retrofitCollect.create(Api.class);
```

```java
getCollectApi.getCollecEssay(0).enqueue(new Callback<MyCollectionBean>() {
    @Override
    public void onResponse(Call<MyCollectionBean> call, Response<MyCollectionBean> response) {
        if (response != null && response.body() != null) {
            if (response.body().getErrorCode() == 0) {
                Log.i(TAG, "onResponse: 获取文章列表成功");
                for (int i = 0; i < response.body().getData().getDatas().size(); i++) {
                    Log.i(TAG, "\n 收藏的标题名为：" + response.body().getData().getDatas().get(i).getTitle());
                }                
            } else {
                 Log.i(TAG, "onResponse: 获取文章列表失败"+response.body().getErrorMsg());
            }
        }
    }
    @Override
    public void onFailure(Call<MyCollectionBean> call, Throwable t) {
         Log.i(TAG, "onResponse: 获取文章列表失败"+t);
    }
});
```



# 6. 总结

以上就是全部内容，具体代码见[Github](https://github.com/myfittinglife/RetrofitPracticeDemo2)。

其实我们使用拦截器的目的就是为了将Cookie信息拦截保存到本地和通过拦截器将Cookie添加到头部信息里，是为了简化我们手动去添加头部信息这一步。

以上就是全部内容，如果有错误的地方还望指出，对你有帮助的话麻烦看官给个start呗。关于Retrofit的图片上传文章还在编辑中，至于怎么用云服务器给大家写个图片上传接口，还在想怎么搞，后台小白一枚，会的大佬麻烦指导指导我。



# 7. 参考文章

[Retrofit使用OkHttp保存和添加Cookie](https://www.jianshu.com/p/1caa92bf8079)

[Android的Cookie的接收和发送](https://blog.csdn.net/qq_33200967/article/details/71789740)

[Cookie介绍及在Android中的使用总结超详细，看这一篇就够了](https://blog.csdn.net/Kelaker/article/details/82751287)





