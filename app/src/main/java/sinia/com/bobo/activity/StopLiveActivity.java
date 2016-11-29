package sinia.com.bobo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.utils.BlurBehind;

/**
 * Created by 忧郁的眼神 on 2016/11/24 0024.
 */

public class StopLiveActivity extends BaseActivity {

    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_online)
    TextView tvOnline;
    @Bind(R.id.tv_attention)
    TextView tvAttention;
    @Bind(R.id.tv_share)
    TextView tvShare;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_stop_live);
        BlurBehind.getInstance().withAlpha(40).withFilterColor(Color.parseColor("#000000"))
                .setBackground(this);
    }

    @OnClick(R.id.img_close)
    public void onClick() {
        onBackPressed();
        overridePendingTransition(0, R.anim.login_close);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.login_close);
    }

}
