package sinia.com.bobo.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;

/**
 * Created by 忧郁的眼神 on 2016/11/23 0023.
 */

public class SearchActivity extends BaseActivity {
    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.toolBar)
    Toolbar toolBar;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_search);
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
