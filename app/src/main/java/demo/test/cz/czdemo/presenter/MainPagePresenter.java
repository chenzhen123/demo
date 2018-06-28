package demo.test.cz.czdemo.presenter;

import demo.test.cz.czdemo.base.MainContract;
import demo.test.cz.czdemo.base.presenter.BasePresenter;


/**
 * File: MainPagePresenter.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/28 14:31
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class MainPagePresenter extends BasePresenter<MainContract.MainPageView> implements MainContract.MainPagePresenter {
    public MainPagePresenter(MainContract.MainPageView view) {
        super(view);
    }
}
