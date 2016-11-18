package sinia.com.bobo.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dou361.statusbar.StatusBarUtil;
import com.dou361.statusbar.SwipeBackLayout;

import butterknife.ButterKnife;
import sinia.com.bobo.R;
import sinia.com.bobo.utils.SystemBarTintManager;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 当前Activity
     */
    protected Activity activity;
    /**
     * 当前上下文
     */
    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        mContext = this;
        BaseApplication.getInstance().addActivity(this);
        if (isSlideFinish()) {
            SwipeBackLayout layout = new SwipeBackLayout(this, null);
            layout.attachToActivity(this, SwipeBackLayout.CloseMode.PRESSBACK);
        }
        initView();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        if (isOpenStatusBar()) {
            setDefaultStatusBar();
            //设置状态栏字体图标黑色
            sinia.com.bobo.utils.StatusBarUtil.StatusBarLightMode(this, true);
        } else {
            //设置登录注册页面绿色状态栏
            setLoginStatusBar();
        }
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    protected void startActivityForNoIntent(Class forwordClass) {
        Intent intent = new Intent(this, forwordClass);
        startActivity(intent);
    }

    /**
     */
    protected void startActivityForIntent(Class forwordClass, Intent intent) {
        intent.setClass(this, forwordClass);
        startActivity(intent);
    }

    protected void startLoginActivityForNoIntent(Class forwordClass) {
        Intent intent = new Intent(this, forwordClass);
        startActivity(intent);
        overridePendingTransition(R.anim.login_open, 0);
    }

    protected void startLoginActivityForIntent(Class forwordClass, Intent intent) {
        intent.setClass(this, forwordClass);
        startActivity(intent);
        overridePendingTransition(R.anim.login_open, 0);
    }

    /**
     * 是否开启沉浸式状态栏
     *
     * @return
     */
    protected boolean isOpenStatusBar() {
        return true;
    }

    /**
     * 设置默认状态栏颜色
     */
    protected void setDefaultStatusBar() {
        StatusBarUtil.setColorNoTranslucent(this, getResources().getColor(R.color.colorPrimary));
    }

    /**
     * 设置登录状态栏颜色
     */
    protected void setLoginStatusBar() {
        StatusBarUtil.setColorNoTranslucent(this, getResources().getColor(R.color.theme_green));
    }

    /**
     * 是否右滑关闭activity
     * false 无操作
     *
     * @return
     */
    protected boolean isSlideFinish() {
        return false;
    }

    protected abstract void initView();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        BaseApplication.getInstance().finishActivity(this);
        try {
            super.onBackPressed();
        } catch (Exception e) {
        }
    }

    @Override
    protected void onDestroy() {
        /** 主动调用gc回收 */
        System.gc();
        super.onDestroy();
    }
}
