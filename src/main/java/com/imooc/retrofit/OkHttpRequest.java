package com.imooc.retrofit;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author lihl
 * @Date 2022/1/7 11:43
 * @Email 1601796593@qq.com
 */
public class OkHttpRequest implements IHttpRequest{


    @Override
    public void get(Context context, String url, Map<String, Object> params, EngineCallback callBack, boolean cache) {

        Request request = new  Request.Builder()
                .url(url)
                .build();

        OkClient.getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callBack.onFailure(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                callBack.onSuccess(response.body().string());
            }
        });

    }

    @Override
    public void post(Context context, String url, Map<String, Object> params, EngineCallback callBack, boolean cache) {

    }
}
