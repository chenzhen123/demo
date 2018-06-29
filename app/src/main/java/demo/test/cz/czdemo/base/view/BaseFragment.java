package demo.test.cz.czdemo.base.view;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.test.cz.czdemo.base.IBaseView;
import demo.test.cz.czdemo.basetips.IUiInit;
import demo.test.cz.czdemo.utils.ToastUtils;
import demo.test.cz.czdemo.widget.DialogTip;
import demo.test.cz.czdemo.widget.LoadingDialog;
import demo.test.cz.http_library.itip.Itip;

/**
 * File: BaseFragment.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/27 15:34
 * E-mail:zhenchen@ecarx.com.cn
 **/
public abstract class BaseFragment<P> extends RxFragment implements Itip, IUiInit, IBaseView<P> {
    protected View view;
    protected Activity activity;
    protected P presenter;
    Unbinder unbinder;
    private LoadingDialog dialog;
    private DialogTip dialogTip;
    private DialogTip dialogTipDuration;

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
        view = inflater.inflate(getContentViewId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initListener();
        return view;
    }


    @Override
    public void showLoding(int id) {
        if (dialog == null) {
            dialog = LoadingDialog.newInstance(getResources().getString(id));

        }
        if (!dialog.getDialog().isShowing()) {
            dialog.show(getChildFragmentManager(), "loading");
        }
    }

    @Override
    public void hideLoding() {
        if (dialog != null) {
            Dialog mDialog = dialog.getDialog();
            if (mDialog != null && !mDialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    @Override
    public void showToast(String text) {
        ToastUtils.showToast(getActivity(), text, Toast.LENGTH_SHORT);
    }


    @Override
    public void showDialogs(int id) {
        if (dialogTip == null) {
            dialogTip = DialogTip.newInstance(getResources().getString(id), 0, DialogTip.DURATION_TYPE.DURATION_NO);
            dialogTip.show(getChildFragmentManager(), "dialog_tip");
        }
    }

    @Override
    public void showDialog(int id, int duration) {
        if (dialogTipDuration == null) {
            dialogTipDuration = DialogTip.newInstance(getResources().getString(id), duration, DialogTip.DURATION_TYPE.DURATION_YES);
            dialogTipDuration.show(getChildFragmentManager(), "dialog_tip");
        }
    }

    @Override
    public void hideDialog() {
        if (dialogTip != null) {
            dialogTip.dismiss();
        }
        if (dialogTipDuration != null) {
            dialogTipDuration.dismiss();
        }
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
