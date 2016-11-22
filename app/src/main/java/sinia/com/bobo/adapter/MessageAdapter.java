package sinia.com.bobo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import sinia.com.bobo.R;
import sinia.com.bobo.utils.ViewHolder;

/**
 * Created by 忧郁的眼神 on 2016/11/21 0021.
 */

public class MessageAdapter extends BaseAdapter {
    private Context context;

    public MessageAdapter(Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_message, null);
        }
        TextView tv_title = ViewHolder.get(convertView, R.id.tv_title);
        TextView tv_time = ViewHolder.get(convertView, R.id.tv_time);
        return convertView;
    }
}
