package demo.test.cz.http_library.port;

import android.support.annotation.NonNull;

import demo.test.cz.http_library.error.ErrorEntity;

/**
 * @description:
 * @FileName: IConsumer.java
 * @author: chenzhen
 * @date: 2018-06-11
 * @E-mail:zhenchen@excar.com.cn
 */

public interface IConsumer<T> {
    void onNextConsumer(@NonNull T t);
    void onErrorConsumer(@NonNull ErrorEntity errorEntity);
    void onCompleteConsumer();
}
