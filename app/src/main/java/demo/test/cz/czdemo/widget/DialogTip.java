package demo.test.cz.czdemo.widget;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.BindView;
import demo.test.cz.czdemo.R;
import demo.test.cz.czdemo.base.dialog.BaseDialog;

import static demo.test.cz.czdemo.widget.DialogTip.DURATION_TYPE.DURATION_NO;
import static demo.test.cz.czdemo.widget.DialogTip.DURATION_TYPE.DURATION_YES;

/**
 *
 * File: DialogTip.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/29 15:36
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class DialogTip extends BaseDialog {
    private static String TAG = DialogTip.class.getSimpleName();
    private static String DIALOG_TIP_TEXT = "dialog_tip_text";
    private static String DIALOG_TIP_DURATION = "dialog_tip_duration";
    private static String DIALOG_TIP_TYPE = "dialog_tip_duration";

    /**
     * @hide
     */
    @IntDef({DURATION_YES, DURATION_NO})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DURATION_TYPE {
        /**
         * 倒计时模式
         */
        int DURATION_YES = 1;
        /**
         * 非倒计时模式
         */
        int DURATION_NO = 0;
    }

    @BindView(R.id.real_name_dialog_text)
    AppCompatTextView realNameDialogText;
    @BindView(R.id.real_name_dialog_button)
    AppCompatButton realNameDialogButton;
    private Bundle bundle;
    /**
     * 时间
     */
    private int duration;
    /**
     * 文本
     */
    private String text;
    /**
     * 类型{@link DURATION_TYPE}
     */
    private int type;
    private CountDownTimer countDownTimer;
    private TimerListener timerListener;


    public static DialogTip newInstance(@NonNull String text, int duration, @NonNull @DURATION_TYPE int type) {
        Bundle args = new Bundle();
        DialogTip fragment = new DialogTip();
        fragment.setArguments(args);
        args.putString(DIALOG_TIP_TEXT, text);
        args.putInt(DIALOG_TIP_DURATION, duration);
        args.putInt(DIALOG_TIP_TYPE, type);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_tip_layout;
    }

    @Override
    public void initDate() {
        bundle = getArguments();
        text = bundle.getString(DIALOG_TIP_TEXT);
        duration = bundle.getInt(DIALOG_TIP_DURATION);
        type = bundle.getInt(DIALOG_TIP_TYPE);
        if (type == DURATION_TYPE.DURATION_YES) {
            countDownTimer = new CountDownTimer(duration, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(text);
                    stringBuffer.append(" ");
                    stringBuffer.append("(");
                    stringBuffer.append(millisUntilFinished / 1000);
                    stringBuffer.append("s)");
                    realNameDialogText.setText(stringBuffer.toString());
                    if (timerListener != null) {
                        timerListener.onTick(millisUntilFinished);
                    }
                }

                @Override
                public void onFinish() {
                    if (timerListener != null) {
                        timerListener.onFinish();
                    }
                    getDialog().dismiss();
                }
            };
        }


    }

    @Override
    public void initView() {
        if (type == DURATION_TYPE.DURATION_YES) {
            countDownTimer.start();
        } else {
            if (!TextUtils.isEmpty(bundle.getString(text))) {
                realNameDialogText.setText(text);
            }
        }

    }

    @Override
    public void initListener() {
        realNameDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
    }

    public void setTimerListener(TimerListener timerListener) {
        this.timerListener = timerListener;
    }
}
