package demo.test.cz.http_library.error;

import java.util.concurrent.atomic.AtomicReference;

import demo.test.cz.http_library.annotation.Kind;
import demo.test.cz.http_library.base.BaseEntivy;
import demo.test.cz.http_library.port.IConsumer;
import demo.test.cz.http_library.utils.LogUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ErrorMode;

/**
 * @description: 统一处理下游
 * @FileName: CustomObserver.java
 * @author: chenzhen
 * @date: 2018-06-11
 * @E-mail:zhenchen@excar.com.cn
 */

public abstract class CustomObserver<T extends BaseEntivy> implements Observer<T>, IConsumer<T>, Disposable {
    private static final String TAG = CustomObserver.class.getSimpleName();
    private AtomicReference<Disposable> atomicReference = new AtomicReference<>();

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T value) {
        if (!isDisposed()) {
            try {
                if (value.isSucc()) {
                    LogUtils.i(TAG, "======onNextConsumer");
                    onNextConsumer(value);
                } else {
                    LogUtils.e(TAG, "======onErrorConsumer");
                    onErrorConsumer(LocalExceptionHandle.makeErrorEntity(value.getResultCode()));
                }
            } catch (Throwable e) {
                e.printStackTrace();
                LogUtils.e(TAG, "======onNext crash");
                onErrorConsumer(LocalExceptionHandle.systemError());
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        LogUtils.e(TAG, "======onError:" + e);
        if (!isDisposed()) {
            atomicReference.lazySet(DisposableHelper.DISPOSED);
            try {
                ErrorEntity errorEntity = LocalExceptionHandle.resolve(e);
                LogUtils.e(TAG, "======onError ,errorentity:" + errorEntity.toString());
                onErrorConsumer(errorEntity);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                LogUtils.e(TAG, "======OnError exception");
                onErrorConsumer(LocalExceptionHandle.systemError());
            }
        }
    }

    @Override
    public void onComplete() {
        LogUtils.i(TAG, "======onComplete");
        if (!isDisposed()) {
            atomicReference.lazySet(DisposableHelper.DISPOSED);
            try {
                onCompleteConsumer();
            } catch (Throwable e) {
                LogUtils.e(TAG, "======onComplete");
            }
        }

    }

    @Override
    public void dispose() {
        if (isDisposed()) {
            DisposableHelper.dispose(atomicReference);
        }
    }

    @Override
    public boolean isDisposed() {
        return atomicReference.get() == DisposableHelper.DISPOSED;
    }
}
