package demo.test.cz.czdemo.base;

/**
 * File: IBaseView.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/27 15:50
 * E-mail:zhenchen@ecarx.com.cn
 **/
public interface IBaseView<P> {
    /**
     * 获取presenter
     *
     * @return
     */
    P getPresenter();

    /**
     * 设置presenter
     */
    void setPresenter(P presenter);

}
