package com.imooc.retrofit;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * @Author lihl
 * @Date 2022/1/7 11:53
 * @Email 1601796593@qq.com
 *
 * Gson 解析
 */
public class GsonConvert implements Converter {
    @Override
    public <T> T convert(String value, Class<T> type) {
        return new Gson().fromJson(value,type);
    }
}
