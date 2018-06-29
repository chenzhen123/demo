package demo.test.cz.czdemo.base;

import android.view.View;

/**
 * File: IBaseDialog.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/29 15:54
 * E-mail:zhenchen@ecarx.com.cn
 **/
public interface IBaseDialog {
    int getLayoutId();
    void initDate();
    void initView();
    void initListener();


    interface  ConfirmClickListener{
        void onConfirmClick(View view);
    }

    /**
     * 倒计时的接口
     */
    interface TimerListener{
        /**
         *
         * @param time 当前剩余时间
         */
        void onTick(long time);

        /**
         * 结束
         */
        void onFinish();
    }

}
