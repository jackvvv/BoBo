package sinia.com.bobo.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public class RegisterActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.tv_getCode)
    TextView tvGetCode;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_register);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @OnClick({R.id.et_nickname, R.id.et_tel, R.id.et_code, R.id.tv_getCode, R.id.et_pwd, R.id.tv_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_nickname:
                break;
            case R.id.et_tel:
                break;
            case R.id.et_code:
                break;
            case R.id.tv_getCode:
                break;
            case R.id.et_pwd:
                break;
            case R.id.tv_register:
                break;
        }
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
