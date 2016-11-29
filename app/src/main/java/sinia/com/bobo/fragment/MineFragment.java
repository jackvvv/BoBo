package sinia.com.bobo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.allenliu.badgeview.BadgeFactory;
import com.allenliu.badgeview.BadgeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.activity.AttentionManagerActivity;
import sinia.com.bobo.activity.LookHistoryActivity;
import sinia.com.bobo.activity.MessageActivity;
import sinia.com.bobo.activity.OpenLiveAlertActivity;
import sinia.com.bobo.activity.PersonalActivity;
import sinia.com.bobo.activity.RechargeActivity;
import sinia.com.bobo.activity.SettingsActivity;
import sinia.com.bobo.activity.StartLiveActivity;
import sinia.com.bobo.activity.StopLiveActivity;
import sinia.com.bobo.base.BaseFragment;
import sinia.com.bobo.utils.BlurBehind;
import sinia.com.bobo.utils.OnBlurCompleteListener;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public class MineFragment extends BaseFragment {
    @Bind(R.id.tv_sign)
    TextView tvSign;
    @Bind(R.id.tv_signcoin)
    TextView tvSigncoin;
    @Bind(R.id.img_head)
    ImageView imgHead;
    @Bind(R.id.img_msg)
    ImageView imgMsg;
    @Bind(R.id.tv_nickname)
    TextView tvNickname;
    @Bind(R.id.tv_level)
    TextView tvLevel;
    @Bind(R.id.pb_level)
    ProgressBar pbLevel;
    @Bind(R.id.tv_coin)
    TextView tvCoin;
    @Bind(R.id.tv_guagua)
    TextView tvGuagua;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        BadgeFactory.create(getActivity())
                .setTextColor(Color.WHITE)
                .setWidthAndHeight(10, 10)
                .setBadgeBackground(Color.RED)
                .setTextSize(10)
                .setBadgeGravity(Gravity.RIGHT | Gravity.TOP)
                .setBadgeCount(2)
                .setShape(BadgeView.SHAPE_CIRCLE)
                .bind(imgMsg);
    }

    @OnClick({R.id.fab_live, R.id.rl_sign, R.id.img_msg, R.id.tv_history, R.id.tv_attention_manager, R.id.tv_task, R
            .id.tv_recharge, R.id.tv_alert, R.id.tv_settings, R.id.rl_personal})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_live:
                BlurBehind.getInstance().execute(getActivity(), new OnBlurCompleteListener() {
                    @Override
                    public void onBlurComplete() {
                        startLoginActivityForNoIntent(StopLiveActivity.class);
                    }
                });
                break;
            case R.id.rl_sign:
                break;
            case R.id.img_msg:
                startActivityForNoIntent(MessageActivity.class);
                break;
            case R.id.tv_history:
                startActivityForNoIntent(LookHistoryActivity.class);
                break;
            case R.id.tv_attention_manager:
                startActivityForNoIntent(AttentionManagerActivity.class);
                break;
            case R.id.tv_task:
                break;
            case R.id.tv_recharge:
                startActivityForNoIntent(RechargeActivity.class);
                break;
            case R.id.tv_alert:
                startActivityForNoIntent(OpenLiveAlertActivity.class);
                break;
            case R.id.tv_settings:
                startActivityForNoIntent(SettingsActivity.class);
                break;
            case R.id.rl_personal:
                startActivityForNoIntent(PersonalActivity.class);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
