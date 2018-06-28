package demo.test.cz.http_library.utils;

import android.util.Log;

import demo.test.cz.http_library.BuildConfig;

/**
 * @description: 日志工具
 * @FileName: LogUtils.java
 * @author: chenzhen
 * @date: 2018-06-08
 * @E-mail:zhenchen@excar.com.cn
 */

public class LogUtils {
    private static final boolean LOCAL = BuildConfig.Local_Log;
    private static final boolean WEB = BuildConfig.Web_Log;

    public static void v(String tag, String msg) {
        if (LOCAL) {
            Log.v(tag, msg);
        }
        if (WEB) {

        }
    }

    public static void d(String tag, String msg) {
        if (LOCAL) {
            Log.d(tag, msg);
        }
        if (WEB) {

        }
    }

    public static void i(String tag, String msg) {
        if (LOCAL) {
            Log.i(tag, msg);
        }
        if (WEB) {

        }
    }

    public static void w(String tag, String msg) {
        if (LOCAL) {
            Log.w(tag, msg);
        }
        if (WEB) {

        }
    }

    public static void e(String tag, String msg) {
        if (LOCAL) {
            Log.e(tag, msg);
        }
        if (WEB) {

        }
    }
}
