package com.imooc.retrofit;

/**
 * @Author lihl
 * @Date 2022/1/7 10:52
 * @Email 1601796593@qq.com
 */
public class Result<T> extends BaseResult {
    T data;

    /**
     * 请求是否成功
     * @return
     */
    boolean isOk(){
        return errorCode == 0;
    }
}
