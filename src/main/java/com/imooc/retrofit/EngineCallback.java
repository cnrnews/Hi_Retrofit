package com.imooc.retrofit;

/**
 * @Author lihl
 * @Date 2022/1/7 11:31
 * @Email 1601796593@qq.com
 */
public interface EngineCallback {
    void onSuccess(String result);
    void onFailure(Exception e);
}
