package demo.test.cz.http_library.base;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import demo.test.cz.http_library.R;
import demo.test.cz.http_library.error.CustomObserver;
import demo.test.cz.http_library.error.LocalExceptionHandle;
import demo.test.cz.http_library.itip.Itip;
import demo.test.cz.http_library.utils.LogUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @description: 上游的基类, 主要统一处理开始和结束时候的状态，绑定生命周期防止内存泄漏
 * @FileName: BaseWrapper.java
 * @author: chenzhen
 * @date: 2018-06-12
 * @E-mail:zhenchen@excar.com.cn
 */

public abstract class BaseWrapper {
    /**
     * 在activity中做网络通信
     *
     * @param observable
     * @param tip
     * @param customObserver
     * @param <T>
     */
    public <T extends BaseEntivy> void doTranceOnActivity(Observable<T> observable, final Itip tip, CustomObserver customObserver) {
        //添加LifecycleProvider防止内存泄漏(如果是在activity中调用则应该传ActivityEvent)
        LifecycleProvider<ActivityEvent> lifecycleProvider = tip.getLifecycleProvider();
        observable
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends T>>() {
                    @Override
                    public ObservableSource<? extends T> apply(Throwable throwable) throws Exception {
                        LogUtils.e("BaseWrapper", "======onErrorResumeNext");
                        return Observable.error(LocalExceptionHandle.handleException(throwable));
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (tip != null) {
                            tip.showLoding(R.string.http_library_loading);
                        }
                        LogUtils.i("BaseWrapper", "======doOnSubscribe");
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        if (tip != null) {
                            tip.hideLoding();
                        }
                        LogUtils.i("BaseWrapper", "======doFinnally");
                    }
                })
                .compose(lifecycleProvider.<T>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(customObserver);
    }

    /**
     * 在fragment中做网络通信
     *
     * @param observable
     * @param tip
     * @param customObserver
     * @param <T>
     */
    public <T extends BaseEntivy> void doTranceOnFragment(Observable<T> observable, final Itip tip, CustomObserver customObserver) {
        LifecycleProvider<FragmentEvent> lifecycleProvider = tip.getLifecycleProvider();
        observable
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends T>>() {
                    @Override
                    public ObservableSource<? extends T> apply(Throwable throwable) throws Exception {
                        LogUtils.e("BaseWrapper", "======onErrorResumeNext");
                        return Observable.error(LocalExceptionHandle.handleException(throwable));
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (tip != null) {
                            tip.showLoding(R.string.http_library_loading);
                        }
                        LogUtils.i("BaseWrapper", "======doOnSubscribe");
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        if (tip != null) {
                            tip.hideLoding();
                        }
                        LogUtils.i("BaseWrapper", "======doFinnally");
                    }
                })
                .compose(lifecycleProvider.<T>bindUntilEvent(FragmentEvent.DESTROY_VIEW))
                .subscribe(customObserver);
    }
}
