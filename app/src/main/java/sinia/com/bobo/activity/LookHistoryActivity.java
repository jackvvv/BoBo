package sinia.com.bobo.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.adapter.AttentionLivingAdapter;
import sinia.com.bobo.adapter.recycleadapter.LGRecycleViewAdapter;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.bean.LiveThumbModel;
import sinia.com.bobo.utils.GridSpacingItemDecoration;

/**
 * Created by 忧郁的眼神 on 2016/11/21 0021.
 */

public class LookHistoryActivity extends BaseActivity {

    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.recycleView)
    RecyclerView recycleView;

    private AttentionLivingAdapter adapter;
    private List<LiveThumbModel> liveList = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_look_history);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initData();
    }

    private void initData() {
        liveList.clear();
        for (int i = 0; i < 5; i++) {
            LiveThumbModel live = new LiveThumbModel();
            live.setId(i + "");
            live.setTitle("新主播欢迎关注，关注不迷路");
            live.setUsername("一个很萌的人");
            live.setLooknum(2958);
            live.setImgUrl("https://rpic.douyucdn.cn/appCovers/2016/11/15/1378146_201611151633_big.jpg");
            liveList.add(live);
        }
        adapter = new AttentionLivingAdapter(this, liveList);
        recycleView.setLayoutManager(new GridLayoutManager(this, 2));
        recycleView.setHasFixedSize(true);
        recycleView.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
        recycleView.setAdapter(adapter);
        adapter.setOnItemClickListener(R.id.img, new LGRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                showToast("sss");
            }
        });
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }

    @OnClick(R.id.tv_clear)
    public void onClick() {
    }
}
