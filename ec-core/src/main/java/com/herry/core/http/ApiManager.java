package com.herry.core.http;

import com.herry.core.constant.AppConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static final String END_POINT = AppConstants.BASE_URL;
    private static final int CONNECT_TIME_OUT = 15;// second

    private OkHttpClient mClient;
    private Retrofit mRetrofit;
    private HttpLoggingInterceptor mInterceptor = new HttpLoggingInterceptor();

    private ApiManager() {}

    private volatile static ApiManager INSTANCE;

    public static ApiManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ApiManager.class) {
                INSTANCE = new ApiManager();
            }
        }
        return INSTANCE;
    }

    // 能够详尽的追踪访问链接的重定向
    // 短时间内的网络访问，它将不执行缓存过来的回应
    // 监测整个网络过程的数据流量
    private Interceptor mNetworkInterceptor = new Interceptor() {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            String mobile_version = android.os.Build.VERSION.RELEASE;
            Request builder = chain.request().newBuilder().
                    addHeader("version", mobile_version).build();
            return chain.proceed(builder);
        }
    };

    public <T> T getService(Class<T> service) {
        if (mClient == null) {
            mClient = new OkHttpClient.Builder()
                    // 设置应用拦截器，可用于设置公共参数，头信息，日志拦截
                    .addInterceptor(mInterceptor)
                    // 错误重联
                    .retryOnConnectionFailure(true)
                    // 配置连接超时
                    .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
//                    // 网络拦截器，可以用于重试或重写
//                    .addNetworkInterceptor(mNetworkInterceptor)
                    .build();
        }

        if (mRetrofit == null) {
            // 初始化Retrofit实例
            mRetrofit = new Retrofit.Builder()
                    // 相当于1.9中的setEndPoint
                    .baseUrl(END_POINT)
                    // 设置OKHttpClient,如果不设置会提供一个默认的
                    .client(mClient)
                    // 设置使用Gson解析,可以添加多种序列化Factory，
                    // 但是GsonConverterFactory必须放在最后,否则会抛出异常
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit.create(service);
    }
}
