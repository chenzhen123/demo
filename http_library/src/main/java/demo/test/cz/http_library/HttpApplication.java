package demo.test.cz.http_library;

import android.app.Application;
import android.content.Context;

/**
 * @description:
 * @FileName: demo.test.cz.http_library.HttpApplication.java
 * @author: chenzhen
 * @date: 2018-06-11
 * @E-mail:zhenchen@excar.com.cn
 */

public class HttpApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
