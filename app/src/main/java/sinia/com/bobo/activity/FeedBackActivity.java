package sinia.com.bobo.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;

/**
 * Created by 忧郁的眼神 on 2016/11/22 0022.
 */

public class FeedBackActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.et_title)
    EditText etTitle;
    @Bind(R.id.et_content)
    EditText etContent;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_feedback);
        initData();
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
    }

    @OnClick(R.id.tv_submit)
    public void onClick() {
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }
}
