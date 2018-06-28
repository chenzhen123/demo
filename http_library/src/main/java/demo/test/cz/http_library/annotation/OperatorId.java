package demo.test.cz.http_library.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static demo.test.cz.http_library.annotation.OperatorId.CMCC;
import static demo.test.cz.http_library.annotation.OperatorId.UNICOM;

/**
 * @description: sim卡列表查询-运营商id
 * @FileName: OperatorId.java
 * @author: lvlei
 * @date: 2018-05-17
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({UNICOM, CMCC})
public @interface OperatorId {
    /**
     * 联通
     */
    int UNICOM = 1;
    /**
     * 移动
     */
    int CMCC = 2;
}
