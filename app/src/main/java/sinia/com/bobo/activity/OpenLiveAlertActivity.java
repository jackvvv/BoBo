package sinia.com.bobo.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import sinia.com.bobo.R;
import sinia.com.bobo.adapter.OpenLiveAdapter;
import sinia.com.bobo.base.BaseActivity;

/**
 * Created by 忧郁的眼神 on 2016/11/23 0023.
 */

public class OpenLiveAlertActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.listView)
    ListView listView;

    private OpenLiveAdapter adapter;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_openlive_alert);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initData();
    }

    private void initData() {
        adapter = new OpenLiveAdapter(this);
        listView.setAdapter(adapter);
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }
}
