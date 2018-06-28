package demo.test.cz.czdemo.fragment;

import android.os.Bundle;

import demo.test.cz.czdemo.R;
import demo.test.cz.czdemo.base.MainContract;
import demo.test.cz.czdemo.base.fragment.BaseFragment;


/**
 * File: MainPageFragment.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/28 14:30
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class MainPageFragment extends BaseFragment<MainContract.MainPagePresenter> implements MainContract.MainPageView {
    public static MainPageFragment newInstance() {
        Bundle args = new Bundle();
        MainPageFragment fragment = new MainPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentViewId() {
        return R.layout.mainpage_fragment;
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
