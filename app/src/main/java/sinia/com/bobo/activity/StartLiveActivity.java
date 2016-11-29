package sinia.com.bobo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.utils.BlurBehind;

/**
 * Created by 忧郁的眼神 on 2016/11/24 0024.
 */

public class StartLiveActivity extends BaseActivity {
    @Bind(R.id.et_title)
    EditText etTitle;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_start_live);
        BlurBehind.getInstance().withAlpha(40).withFilterColor(Color.parseColor("#000000"))
                .setBackground(this);
    }

    @OnClick({R.id.tv_startLive, R.id.img_close})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_startLive:
                startActivityForNoIntent(CertificationActivity.class);
                break;
            case R.id.img_close:
                onBackPressed();
                overridePendingTransition(0, R.anim.login_close);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.login_close);
    }
}
