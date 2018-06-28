package demo.test.cz.http_library.itip;

import com.trello.rxlifecycle2.*;


/**
 * @description:
 * @FileName: Itip.java
 * @author: chenzhen
 * @date: 2018-06-12
 * @E-mail:zhenchen@excar.com.cn
 */

public interface Itip {
    /**
     * 显示持续的动画
     *
     * @param id
     */
    void showLoding(int id);

    /**
     * 隐藏动画
     */
    void hideLoding();

    /**
     * 显示吐司
     *
     * @param text
     */
    void showToast(String text);

    /**
     * 显示dialog
     *
     * @param text
     */
    void showDialog(String text);

    void showDialog(int id);

    /**
     * 显示倒计时的dialog
     *
     * @param text
     * @param duration
     */
    void showDialog(String text, int duration);

    void showDialog(int id, int duration);

    /**
     * 获取lifecycleProvider对象,注意，rxactivity和rxfragment已经实现了这个接口
     *
     * @param <T>
     * @return
     */
    <T> LifecycleProvider<T> getLifecycleProvider();
}
