package sinia.com.bobo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.activity.RechargeActivity;
import sinia.com.bobo.base.BaseFragment;

/**
 * Created by 忧郁的眼神 on 2016/11/29 0029.
 */

public class LiveChatFragment extends BaseFragment {
    @Bind(R.id.img_face)
    ImageView imgFace;
    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.img_gift)
    ImageView imgGift;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_chating, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @OnClick(R.id.img_recharge)
    public void onClick() {
        startActivityForNoIntent(RechargeActivity.class);
    }
}
