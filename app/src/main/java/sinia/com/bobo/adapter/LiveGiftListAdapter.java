package sinia.com.bobo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import sinia.com.bobo.R;
import sinia.com.bobo.utils.ViewHolder;

/**
 * Created by 忧郁的眼神 on 2016/11/23 0023.
 */

public class LiveGiftListAdapter extends BaseAdapter {
    private Context context;

    public LiveGiftListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 12;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gift_list, null);
        }
        ImageView img_head = ViewHolder.get(convertView, R.id.img_head);
        TextView tv_name = ViewHolder.get(convertView, R.id.tv_name);
        TextView tv_level = ViewHolder.get(convertView, R.id.tv_level);
        TextView tv_contribute = ViewHolder.get(convertView, R.id.tv_contribute);

        return convertView;
    }
}
