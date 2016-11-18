package sinia.com.bobo.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public class ForgetPasswordActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.et_tel)
    EditText etTel;
    @Bind(R.id.et_code)
    EditText etCode;
    @Bind(R.id.tv_getCode)
    TextView tvGetCode;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.et_confirm)
    EditText etConfirm;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_forget_pwd);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @OnClick({R.id.tv_getCode, R.id.tv_ok, R.id.tv_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_getCode:
                break;
            case R.id.tv_ok:
                break;
            case R.id.tv_login:
                startLoginActivityForNoIntent(LoginActivity.class);
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
