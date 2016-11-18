package sinia.com.bobo.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import sinia.com.bobo.R;
import sinia.com.bobo.adapter.MyFragmentPagerAdapter;
import sinia.com.bobo.base.BaseFragment;
import sinia.com.bobo.utils.AppInfoUtil;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public class AttentionFragment extends BaseFragment {
    @Bind(R.id.tab_title)
    TabLayout tabTitle;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private MyFragmentPagerAdapter pagerAdapter;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    private AttentionLivingFragment livingFragment;
    private AttentionNotLiveFragment notLiveFragment;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_attention, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initViews() {
        titleList = new ArrayList<>();
        titleList.add("直播中");
        titleList.add("未开播");
        fragmentList = new ArrayList<>();
        livingFragment = new AttentionLivingFragment();
        notLiveFragment = new AttentionNotLiveFragment();
        fragmentList.add(livingFragment);
        fragmentList.add(notLiveFragment);
        pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(pagerAdapter);
        tabTitle.setTabMode(TabLayout.MODE_FIXED);
        tabTitle.addTab(tabTitle.newTab().setText(titleList.get(0)));
        tabTitle.addTab(tabTitle.newTab().setText(titleList.get(1)));
        tabTitle.setupWithViewPager(viewPager);

        Class<?> tablayout = tabTitle.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tablayout.getDeclaredField("mTabStrip");
            tabStrip.setAccessible(true);
            LinearLayout ll_tab = (LinearLayout) tabStrip.get(tabTitle);
            for (int i = 0; i < ll_tab.getChildCount(); i++) {
                View child = ll_tab.getChildAt(i);
                child.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams
                        .MATCH_PARENT, 1);
                params.setMarginStart(AppInfoUtil.dip2px(getActivity(), 50f));
                params.setMarginEnd(AppInfoUtil.dip2px(getActivity(), 50f));
                child.setLayoutParams(params);
                child.invalidate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
