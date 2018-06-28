package demo.test.cz.czdemo.fragment;

import android.os.Bundle;

import demo.test.cz.czdemo.R;
import demo.test.cz.czdemo.base.MainContract;
import demo.test.cz.czdemo.base.fragment.BaseFragment;


/**
 * File: HomeFragment.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/27 17:36
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class HomeFragment extends BaseFragment<MainContract.HomePresenter> implements MainContract.HomeView {

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentViewId() {
        return R.layout.home_fragment;
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
