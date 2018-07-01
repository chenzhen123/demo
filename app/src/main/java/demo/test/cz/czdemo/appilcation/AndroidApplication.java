package demo.test.cz.czdemo.appilcation;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;

/**
 * @description:
 * @FileName: AndroidApplication.java
 * @author: chenzhen
 * @date: 2018-07-01
 * @e-mail:18814806231@163.com
 */

public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        return super.startForegroundService(service);
    }
}
