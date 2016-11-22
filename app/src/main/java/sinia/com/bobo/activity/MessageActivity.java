package sinia.com.bobo.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import sinia.com.bobo.R;
import sinia.com.bobo.adapter.MessageAdapter;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.utils.AppInfoUtil;
import sinia.com.bobo.view.swipmenulistview.SwipeMenu;
import sinia.com.bobo.view.swipmenulistview.SwipeMenuCreator;
import sinia.com.bobo.view.swipmenulistview.SwipeMenuItem;
import sinia.com.bobo.view.swipmenulistview.SwipeMenuListView;

/**
 * Created by 忧郁的眼神 on 2016/11/21 0021.
 */

public class MessageActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.listview)
    SwipeMenuListView listview;

    private MessageAdapter adapter;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_message);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initData();
    }

    private void initData() {
        adapter = new MessageAdapter(this);
        listview.setAdapter(adapter);
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {

                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setTitle("删除");
                deleteItem.setTitleSize(16);
                deleteItem.setTitleColor(Color.WHITE);
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF3,
                        0x55, 0x55)));
                deleteItem.setWidth(AppInfoUtil.dip2px(MessageActivity.this, 80));
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        listview.setMenuCreator(creator);
        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu,
                                           int index) {
                switch (index) {
                    case 0:
                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }

}
