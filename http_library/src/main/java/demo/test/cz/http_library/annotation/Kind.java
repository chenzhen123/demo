package demo.test.cz.http_library.annotation;

import android.support.annotation.IntDef;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static demo.test.cz.http_library.annotation.Kind.CONVERSION;
import static demo.test.cz.http_library.annotation.Kind.E_5000;
import static demo.test.cz.http_library.annotation.Kind.E_5001;
import static demo.test.cz.http_library.annotation.Kind.E_5002;
import static demo.test.cz.http_library.annotation.Kind.E_5003;
import static demo.test.cz.http_library.annotation.Kind.E_5004;
import static demo.test.cz.http_library.annotation.Kind.HTTP;
import static demo.test.cz.http_library.annotation.Kind.NETWORK;
import static demo.test.cz.http_library.annotation.Kind.SYSTEMERR;
import static demo.test.cz.http_library.annotation.Kind.UNEXPECTED;

/**
 * @description:无查询结果的异常
 * @FileName: Kind.java
 * @author: chenzhen
 * @date: 2018-06-11
 * @E-mail:zhenchen@excar.com.cn
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({NETWORK,CONVERSION,HTTP,UNEXPECTED,SYSTEMERR,E_5000,E_5001,E_5002,E_5003,E_5004 })
public @interface Kind {
    /**
     * An System Error
     */
    int SYSTEMERR = 0;
    /**
     * An {@link IOException} occurred while communicating to the server.
     */
    int NETWORK = 1;
    /**
     * An exception was thrown while (de)serializing a body.
     */
    int CONVERSION = 2;
    /**
     * A non-200 HTTP status code was received from the server.
     */
    int HTTP = 3;
    /**
     * An internal error occurred while attempting to execute a request. It is best practice to
     * re-throw this exception so your application crashes.
     */
    int UNEXPECTED = 4;
    /**
     * 必要字段缺失
     */
    int E_5000 = 5;
    /**
     * 无查询结果
     */
    int E_5001 = 6;
    /**
     * 系统异常
     */
    int E_5002 = 7;
    /**
     * 依赖系统异常
     */
    int E_5003 = 8;
    /**
     * 密钥不匹配
     */
    int E_5004 = 9;
}
