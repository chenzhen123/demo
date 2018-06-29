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
     * @param id       资源id
     * @param duration 倒计时
     */
    void showDialog(int id, int duration);

    /**
     * 无倒计时的dialog
     * @param id 资源id
     */
    void showDialogs(int id);

    void hideDialog();

    /**
     * 获取lifecycleProvider对象,注意，rxactivity和rxfragment已经实现了这个接口
     *
     * @param <T>
     * @return
     */
    <T> LifecycleProvider<T> getLifecycleProvider();
}
