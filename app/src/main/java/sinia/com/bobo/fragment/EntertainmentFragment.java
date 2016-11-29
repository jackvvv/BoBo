package sinia.com.bobo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import sinia.com.bobo.R;
import sinia.com.bobo.activity.LiveDetailActivity;
import sinia.com.bobo.adapter.AttentionLivingAdapter;
import sinia.com.bobo.adapter.recycleadapter.LGRecycleViewAdapter;
import sinia.com.bobo.base.BaseFragment;
import sinia.com.bobo.bean.LiveThumbModel;
import sinia.com.bobo.utils.FullyGridLayoutManager;
import sinia.com.bobo.utils.GridSpacingItemDecoration;

/**
 * Created by 忧郁的眼神 on 2016/11/18 0018.
 */

public class EntertainmentFragment extends BaseFragment {
    @Bind(R.id.rv_entainment)
    RecyclerView rvEntainment;

    private AttentionLivingAdapter adapter;
    private List<LiveThumbModel> entertainmentList = new ArrayList<>();
    private List<String> bannerUrls = new ArrayList<>();
    private Banner banner;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_home_entertainment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        entertainmentList.clear();

        bannerUrls.clear();
        bannerUrls.add("https://rpic.douyucdn.cn/a1611/18/15/872419_161118150534.jpg");
        bannerUrls.add("https://rpic.douyucdn.cn/a1611/18/15/794626_161118150601.jpg");
        bannerUrls.add("https://rpic.douyucdn.cn/a1611/18/15/65297_161118150545.jpg");

        for (int i = 0; i < 15; i++) {
            LiveThumbModel live = new LiveThumbModel();
            live.setId(i + "");
            live.setTitle("街霸2有奖赛");
            live.setUsername("大嘴巴2016");
            live.setLooknum(65);
            live.setImgUrl("https://rpic.douyucdn.cn/a1611/18/15/1052316_161118152632.jpg");
            entertainmentList.add(live);
        }
        RecyclerViewHeader header = RecyclerViewHeader.fromXml(getActivity(), R.layout.view_header_yule_banner);
        adapter = new AttentionLivingAdapter(getActivity(), entertainmentList);
        rvEntainment.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        header.attachTo(rvEntainment);
        rvEntainment.setHasFixedSize(true);
        rvEntainment.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
        rvEntainment.setAdapter(adapter);
        banner = (Banner) header.findViewById(R.id.banner);
        banner.setImages(bannerUrls).setIndicatorGravity(BannerConfig.CENTER).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(getActivity()).load(path).placeholder(R.drawable.img_loading).into(imageView);
            }
        }).start();

        adapter.setOnItemClickListener(R.id.root, new LGRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                startActivityForNoIntent(LiveDetailActivity.class);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
