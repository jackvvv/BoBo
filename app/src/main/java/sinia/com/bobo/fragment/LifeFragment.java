package sinia.com.bobo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
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

public class LifeFragment extends BaseFragment {
    @Bind(R.id.rv_life)
    RecyclerView rvLife;

    private Banner banner;
    private AttentionLivingAdapter adapter;
    private List<LiveThumbModel> lifeList = new ArrayList<>();
    private List<String> bannerUrls = new ArrayList<>();

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_home_life, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        lifeList.clear();
        bannerUrls.clear();
        bannerUrls.add("https://staticlive.douyucdn.cn/upload/signs/201611141607434779.jpg");
        bannerUrls.add("https://rpic.douyucdn.cn/a1611/18/15/733110_161118152131.jpg");
        bannerUrls.add("https://rpic.douyucdn.cn/appCovers/973982/20160925/1ae272b72a01ce8847b5507909e5d49c_big.jpg");
        bannerUrls.add("https://rpic.douyucdn.cn/a1611/18/15/1312893_161118152628.jpg");
        bannerUrls.add("https://staticlive.douyucdn.cn/upload/web_pic/79db69835bcc3fc58002f07fd184e8fc_thumb.jpg");

        for (int i = 0; i < 15; i++) {
            LiveThumbModel live = new LiveThumbModel();
            live.setId(i + "");
            live.setTitle("放长线钓大鱼");
            live.setUsername("中华户外钓鱼");
            live.setLooknum(9874);
            live.setImgUrl("https://rpic.douyucdn.cn/a1611/18/15/1052316_161118152632.jpg");
            lifeList.add(live);
        }
        RecyclerViewHeader header = RecyclerViewHeader.fromXml(getActivity(), R.layout.view_header_life_banner);
        adapter = new AttentionLivingAdapter(getActivity(), lifeList);
        rvLife.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        header.attachTo(rvLife);
        rvLife.setHasFixedSize(true);
        rvLife.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
        rvLife.setAdapter(adapter);
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
