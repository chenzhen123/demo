package demo.test.cz.http_library.utils;

import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import demo.test.cz.http_library.BuildConfig;
import demo.test.cz.http_library.HttpApplication;
import demo.test.cz.http_library.convertfactory.JavaBeanConvertFactory;
import demo.test.cz.http_library.interceptor.NetWorkInterceptor;
import demo.test.cz.http_library.service.ApiService;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @description:
 * @FileName: HttpUtils.java
 * @author: chenzhen
 * @date: 2018-06-08
 * @E-mail:zhenchen@excar.com.cn
 */

public class HttpUtils {
    private static final String RELASE_URL = "http://ecarx.win:8080";
    private static final String TEST_URL = "http://ecarx.win:8080";
    private static final int TIMEOUT = 30;
    private static final int CACHE_SIZE = 1024 * 1024;
    private static HttpUtils httpUtils;
    private Retrofit retrofit;

    private HttpUtils() {
        Context context = HttpApplication.context;
        File file = new File(context.getExternalCacheDir(), "Http_library_cache");
        Cache cache = new Cache(file, CACHE_SIZE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .cache(cache)
                //添加应用拦截器
               // .addInterceptor(new NetWorkInterceptor())
                //添加网络拦截器
                .addNetworkInterceptor(new NetWorkInterceptor())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.DEBUG == true ? TEST_URL : RELASE_URL)
                .client(okHttpClient)
                .addConverterFactory(JavaBeanConvertFactory.create())
                //配置转换工厂类，默认格式下，retrofit只支持将返回数据格式转换成responsebody格式，配置converter将responsebody转换成需要的格式
                .addConverterFactory(GsonConverterFactory.create())
                //默认情况下，只返回Call<ResponseBody>类型，加入下面的方法将Call转换成想要的类型
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                httpUtils = new HttpUtils();
            }
        }
        return httpUtils;
    }
    public ApiService create(){
        return retrofit.create(ApiService.class);
    }
}
