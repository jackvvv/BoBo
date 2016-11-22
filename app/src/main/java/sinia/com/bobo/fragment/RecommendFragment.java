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

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import sinia.com.bobo.R;
import sinia.com.bobo.adapter.AttentionLivingAdapter;
import sinia.com.bobo.base.BaseFragment;
import sinia.com.bobo.bean.LiveThumbModel;
import sinia.com.bobo.utils.FullyGridLayoutManager;
import sinia.com.bobo.utils.GridSpacingItemDecoration;

import static sinia.com.bobo.R.id.recycleView;

/**
 * Created by 忧郁的眼神 on 2016/11/18 0018.
 */

public class RecommendFragment extends BaseFragment {
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.recycleView_all)
    RecyclerView rvAll;
    @Bind(R.id.rv_entainment)
    RecyclerView rvEntainment;
    @Bind(R.id.rv_life)
    RecyclerView rvLife;

    private AttentionLivingAdapter adapter;
    private List<LiveThumbModel> allhotList = new ArrayList<>();
    private List<LiveThumbModel> entertainmentList = new ArrayList<>();
    private List<LiveThumbModel> lifeList = new ArrayList<>();
    private List<String> bannerUrls = new ArrayList<>();

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_home_recommend, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        allhotList.clear();
        entertainmentList.clear();
        lifeList.clear();

        bannerUrls.clear();
        bannerUrls.add("https://staticlive.douyucdn.cn/upload/signs/201611141607434779.jpg");
        bannerUrls.add("https://rpic.douyucdn.cn/appCovers/2016/11/15/1378146_201611151633_big.jpg");
        bannerUrls.add("https://rpic.douyucdn.cn/a1611/18/15/6483_161118150551.jpg");
        bannerUrls.add("https://rpic.douyucdn.cn/a1611/18/15/1191327_161118150531.jpg");
        bannerUrls.add("https://staticlive.douyucdn.cn/upload/web_pic/79db69835bcc3fc58002f07fd184e8fc_thumb.jpg");
        banner.setImages(bannerUrls).setIndicatorGravity(BannerConfig.CENTER).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(getActivity()).load(path).placeholder(R.drawable.img_loading).into(imageView);
            }
        }).start();

        for (int i = 0; i < 4; i++) {
            LiveThumbModel live = new LiveThumbModel();
            live.setId(i + "");
            live.setTitle("国服第一狗头");
            live.setUsername("douyu、雨神");
            live.setLooknum(6581);
            live.setImgUrl("https://rpic.douyucdn.cn/a1611/18/14/599975_161118145930.jpg");
            allhotList.add(live);
        }
        for (int i = 0; i < 4; i++) {
            LiveThumbModel live = new LiveThumbModel();
            live.setId(i + "");
            live.setTitle("死神教学，帮水友上分");
            live.setUsername("一波黑");
            live.setLooknum(2155);
            live.setImgUrl("https://rpic.douyucdn.cn/a1611/18/15/1310172_161118150538.jpg");
            entertainmentList.add(live);
        }
        for (int i = 0; i < 4; i++) {
            LiveThumbModel live = new LiveThumbModel();
            live.setId(i + "");
            live.setTitle("猛犬与贱狗");
            live.setUsername("妖艳的猫哥");
            live.setLooknum(842);
            live.setImgUrl("https://rpic.douyucdn.cn/a1611/18/15/713239_161118150548.jpg");
            lifeList.add(live);
        }
        adapter = new AttentionLivingAdapter(getActivity(), allhotList);
        rvAll.setLayoutManager(new FullyGridLayoutManager(getActivity(), 2));
        rvAll.setHasFixedSize(true);
        rvAll.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
        rvAll.setAdapter(adapter);

        adapter = new AttentionLivingAdapter(getActivity(), entertainmentList);
        rvEntainment.setLayoutManager(new FullyGridLayoutManager(getActivity(), 2));
        rvEntainment.setHasFixedSize(true);
        rvEntainment.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
        rvEntainment.setAdapter(adapter);

        adapter = new AttentionLivingAdapter(getActivity(), lifeList);
        rvLife.setLayoutManager(new FullyGridLayoutManager(getActivity(), 2));
        rvLife.setHasFixedSize(true);
        rvLife.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
        rvLife.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
