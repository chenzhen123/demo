package demo.test.cz.http_library.annotation;

import android.support.annotation.StringDef;

import static demo.test.cz.http_library.annotation.MediaTypes.JSON;

/**
 * @description:
 * @FileName: MediaTypes.java
 * @author: chenzhen
 * @date: 2018-06-12
 * @E-mail:zhenchen@excar.com.cn
 */
@StringDef({JSON})
public @interface MediaTypes {
    String JSON = "application/json; charset=utf-8";

}
