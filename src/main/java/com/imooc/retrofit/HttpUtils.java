package com.imooc.retrofit;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/**
 * @Author lihl
 * @Date 2022/1/7 11:39
 * @Email 1601796593@qq.com
 */
public class HttpUtils {
    private IHttpRequest mHttpRequest;
    private static IHttpRequest mInitHttpRequest;
    private final int TYPE_POST = 0x0011,TYPE_GET = 0x0022;
    private int mType = TYPE_GET;
    private Map<String,Object> mParams;
    private String mUrl;
    private Context mContext;
    public static EngineConfig mConfig;

    public static HttpUtils with(Context context){
        return new HttpUtils(context);
    }
    private HttpUtils(Context context){
        this.mContext = context;
        mHttpRequest = new OkHttpRequest();
        mParams = new HashMap<>();
    }
    public HttpUtils httpRequest(IHttpRequest httpRequest){
        mHttpRequest = httpRequest;
        return this;
    }
    public static void initConfig(EngineConfig config){
        mConfig = config;
        mInitHttpRequest = mConfig.engineRequest;
    }
    public HttpUtils param(String key,Object value){
        mParams.put(key, value);
        return this;
    }
    public HttpUtils url(String url){
        this.mUrl = url;
        return this;
    }
    public HttpUtils get(){
        mType = TYPE_GET;
        return this;
    }
    public <T> void request(){
        request(null);
    }
    public <T> void request(HttpCallBack<T> callBack){
        if (mHttpRequest == null){
            mHttpRequest = mInitHttpRequest;
        }
        if (mHttpRequest == null){
            throw new NullPointerException("HttpRequest 为空，请配置");
        }
        if (TextUtils.isEmpty(mUrl)){
            throw new NullPointerException("请求路径为空");
        }

        boolean tag = mHttpRequest instanceof RetrofitRequest;
        Log.d("TAG",tag+"");

        mHttpRequest.get(mContext,mUrl,mParams,callBack,true);
    }
}
