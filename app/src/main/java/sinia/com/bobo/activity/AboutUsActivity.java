package sinia.com.bobo.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;

import static sinia.com.bobo.R.id.toolBar;

/**
 * Created by 忧郁的眼神 on 2016/11/22 0022.
 */

public class AboutUsActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_about_us);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }
}
