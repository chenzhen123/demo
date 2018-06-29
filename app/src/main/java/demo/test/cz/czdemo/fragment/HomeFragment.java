package demo.test.cz.czdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.test.cz.czdemo.R;
import demo.test.cz.czdemo.base.MainContract;
import demo.test.cz.czdemo.base.view.BaseFragment;
import demo.test.cz.http_library.base.BaseEntivy;
import demo.test.cz.http_library.error.CustomObserver;
import demo.test.cz.http_library.error.ErrorEntity;
import demo.test.cz.http_library.response.TestResponseBody;
import demo.test.cz.http_library.wrapper.TestWrapper;


/**
 * File: HomeFragment.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/27 17:36
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class HomeFragment extends BaseFragment<MainContract.HomePresenter> implements MainContract.HomeView {

    @BindView(R.id.home_text)
    TextView homeText;

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

    @OnClick(R.id.home_text)
    public void onViewClicked() {
        TestWrapper.getInstance().getSimCardDetail(activity, this, "18496575041", new CustomObserver<BaseEntivy<TestResponseBody>>() {
            @Override
            public void onNextConsumer(@NonNull BaseEntivy<TestResponseBody> testResponseBodyBaseEntivy) {

            }

            @Override
            public void onErrorConsumer(@NonNull ErrorEntity errorEntity) {

            }

            @Override
            public void onCompleteConsumer() {

            }
        });
    }
}
