package demo.test.cz.http_library.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static demo.test.cz.http_library.annotation.SimCardStatus.ACTIVATED;
import static demo.test.cz.http_library.annotation.SimCardStatus.STOPPED;
import static demo.test.cz.http_library.annotation.SimCardStatus.UNACTIVATED;

/**
 * @description: sim卡列表查询-实名状态
 * @FileName: SimCardStatus.java
 * @author: lvlei
 * @date: 2018-05-17
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({UNACTIVATED, ACTIVATED, STOPPED})
public @interface SimCardStatus {
    /**
     * 未激活
     */
    int UNACTIVATED = 0;
    /**
     * 激活
     */
    int ACTIVATED = 1;
    /**
     * 停机
     */
    int STOPPED = 2;
}
