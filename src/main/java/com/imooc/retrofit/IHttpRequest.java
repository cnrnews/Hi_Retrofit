package com.imooc.retrofit;

import android.content.Context;

import java.util.Map;

/**
 * @Author lihl
 * @Date 2022/1/7 11:07
 * @Email 1601796593@qq.com
 */
public interface IHttpRequest {

    /**
     * GET 请求
     * @param context
     * @param url
     * @param params
     * @param callBack
     * @param cache
     */
    void get(Context context, String url, Map<String,Object>params,EngineCallback callBack,boolean cache);
    /**
     * POST 请求
     * @param context
     * @param url
     * @param params
     * @param callBack
     * @param cache
     */
    void post(Context context, String url, Map<String,Object>params,EngineCallback callBack,boolean cache);
}
