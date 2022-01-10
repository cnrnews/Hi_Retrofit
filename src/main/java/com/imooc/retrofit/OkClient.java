package com.imooc.retrofit;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * @Author lihl
 * @Date 2022/1/7 12:20
 * @Email 1601796593@qq.com
 */
public class OkClient {

    private static OkHttpClient okHttpClient;
    static {
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor((message)->{
                    Log.e("TAG",message);
                }).setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
