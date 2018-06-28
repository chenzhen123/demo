package demo.test.cz.http_library.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static demo.test.cz.http_library.annotation.LogAnnotation.Local_Log;
import static demo.test.cz.http_library.annotation.LogAnnotation.Web_Log;

/**
 * @description:
 * @FileName: LogAnnotation.java
 * @author: chenzhen
 * @date: 2018-06-08
 * @E-mail:zhenchen@excar.com.cn
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({Web_Log, Local_Log})
public @interface LogAnnotation {
    /**
     * 网络日志
     */
    int Web_Log = 1;
    /**
     * 本地日志
     */
    int Local_Log = 2;

}
