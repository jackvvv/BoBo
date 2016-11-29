package sinia.com.bobo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.activity.LivePrevueActivity;
import sinia.com.bobo.activity.LookHistoryActivity;
import sinia.com.bobo.activity.SearchActivity;
import sinia.com.bobo.activity.StartLiveActivity;
import sinia.com.bobo.adapter.MyFragmentPagerAdapter;
import sinia.com.bobo.base.BaseFragment;
import sinia.com.bobo.utils.BlurBehind;
import sinia.com.bobo.utils.OnBlurCompleteListener;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.tab_title)
    TabLayout tabTitle;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.fab_live)
    ImageView fabLive;

    private MyFragmentPagerAdapter pagerAdapter;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    private RecommendFragment recommendFragment;
    private EntertainmentFragment entertaFragment;
    private LifeFragment lifeFragment;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
        titleList = new ArrayList<>();
        titleList.add("推荐");
        titleList.add("娱乐");
        titleList.add("生活");
        fragmentList = new ArrayList<>();
        recommendFragment = new RecommendFragment();
        entertaFragment = new EntertainmentFragment();
        lifeFragment = new LifeFragment();
        fragmentList.add(recommendFragment);
        fragmentList.add(entertaFragment);
        fragmentList.add(lifeFragment);
        pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(pagerAdapter);
        tabTitle.setTabMode(TabLayout.MODE_FIXED);
        tabTitle.addTab(tabTitle.newTab().setText(titleList.get(0)));
        tabTitle.addTab(tabTitle.newTab().setText(titleList.get(1)));
        tabTitle.addTab(tabTitle.newTab().setText(titleList.get(2)));
        tabTitle.setupWithViewPager(viewPager);
    }

    @OnClick({R.id.img_history, R.id.img_preview, R.id.img_search, R.id.fab_live})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_history:
                startActivityForNoIntent(LookHistoryActivity.class);
                break;
            case R.id.img_preview:
                startActivityForNoIntent(LivePrevueActivity.class);
                break;
            case R.id.img_search:
                startActivityForNoIntent(SearchActivity.class);
                break;
            case R.id.fab_live:
                BlurBehind.getInstance().execute(getActivity(), new OnBlurCompleteListener() {
                    @Override
                    public void onBlurComplete() {
                        startLoginActivityForNoIntent(StartLiveActivity.class);
                    }
                });
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
