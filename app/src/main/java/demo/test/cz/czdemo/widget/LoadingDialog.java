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

/**
 * File: LoadingDialog.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/29 10:54
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class LoadingDialog extends DialogFragment {
    private static String TAG = LoadingDialog.class.getSimpleName();
    private static String LOADING_DIALOG_TEXT = "load_dialog_text";
    @BindView(R.id.dialog_progress_iv)
    ImageView dialogProgressIv;
    @BindView(R.id.tv_loading_dialog_content)
    TextView tvLoadingDialogContent;
    Unbinder unbinder;
    private Animation mCircleAnim;
    private View view;

    public static LoadingDialog newInstance(String text) {

        Bundle args = new Bundle();
        LoadingDialog fragment = new LoadingDialog();
        args.putString(LOADING_DIALOG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.loading_dialog_layout, container, false);
        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
        getDialog().setCanceledOnTouchOutside(false);
        //dialog横线问题,有些系统会显示横线，在这里统一处理掉
        int dividerId = this.getResources().getIdentifier("android:id/titleDivider", null, null);
        View divider = getDialog().findViewById(dividerId);
        if (divider != null) {
            divider.setBackgroundColor(Color.TRANSPARENT);
        }
        //动画
        mCircleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.dialog_loading_anim);
        LinearInterpolator interpolator = new LinearInterpolator();
        mCircleAnim.setInterpolator(interpolator);
        if (mCircleAnim != null) {
            dialogProgressIv.setAnimation(mCircleAnim);
        }
        unbinder = ButterKnife.bind(this, view);
        if (!TextUtils.isEmpty(getArguments().getString(LOADING_DIALOG_TEXT))) {
            tvLoadingDialogContent.setText(getArguments().getString(LOADING_DIALOG_TEXT));
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        return super.show(transaction, tag);
    }
}
