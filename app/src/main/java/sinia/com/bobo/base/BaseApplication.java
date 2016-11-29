package sinia.com.bobo.base;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;

import com.dou361.baseutils.utils.LogUtils;
import com.dou361.baseutils.utils.UtilsManager;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import static com.tencent.bugly.crashreport.crash.c.a;
import static com.tencent.bugly.crashreport.crash.c.i;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;
    private static final LinkedList<BaseActivity> mActivities = new LinkedList<BaseActivity>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        /**工具类库初始化*/
        UtilsManager.init(this, "", new Handler(), Thread.currentThread());
        UtilsManager.getInstance().setDebugEnv(false);
        UtilsManager.getInstance().setLogLevel(LogUtils.LogType.LEVEL_ERROR);
        Bugly.init(getApplicationContext(), "f82c7ea5ff", false);
        Beta.checkUpgrade(false, false);
        //OkHttpClient初始化
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS).build();
        OkHttpUtils.initClient(okHttpClient);
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    /**
     * 关闭所有页面
     */
    public static void finishAllActivity() {
        List<BaseActivity> list;
        synchronized (mActivities) {
            list = new ArrayList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : list) {
            activity.finish();
        }
        mActivities.clear();
    }

    /**
     * 添加页面
     */
    public static void addActivity(BaseActivity activity) {
        for (int i = 0; i < mActivities.size(); i++) {
            if (activity == mActivities.get(i)) {
                mActivities.remove(i);
                break;
            }
        }
        mActivities.add(activity);
    }

    /**
     * 关闭页面
     */
    public static void finishActivity(BaseActivity activity) {
        for (int j = 0; j < mActivities.size(); j++) {
            if (activity == mActivities.get(j)) {
                activity.finish();
                mActivities.remove(i);
                break;
            }
        }
    }

    /**
     * 关闭当前页面
     */
    public static void finishCurrentActivity() {
        if (mActivities.size() > 0) {
            mActivities.get(mActivities.size() - 1).finish();
            mActivities.remove(mActivities.size() - 1);
        }
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        finishAllActivity();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
