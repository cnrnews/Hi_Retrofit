package com.imooc.retrofit;

/**
 * @Author lihl
 * @Date 2022/1/7 11:18
 * @Email 1601796593@qq.com
 *
 * 自定义 Retrofit 异常
 */
public class RetrofitErrorException extends Exception{
    public RetrofitErrorException(String message) {
        super(message);
    }
}
