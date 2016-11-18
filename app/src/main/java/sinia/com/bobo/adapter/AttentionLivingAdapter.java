package sinia.com.bobo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import sinia.com.bobo.R;
import sinia.com.bobo.adapter.recycleadapter.LGRecycleViewAdapter;
import sinia.com.bobo.adapter.recycleadapter.LGViewHolder;
import sinia.com.bobo.bean.LiveThumbModel;
import sinia.com.bobo.utils.AppInfoUtil;

/**
 * Created by 忧郁的眼神 on 2016/11/18 0018.
 */

public class AttentionLivingAdapter extends LGRecycleViewAdapter<LiveThumbModel> {

    private Context context;
    private List<LiveThumbModel> dataList;

    public AttentionLivingAdapter(Context context, List<LiveThumbModel> dataList) {
        super(dataList);
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_live_thumb;
    }

    @Override
    public void convert(LGViewHolder holder, LiveThumbModel liveThumbModel, int position) {
        ImageView img = (ImageView) holder.getView(R.id.img);
        TextView tv_title = (TextView) holder.getView(R.id.tv_title);
        TextView tv_username = (TextView) holder.getView(R.id.tv_username);
        TextView tv_lookNum = (TextView) holder.getView(R.id.tv_looknum);
        LinearLayout root = (LinearLayout) holder.getView(R.id.root);

        int itemWidth = AppInfoUtil.getScreenWidth(context) / 2 - AppInfoUtil.dip2px(context, 20);
        LinearLayout.LayoutParams lpImage = new LinearLayout.LayoutParams(itemWidth, itemWidth * 2 / 3);
        img.setLayoutParams(lpImage);

        LinearLayout.LayoutParams lpRoot = new LinearLayout.LayoutParams(itemWidth, LinearLayout.LayoutParams
                .WRAP_CONTENT);
        root.setLayoutParams(lpRoot);

        tv_title.setText(dataList.get(position).getTitle());
        tv_username.setText(dataList.get(position).getUsername());
        tv_lookNum.setText(dataList.get(position).getLooknum() + "");
        Glide.with(context).load(dataList.get(position).getImgUrl()).bitmapTransform(new RoundedCornersTransformation
                (context, 10, 0, RoundedCornersTransformation.CornerType.ALL)).placeholder(R.drawable.img_loading).into(img);
    }
}
