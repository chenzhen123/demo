package demo.test.cz.czdemo.base.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.RxFragment;

import demo.test.cz.czdemo.base.IBaseView;
import demo.test.cz.czdemo.basetips.IUiInit;
import demo.test.cz.http_library.itip.Itip;

/**
 * File: BaseFragment.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/27 15:34
 * E-mail:zhenchen@ecarx.com.cn
 **/
public abstract class BaseFragment<P> extends RxFragment implements Itip, IUiInit,IBaseView<P> {
    protected View view;
    private Activity activity;
    protected P presenter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        view = inflater.inflate(getContentViewId(), container,false);
        initView();
        initListener();
        return view;
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
    public void showDialog(int id) {

    }

    @Override
    public void showDialog(String text, int duration) {

    }

    @Override
    public void showDialog(int id, int duration) {

    }

    @Override
    public LifecycleProvider<FragmentEvent> getLifecycleProvider() {
        return this;
    }

    public void startFragment(int layoutId, Fragment fragment) {
        activity.getFragmentManager()
                .beginTransaction()
                .add(layoutId, fragment)
                .addToBackStack(null)
                .hide(this)
                .commit();
    }

    @Override
    public P getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }
}
