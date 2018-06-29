package demo.test.cz.czdemo;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import demo.test.cz.czdemo.base.view.BaseActivity;
import demo.test.cz.czdemo.fragment.HomeFragment;
import demo.test.cz.czdemo.fragment.MainPageFragment;
import demo.test.cz.czdemo.fragment.SettingFragment;

public class MainActivity extends BaseActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView navigation;
    private Fragment homeFragment;
    private Fragment mainPageFragment;
    private Fragment settingFragment;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initDate() {
        homeFragment = HomeFragment.newInstance();
        mainPageFragment = MainPageFragment.newInstance();
        settingFragment = SettingFragment.newInstance();
    }

    @Override
    public  void initView() {
        navigation = findViewById(R.id.navigation);
        startFragment(R.id.main_content, homeFragment);
    }

    @Override
    public void initListener() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startFragment(R.id.main_content, homeFragment);
                    break;
                case R.id.navigation_dashboard:
                    startFragment(R.id.main_content, mainPageFragment);
                    break;
                case R.id.navigation_notifications:
                    startFragment(R.id.main_content, settingFragment);
                    break;
                default:
                    break;
            }
            return true;
        }
    };
}
