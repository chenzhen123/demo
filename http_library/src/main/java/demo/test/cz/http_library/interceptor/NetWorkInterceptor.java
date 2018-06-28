package demo.test.cz.http_library.interceptor;

import java.io.IOException;

import demo.test.cz.http_library.utils.ConnectUtil;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @description:网络拦截器 主要用于实现查看请求信息，返回信息，如请求头信息，参数信息等，只观察在网络上的传输的数据，如果网络短路而返回缓存响应时，则不会被调用
 * @FileName: NetWorkInterceptor.java
 * @author: chenzhen
 * @date: 2018-06-08
 * @E-mail:zhenchen@excar.com.cn
 */

public class NetWorkInterceptor implements Interceptor {
    private static final String TAG = NetWorkInterceptor.class.getSimpleName();
    public static final String CacheTime = "Cache-Time";

    /**
     * 实现有无网络都要进行缓存
     *
     * @param chain
     * @return
     * @throws IOException
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        //http做缓存主要是根据服务器返回的header里面的Cache-Control来决定的，如果不支持缓存，那么可以拦截到返回信息替换头部信息加入缓存标志
        Request request = chain.request();
        Response response = chain.proceed(request);
        boolean isConnected = true;
        if (!isConnected) {
            //没有网络

        } else {

        }
//        LogUtils.i(TAG,"======intercept request:"+request.toString());
//        LogUtils.i(TAG,"======intercept response:"+response.body().string());
        //请求头中自定义的key，如果请求头中包含这个key，则证明是需要进行缓存的
//        String cache = request.header(CacheTime);
//        if (!Valid.checkNull(cache)) {
//            Response response1 = response.newBuilder()
//                    .removeHeader("Cache-Control")
//                    .removeHeader("Pragma")
//                    .header("Cache-Control", "max-age=" + cache)
//                    .build();
//            return response1;
//        }
        return response;
    }

}
