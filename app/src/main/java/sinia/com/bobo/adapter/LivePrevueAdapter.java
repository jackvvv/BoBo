package sinia.com.bobo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import sinia.com.bobo.R;
import sinia.com.bobo.utils.ViewHolder;

/**
 * Created by 忧郁的眼神 on 2016/11/23 0023.
 */

public class LivePrevueAdapter extends BaseAdapter {
    private Context context;

    public LivePrevueAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_live_prevue, null);
        }
        TextView tv_date = ViewHolder.get(convertView, R.id.tv_date);
        TextView tv_time = ViewHolder.get(convertView, R.id.tv_time);
        TextView tv_title = ViewHolder.get(convertView, R.id.tv_title);

        return convertView;
    }
}
