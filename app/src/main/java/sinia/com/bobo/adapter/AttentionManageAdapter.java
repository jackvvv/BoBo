package sinia.com.bobo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zcw.togglebutton.ToggleButton;

import sinia.com.bobo.R;
import sinia.com.bobo.utils.ViewHolder;

/**
 * Created by 忧郁的眼神 on 2016/11/23 0023.
 */

public class AttentionManageAdapter extends BaseAdapter {
    private Context context;

    public AttentionManageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_attention_manager, null);
        }
        TextView tv_type = ViewHolder.get(convertView, R.id.tv_type);
        TextView tv_name = ViewHolder.get(convertView, R.id.tv_name);
        TextView tv_title = ViewHolder.get(convertView, R.id.tv_title);
        TextView tv_num = ViewHolder.get(convertView, R.id.tv_num);
        ImageView img = ViewHolder.get(convertView, R.id.img);

        Glide.with(context).load("https://rpic.douyucdn" +
                ".cn/appCovers/794976/20160714/ceec8c6058d51a100fa8208331183266_big.jpg")
                .placeholder(R.drawable.img_loading)
                .into(img);
        return convertView;
    }
}
