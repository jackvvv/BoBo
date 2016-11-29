package sinia.com.bobo.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.adapter.MyFragmentPagerAdapter;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.fragment.AttentionLivingFragment;
import sinia.com.bobo.fragment.AttentionNotLiveFragment;
import sinia.com.bobo.fragment.GiftListFragment;
import sinia.com.bobo.fragment.LiveChatFragment;
import sinia.com.bobo.fragment.LiverDetailFragment;
import sinia.com.bobo.view.NEMediaController;
import sinia.com.bobo.view.NEVideoView;

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
    @Bind(R.id.videoView)
    NEVideoView videoView;
    @Bind(R.id.tv_room)
    TextView tvRoom;
    @Bind(R.id.tv_people)
    TextView tvPeople;
    @Bind(R.id.img_control)
    ImageView imgControl;
    @Bind(R.id.img_full)
    ImageView imgFull;
    @Bind(R.id.tv_present)
    TextView tvPresent;
    @Bind(R.id.layout_loading)
    LinearLayout layoutLoading;

    private MyFragmentPagerAdapter pagerAdapter;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    private LiveChatFragment chatFragment;
    private LiverDetailFragment liverFragment;
    private GiftListFragment giftFragment;
    private NEMediaController mediaController;
    private String url = "rtmp://rrbalancer.broadcast.tneg.de:1935/pw/ruk/ruk";

    @Override
    protected void initView() {
        setContentView(R.layout.activity_live_detail);
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
        mediaController = new NEMediaController(this);
        videoView.setMediaController(mediaController);
        videoView.setBufferingIndicator(layoutLoading);
        videoView.setBufferStrategy(0);
        videoView.requestFocus();
        videoView.setVideoPath(url);
        videoView.start();
    }

    @OnClick({R.id.tv_report, R.id.img_share, R.id.ll_like, R.id.img_control, R.id.img_full})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_report:
                break;
            case R.id.img_share:
                break;
            case R.id.ll_like:
                break;
            case R.id.img_control:
                break;
            case R.id.img_full:
                break;
        }
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }
}
