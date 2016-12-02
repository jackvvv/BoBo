package sinia.com.bobo.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.dl7.player.utils.SoftInputUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.adapter.MyFragmentPagerAdapter;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.fragment.GiftListFragment;
import sinia.com.bobo.fragment.LiveChatFragment;
import sinia.com.bobo.fragment.LiverDetailFragment;
import sinia.com.bobo.view.NEMediaController;

/**
 * Created by 忧郁的眼神 on 2016/11/25 0025.
 */

public class LiveDetailActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.tab_title)
    TabLayout tabTitle;
    @Bind(R.id.img_attiontion)
    ImageView imgAttiontion;
    @Bind(R.id.tv_attention_num)
    TextView tvAttentionNum;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.player_view)
    IjkPlayerView mPlayerView;

    private MyFragmentPagerAdapter pagerAdapter;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    private LiveChatFragment chatFragment;
    private LiverDetailFragment liverFragment;
    private GiftListFragment giftFragment;
    private String VIDEO_URL = "http://flv2.bn.netease.com/videolib3/1611/28/GbgsL3639/SD/movie_index.m3u8";
    private static final String IMAGE_URL = "http://vimg2.ws.126.net/image/snapshot/2016/11/I/M/VC62HMUIM.jpg";
    public static LinearLayout ll_tab;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_live_detail);
        ll_tab = (LinearLayout) findViewById(R.id.ll_tab);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initData();
    }

    private void initData() {
        titleList = new ArrayList<>();
        titleList.add("聊天");
        titleList.add("主播");
        titleList.add("直播榜单");
        fragmentList = new ArrayList<>();
        chatFragment = new LiveChatFragment();
        liverFragment = new LiverDetailFragment();
        giftFragment = new GiftListFragment();
        fragmentList.add(chatFragment);
        fragmentList.add(liverFragment);
        fragmentList.add(giftFragment);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(pagerAdapter);
        tabTitle.setTabMode(TabLayout.MODE_FIXED);
        tabTitle.addTab(tabTitle.newTab().setText(titleList.get(0)));
        tabTitle.addTab(tabTitle.newTab().setText(titleList.get(1)));
        tabTitle.addTab(tabTitle.newTab().setText(titleList.get(2)));
        tabTitle.setupWithViewPager(viewPager);

        setVideo();
    }

    private void setVideo() {
//        mediaController = new NEMediaController(this);
//        videoView.setMediaController(mediaController);
//        videoView.setBufferingIndicator(layoutLoading);
//        videoView.setBufferStrategy(0);
//        videoView.requestFocus();
//        videoView.setVideoPath(url);
//        videoView.start();
        Glide.with(this).load(IMAGE_URL).fitCenter().into(mPlayerView.mPlayerThumb);
        mPlayerView.init()
                .setTitle("标题长苌长长苌长长苌长长苌长长苌长长苌长长苌长")
                .setSkipTip(1000 * 60 * 1)
                .enableDanmaku()
                .setDanmakuSource(getResources().openRawResource(R.raw.comments))
                .setVideoSource(null, VIDEO_URL, null, null, null)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH);
    }

    @OnClick({R.id.tv_report, R.id.img_share, R.id.ll_like})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_report:
                break;
            case R.id.img_share:
                break;
            case R.id.ll_like:
                break;
        }
    }

    @Override
    protected boolean isOpenStatusBar() {
        return false;
    }

    @Override
    protected boolean closeOpenStatusBar() {
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayerView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayerView.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mPlayerView.configurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (mPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
