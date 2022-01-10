# Hi_Retrofit
Retrofit+OkHttp 网络引擎封装

### 使用步骤
#### 1. 配置
在应用BaseApplication进行网络库的配置
```
@Override
public void onCreate() {
    super.onCreate();
    // 上层配置
    EngineConfig config = new EngineConfig.Builder()
                .engineRequest(new RetrofitRequest()) // 网络引擎，可以使用基于Retrofit 的RetrofitRequest, 也可以使用基于 OkHttpClient 的 OkHttpRequest
                .converter(new GsonConvert()) // 添加解析工厂，默认是基于 json 格式数据解析
                // 添加请求参数
                .build();
   HttpUtils.initConfig(config);
}
```
#### 2.使用
```
HttpUtils.with(this)
                .url("wxarticle/chapters/json")// 请求接口
                .get()
                .request(new HttpCallBack<String>() {
                    @Override
                    public void onFailure(Exception e) {
                        Log.d("TAG","onFailure"+e.getMessage());
                    }
                    @Override
                    public void onSuccess(String result) {
                        Log.d("TAG","onSuccess"+result);
                    }
                });
```
