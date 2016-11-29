package sinia.com.bobo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zcw.togglebutton.ToggleButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseFragment;
import sinia.com.bobo.view.CircleImageView;

/**
 * Created by 忧郁的眼神 on 2016/11/29 0029.
 */

public class LiverDetailFragment extends BaseFragment {
    @Bind(R.id.img_head)
    CircleImageView imgHead;
    @Bind(R.id.tv_room)
    TextView tvRoom;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_category)
    TextView tvCategory;
    @Bind(R.id.tgb_fee)
    ToggleButton tgbFee;
    @Bind(R.id.tv_content)
    TextView tvContent;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_liver_detail, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
