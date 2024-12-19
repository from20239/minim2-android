package com.example.proyectodsa_android;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitClient {
    private static final String BASE_URL = "http://10.0.2.2:8080/dsaApp/";
    private static RetrofitClient instance;
    private final Retrofit retrofit;

    private RetrofitClient() {
        // 创建自定义的 Gson 实例
        Gson gson = new GsonBuilder()
                .serializeNulls()  // 包括 null 值
                .setLenient()      // 容忍非标准 JSON
                .create();

        // 配置日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 配置 OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)  // 连接超时
                .readTimeout(30, TimeUnit.SECONDS)     // 读取超时
                .writeTimeout(30, TimeUnit.SECONDS)    // 写入超时
                .build();

        // 配置 Retrofit 实例
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)) // 使用自定义 Gson
                .client(client)
                .build();
    }

    // 获取单例 RetrofitClient 实例
    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    // 获取 ApiService 实例
    public ApiService getApi() {
        return retrofit.create(ApiService.class);
    }
}
