package demo.test.cz.czdemo.base.presenter;

import java.lang.ref.WeakReference;

import demo.test.cz.czdemo.base.IBasePresenter;
import demo.test.cz.czdemo.base.IBaseView;

/**
 * presenter的基类
 * File: BasePresenter.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/27 16:01
 * E-mail:zhenchen@ecarx.com.cn
 **/
public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter {
    protected static String TAG = BasePresenter.class.getSimpleName();
    private WeakReference<T> weakReference;

    public BasePresenter(T view) {
        this.weakReference = new WeakReference<T>(view);
        if (weakReference.get() != null) {
            weakReference.get().setPresenter(this);
        }
        start();
    }

    /**
     * 获取view
     *
     * @return
     */
    public T getView() {
        return weakReference.get();
    }

    @Override
    public void start() {

    }

    @Override
    public void end() {

    }
}
