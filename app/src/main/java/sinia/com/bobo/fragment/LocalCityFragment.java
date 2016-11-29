package sinia.com.bobo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import sinia.com.bobo.R;
import sinia.com.bobo.activity.LiveDetailActivity;
import sinia.com.bobo.adapter.AttentionLivingAdapter;
import sinia.com.bobo.adapter.recycleadapter.LGRecycleViewAdapter;
import sinia.com.bobo.base.BaseFragment;
import sinia.com.bobo.bean.LiveThumbModel;
import sinia.com.bobo.utils.GridSpacingItemDecoration;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public class LocalCityFragment extends BaseFragment {

    @Bind(R.id.recycleView)
    RecyclerView recycleView;

    private AttentionLivingAdapter adapter;
    private List<LiveThumbModel> liveList = new ArrayList<>();

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
        adapter = new AttentionLivingAdapter(getActivity(), liveList);
        recycleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recycleView.setHasFixedSize(true);
        recycleView.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
        recycleView.setAdapter(adapter);
        adapter.setOnItemClickListener(R.id.root, new LGRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                startActivityForNoIntent(LiveDetailActivity.class);
            }
        });
    }
}
