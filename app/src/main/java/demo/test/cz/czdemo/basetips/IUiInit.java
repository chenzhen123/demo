package demo.test.cz.czdemo.basetips;

/**
 * @description:
 * @FileName: IUiInit.java
 * @author: chenzhen
 * @date: 2018-06-12
 * @E-mail:zhenchen@excar.com.cn
 */

public interface IUiInit {
    /**
     * xml的res
     *
     * @return
     */
    int getContentViewId();

    /**
     * 初始化数据，这个数据是在oncreate之前执行的
     *
     * @return
     */
    void initDate();

    /**
     * 初始化view
     */
    void initView();

    /**
     * 初始化监听器
     */
    void initListener();

}
