package sinia.com.bobo.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public class LoginActivity extends BaseActivity {

    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.et_tel)
    EditText etTel;
    @Bind(R.id.et_pwd)
    EditText etPwd;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                overridePendingTransition(0, R.anim.login_close);
            }
        });
    }

    @Override
    protected boolean isOpenStatusBar() {
        return false;
    }

    @OnClick({R.id.tv_forgetpwd, R.id.tv_login, R.id.tv_register, R.id.tel_login, R.id.wx_login, R.id.qq_login, R.id
            .wb_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_forgetpwd:
                startActivityForNoIntent(ForgetPasswordActivity.class);
                break;
            case R.id.tv_login:
                break;
            case R.id.tv_register:
                startActivityForNoIntent(RegisterActivity.class);
                break;
            case R.id.tel_login:
                break;
            case R.id.wx_login:
                break;
            case R.id.qq_login:
                break;
            case R.id.wb_login:
                break;
        }
    }
}
