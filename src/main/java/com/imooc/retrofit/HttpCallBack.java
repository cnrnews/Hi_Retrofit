package com.imooc.retrofit;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author lihl
 * @Date 2022/1/7 11:05
 * @Email 1601796593@qq.com
 */
public abstract class HttpCallBack<T> implements EngineCallback {
    @Override
    public void onSuccess(String result) {
        Converter converter = HttpUtils.mConfig.converter;
        Class<?> type = analysisClazzInfo(this);
        T resultT = (T) converter.convert(result, type);
        onSuccess(resultT);
    }
    /**
     * 请求成功过
     * @param result
     */
    public abstract void onSuccess(T result);

    /**
     * 解析一个类上面的class信息
     * @param object
     * @return
     */
    public static Class<?> analysisClazzInfo(Object object){
        Type genericSuperclass = object.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        return (Class<?>) actualTypeArguments[0];
    }
}
