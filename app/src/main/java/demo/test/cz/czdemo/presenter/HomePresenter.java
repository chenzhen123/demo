package demo.test.cz.czdemo.presenter;

import demo.test.cz.czdemo.base.MainContract;
import demo.test.cz.czdemo.base.presenter.BasePresenter;


/**
 * File: HomePresenter.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/27 17:42
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class HomePresenter extends BasePresenter<MainContract.HomeView> implements MainContract.HomePresenter {

    public HomePresenter(MainContract.HomeView view) {
        super(view);
    }
}
