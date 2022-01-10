package com.imooc.retrofit;

import java.io.IOException;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * @Author lihl
 * @Date 2022/1/7 11:30
 * @Email 1601796593@qq.com
 */
public interface Converter{

    // 默认转换器
    Converter DEFAULT_CONVERT = new Converter() {
        @Override
        public <T> T convert(String value, Class<T> type){
            return (T) value;
        }
    };

    <T> T convert(String value,Class<T> type);
}
