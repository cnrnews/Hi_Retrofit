package com.imooc.retrofit;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @Author lihl
 * @Date 2022/1/7 10:50
 * @Email 1601796593@qq.com
 *
 * 封装通用请求接口
 */
public interface ServiceApi {

    /**
     * POST
     * @param url 请求地址
     * @param params 请求参数
     * @return
     */
    @POST()
    Call<ResponseBody> postMethod(@Url String url, @FieldMap Map<String,Object> params);

    /**GET
     * 用户登录
     * @param url 请求地址
     * @param params 请求参数
     * @return
     */
    @GET()
    Call<ResponseBody> getMethod(@Url String url, @QueryMap Map<String,Object> params);
}
