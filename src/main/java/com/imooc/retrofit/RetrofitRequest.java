package com.imooc.retrofit;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author lihl
 * @Date 2022/1/7 11:09
 * @Email 1601796593@qq.com
 *
 * 构建 Retrofit 请求
 */
public class RetrofitRequest implements IHttpRequest{
    @Override
    public void get(Context context, String url, Map<String, Object> params, EngineCallback callBack, boolean cache) {

        Log.d("TAG","RetrofitRequest GET");


        RetrofitClient.getServiceApi()
                .getMethod(url, params)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        Log.d("TAG","onResponse");
                        ResponseBody body = response.body();
                        if (body == null){
                            body = response.errorBody();
                        }
                        try{
                            callBack.onSuccess(body.string());
                        }catch (Exception e){
                            callBack.onFailure(e);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        Log.d("TAG","onFailure");

                        callBack.onFailure(new RetrofitErrorException(t.getMessage()));
                    }
                });
    }

    @Override
    public void post(Context context, String url, Map<String,Object>params,EngineCallback callBack,boolean cache) {

        RetrofitClient.getServiceApi()
                .postMethod(url, params)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        ResponseBody body = response.body();
                        if (body == null){
                            body = response.errorBody();
                        }

                        try{
                            callBack.onSuccess(body.string());
                        }catch (Exception e){
                            callBack.onFailure(e);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        callBack.onFailure(new RetrofitErrorException(t.getMessage()));
                    }
                });
    }


}

