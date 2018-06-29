package demo.test.cz.czdemo.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import demo.test.cz.czdemo.R;

/**
 * File: ToastUtils.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/29 10:24
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class ToastUtils {
    private static String TAG = ToastUtils.class.getSimpleName();
    private static Toast toast;

    public static void showToast(Context context, String msg, int flag) {
        toast = new Toast(context);
        View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(flag);
        toast.setView(view);
        toast.show();
    }
}
