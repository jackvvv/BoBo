package sinia.com.bobo.activity;

import com.dou361.baseutils.utils.UIUtils;

import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;

/**
 * Created by 忧郁的眼神 on 2016/11/18 0018.
 */

public class SplashActivity extends BaseActivity {
    @Override
    protected void initView() {
        setContentView(R.layout.activity_splash);
        UIUtils.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivityForNoIntent(MainActivity.class);
                onBackPressed();
            }
        }, 1000);
    }

    @Override
    protected boolean isOpenStatusBar() {
        return false;
    }
}
