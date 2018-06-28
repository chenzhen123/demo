package demo.test.cz.czdemo.base.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.FrameStats;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.RxActivity;

import java.util.HashMap;
import java.util.Map;

import demo.test.cz.czdemo.basetips.IUiInit;
import demo.test.cz.http_library.itip.Itip;
import demo.test.cz.http_library.utils.LogUtils;

/**
 * @description:
 * @FileName: BaseActivity.java
 * @author: chenzhen
 * @date: 2018-06-12
 * @E-mail:zhenchen@excar.com.cn
 */

public abstract class BaseActivity extends RxActivity implements Itip, IUiInit {
    protected final String TAG = getClass().getSimpleName();
    protected Fragment currentFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewId() > 0) {
            setContentView(getContentViewId());
            //initWindow();
        }
        initDate();
        initView();
        initListener();
    }

    @Override
    public void showLoding(int id) {

    }

    @Override
    public void hideLoding() {

    }

    @Override
    public void showToast(String text) {

    }

    @Override
    public void showDialog(String text) {

    }

    @Override
    public void showDialog(String text, int duration) {

    }

    @Override
    public void showDialog(int id, int duration) {

    }

    /**
     * 沉浸式（兼容API19)
     */
    private void initWindow() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = window.getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup contentView = window.getDecorView().findViewById(Window.ID_ANDROID_CONTENT);
            contentView.getChildAt(0).setFitsSystemWindows(true);
        }
    }

    @Override
    public LifecycleProvider<ActivityEvent> getLifecycleProvider() {
        return this;
    }

    public void startFragment(int layoutId, Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        LogUtils.i(TAG, "======tag:" + fragment.getTag());
        if (!fragment.isAdded()) {
            transaction
                    .add(layoutId, fragment, fragment.getClass().getSimpleName());
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.show(fragment);

        } else {
            transaction.hide(currentFragment)
                    .show(fragment);
        }
        currentFragment = fragment;
        transaction.commit();
    }
}
