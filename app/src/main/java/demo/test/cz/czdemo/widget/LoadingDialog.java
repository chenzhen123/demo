package demo.test.cz.czdemo.widget;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.test.cz.czdemo.R;
import demo.test.cz.czdemo.base.dialog.BaseDialog;

/**
 * File: LoadingDialog.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/29 10:54
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class LoadingDialog extends BaseDialog {
    private static String TAG = LoadingDialog.class.getSimpleName();
    private static String LOADING_DIALOG_TEXT = "load_dialog_text";
    @BindView(R.id.dialog_progress_iv)
    ImageView dialogProgressIv;
    @BindView(R.id.tv_loading_dialog_content)
    TextView tvLoadingDialogContent;
    private Animation mCircleAnim;
    private View view;

    public static LoadingDialog newInstance(String text) {

        Bundle args = new Bundle();
        LoadingDialog fragment = new LoadingDialog();
        args.putString(LOADING_DIALOG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.loading_dialog_layout;
    }

    @Override
    public void initDate() {

    }

    @Override
    public void initView() {
        //动画
        mCircleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.dialog_loading_anim);
        LinearInterpolator interpolator = new LinearInterpolator();
        mCircleAnim.setInterpolator(interpolator);
        if (mCircleAnim != null) {
            dialogProgressIv.setAnimation(mCircleAnim);
        }
        if (!TextUtils.isEmpty(getArguments().getString(LOADING_DIALOG_TEXT))) {
            tvLoadingDialogContent.setText(getArguments().getString(LOADING_DIALOG_TEXT));
        }
    }

    @Override
    public void initListener() {

    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        return super.show(transaction, tag);
    }
}
