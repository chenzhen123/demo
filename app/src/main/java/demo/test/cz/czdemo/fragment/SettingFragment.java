package demo.test.cz.czdemo.fragment;

import android.os.Bundle;

import demo.test.cz.czdemo.R;
import demo.test.cz.czdemo.base.MainContract;
import demo.test.cz.czdemo.base.view.BaseFragment;


/**
 * File: SettingFragment.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/28 14:37
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class SettingFragment extends BaseFragment<MainContract.SettingPresenter> implements MainContract.SettingView {
    public static SettingFragment newInstance() {
        Bundle args = new Bundle();
        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentViewId() {
        return R.layout.setting_fragment;
    }

    @Override
    public void initDate() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }
}
