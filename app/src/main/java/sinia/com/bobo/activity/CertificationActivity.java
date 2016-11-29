package sinia.com.bobo.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;

/**
 * Created by 忧郁的眼神 on 2016/11/29 0029.
 */

public class CertificationActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_certification);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @OnClick(R.id.tv_ok)
    public void onClick() {
        startActivityForNoIntent(PerfectInfo1Activity.class);
    }

    @Override
    protected boolean isOpenStatusBar() {
        return false;
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }
}
