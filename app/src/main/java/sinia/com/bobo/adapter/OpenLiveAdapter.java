package sinia.com.bobo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zcw.togglebutton.ToggleButton;

import sinia.com.bobo.R;
import sinia.com.bobo.utils.ViewHolder;

/**
 * Created by 忧郁的眼神 on 2016/11/23 0023.
 */

public class OpenLiveAdapter extends BaseAdapter {
    private Context context;

    public OpenLiveAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_openlive_alert, null);
        }
        TextView tv_type = ViewHolder.get(convertView, R.id.tv_type);
        TextView tv_name = ViewHolder.get(convertView, R.id.tv_name);
        ImageView img_head = ViewHolder.get(convertView, R.id.img_head);
        ToggleButton tgb_fee = ViewHolder.get(convertView, R.id.tgb_fee);
        return convertView;
    }
}
