package demo.test.cz.czdemo.presenter;

import demo.test.cz.czdemo.base.MainContract;
import demo.test.cz.czdemo.base.presenter.BasePresenter;


/**
 * File: SettingPresenter.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/28 14:50
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class SettingPresenter extends BasePresenter<MainContract.SettingView> implements MainContract.SettingPresenter {
    public SettingPresenter(MainContract.SettingView view) {
        super(view);
    }
}
