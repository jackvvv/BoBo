package sinia.com.bobo.activity;

import android.app.ActivityManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.base.BaseApplication;
import sinia.com.bobo.fragment.AttentionFragment;
import sinia.com.bobo.fragment.HomeFragment;
import sinia.com.bobo.fragment.LocalCityFragment;
import sinia.com.bobo.fragment.MineFragment;

public class MainActivity extends BaseActivity {

    @Bind(R.id.frame_content)
    FrameLayout frameContent;
    @Bind(R.id.image_home)
    ImageView imageHome;
    @Bind(R.id.tv_home)
    TextView tvHome;
    @Bind(R.id.layout_home)
    RelativeLayout layoutHome;
    @Bind(R.id.image_manager)
    ImageView imageManager;
    @Bind(R.id.tv_manager)
    TextView tvManager;
    @Bind(R.id.layout_manager)
    RelativeLayout layoutManager;
    @Bind(R.id.image_yw)
    ImageView imageYw;
    @Bind(R.id.tv_yw)
    TextView tvYw;
    @Bind(R.id.layout_youwo)
    RelativeLayout layoutYouwo;
    @Bind(R.id.image_helper)
    ImageView imageHelper;
    @Bind(R.id.tv_helper)
    TextView tvHelper;
    @Bind(R.id.layout_helper)
    RelativeLayout layoutHelper;
    @Bind(R.id.frameMenu)
    FrameLayout frameMenu;

    private long exitTime = 0;
    private String[] tagArray = {"tab1", "tab2", "tab3", "tab4"};
    private Class<?>[] fragments = {HomeFragment.class, AttentionFragment.class,
            LocalCityFragment.class, MineFragment.class};
    private HomeFragment f1;
    private AttentionFragment f2;
    private LocalCityFragment f3;
    private MineFragment f4;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        f1 = new HomeFragment();
        f2 = new AttentionFragment();
        f3 = new LocalCityFragment();
        f4 = new MineFragment();

        FragmentTransaction fragmentTransaction = this
                .getSupportFragmentManager().beginTransaction();
        if (!f1.isAdded()) {
            fragmentTransaction.hide(f2).hide(f3).hide(f4)
                    .add(R.id.frame_content, f1).show(f1);
        } else {
            fragmentTransaction.hide(f2).hide(f3).hide(f4).show(f1);
        }
        fragmentTransaction.commit();
        imageHome.setSelected(true);
        tvHome.setSelected(true);

        tvManager.setSelected(false);
        imageManager.setSelected(false);

        tvYw.setSelected(false);
        imageYw.setSelected(false);

        tvHelper.setSelected(false);
        imageHelper.setSelected(false);
    }

    @OnClick({R.id.layout_home, R.id.layout_manager, R.id.layout_youwo, R.id.layout_helper})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_home: {
                FragmentTransaction fragmentTransaction = this
                        .getSupportFragmentManager().beginTransaction();
                if (!f1.isAdded()) {
                    fragmentTransaction.hide(f2).hide(f3).hide(f4)
                            .add(R.id.frame_content, f1).show(f1);
                } else {
                    fragmentTransaction.hide(f2).hide(f3).hide(f4).show(f1);
                }
                fragmentTransaction.commit();
                imageHome.setSelected(true);
                tvHome.setSelected(true);

                tvManager.setSelected(false);
                imageManager.setSelected(false);

                tvYw.setSelected(false);
                imageYw.setSelected(false);

                tvHelper.setSelected(false);
                imageHelper.setSelected(false);
            }
            break;
            case R.id.layout_manager: {
                FragmentTransaction fragmentTransaction = this
                        .getSupportFragmentManager().beginTransaction();
                if (!f2.isAdded()) {
                    fragmentTransaction.hide(f1).hide(f3).hide(f4)
                            .add(R.id.frame_content, f2).show(f2);
                } else {
                    fragmentTransaction.hide(f1).hide(f3).hide(f4).show(f2);
                }
                fragmentTransaction.commit();
                imageHome.setSelected(false);
                tvHome.setSelected(false);

                tvManager.setSelected(true);
                imageManager.setSelected(true);

                tvYw.setSelected(false);
                imageYw.setSelected(false);

                tvHelper.setSelected(false);
                imageHelper.setSelected(false);
            }
            break;
            case R.id.layout_youwo: {
                FragmentTransaction fragmentTransaction = this
                        .getSupportFragmentManager().beginTransaction();
                if (!f3.isAdded()) {
                    fragmentTransaction.hide(f1).hide(f2).hide(f4)
                            .add(R.id.frame_content, f3).show(f3);
                } else {
                    fragmentTransaction.hide(f2).hide(f1).hide(f4).show(f3);
                }
                fragmentTransaction.commit();
                imageHome.setSelected(false);
                tvHome.setSelected(false);

                tvManager.setSelected(false);
                imageManager.setSelected(false);

                tvYw.setSelected(true);
                imageYw.setSelected(true);

                tvHelper.setSelected(false);
                imageHelper.setSelected(false);
            }
            break;
            case R.id.layout_helper: {
                FragmentTransaction fragmentTransaction = this
                        .getSupportFragmentManager().beginTransaction();
                if (!f4.isAdded()) {
                    fragmentTransaction.hide(f1).hide(f3).hide(f2)
                            .add(R.id.frame_content, f4).show(f4);
                } else {
                    fragmentTransaction.hide(f1).hide(f3).hide(f2).show(f4);
                }
                fragmentTransaction.commit();
                imageHome.setSelected(false);
                tvHome.setSelected(false);

                tvManager.setSelected(false);
                imageManager.setSelected(false);

                tvYw.setSelected(false);
                imageYw.setSelected(false);

                tvHelper.setSelected(true);
                imageHelper.setSelected(true);
            }
            break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            showToast("再按一次退出应用");
            exitTime = System.currentTimeMillis();
        } else {
            BaseApplication.getInstance().finishActivity(this);
        }
    }

}
