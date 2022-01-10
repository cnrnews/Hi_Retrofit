package com.imooc.retrofit;

/**
 * @Author lihl
 * @Date 2022/1/7 11:33
 * @Email 1601796593@qq.com
 */
public class EngineConfig {

    final IHttpRequest engineRequest;
    final Converter converter;

    public EngineConfig(Builder builder) {
        engineRequest = builder.engineRequest;
        converter = builder.converter;
    }

    public static class Builder {
        IHttpRequest engineRequest;
        Converter converter;

        public Builder engineRequest( IHttpRequest engineRequest){
            this.engineRequest = engineRequest;
            return this;
        }
        public Builder converter(Converter converter){
            this.converter = converter;
            return this;
        }
        public EngineConfig build(){
            if (converter == null){
                converter = Converter.DEFAULT_CONVERT;
            }
            return new EngineConfig(this);
        }
    }
}
