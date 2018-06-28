package demo.test.cz.czdemo.base;

/**
 * 契约类
 * File: MainContract.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/27 15:58
 * E-mail:zhenchen@ecarx.com.cn
 **/
public interface MainContract {
    /**
     * Homefragment的v和p层接口
     */
    interface HomePresenter extends IBasePresenter {
    }

    interface HomeView extends IBaseView<HomePresenter> {
    }

    /**
     * MainPageFragment的V和P层接口
     */
    interface MainPagePresenter extends IBasePresenter {
    }

    interface MainPageView extends IBaseView<MainPagePresenter> {
    }

    /**
     * SettingFragment的V和P
     */
    interface SettingPresenter extends IBasePresenter {
    }

    interface SettingView extends IBaseView<SettingPresenter> {
    }

}
