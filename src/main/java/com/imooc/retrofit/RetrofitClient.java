package com.imooc.retrofit;

import android.content.Context;
import android.util.Log;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * @Author lihl
 * @Date 2022/1/7 11:00
 * @Email 1601796593@qq.com
 *
 * 构建基础 Retrofit
 */
public class RetrofitClient {


    private static ServiceApi mServiceApi;
    static {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor((message)->{
                    Log.e("TAG",message);
                }).setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .client(okHttpClient)
                .build();

        mServiceApi = retrofit.create(ServiceApi.class);

    }

    public static ServiceApi getServiceApi() {
        return mServiceApi;
    }
}