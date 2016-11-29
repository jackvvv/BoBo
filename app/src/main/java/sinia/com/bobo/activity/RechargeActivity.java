package sinia.com.bobo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;

/**
 * Created by 忧郁的眼神 on 2016/11/24 0024.
 */

public class RechargeActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.tv_account)
    TextView tvAccount;
    @Bind(R.id.tv_remain)
    TextView tvRemain;
    @Bind(R.id.tv_ratio)
    TextView tvRatio;
    @Bind(R.id.tv_bobi1)
    TextView tvBobi1;
    @Bind(R.id.tv_1)
    TextView tv_1;
    @Bind(R.id.tv_bobi10)
    TextView tvBobi10;
    @Bind(R.id.tv_10)
    TextView tv_10;
    @Bind(R.id.tv_bobi20)
    TextView tvBobi20;
    @Bind(R.id.tv_20)
    TextView tv_20;
    @Bind(R.id.tv_bobi30)
    TextView tvBobi30;
    @Bind(R.id.tv_30)
    TextView tv_30;
    @Bind(R.id.tv_bobi50)
    TextView tvBobi50;
    @Bind(R.id.tv_50)
    TextView tv_50;
    @Bind(R.id.tv_bobi100)
    TextView tvBobi100;
    @Bind(R.id.tv_100)
    TextView tv_100;
    @Bind(R.id.tv_expersince)
    TextView tvExpersince;
    @Bind(R.id.ll_1)
    LinearLayout ll_1;
    @Bind(R.id.ll_10)
    LinearLayout ll_10;
    @Bind(R.id.ll_20)
    LinearLayout ll_20;
    @Bind(R.id.ll_30)
    LinearLayout ll_30;
    @Bind(R.id.ll_50)
    LinearLayout ll_50;
    @Bind(R.id.ll_100)
    LinearLayout ll_100;
    private Dialog dialog;
    private String payType;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_recharge);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initData();
    }

    private void initData() {
    }

    @OnClick({R.id.ll_1, R.id.ll_10, R.id.ll_20, R.id.ll_30, R.id.ll_50, R.id.ll_100, R.id.tv_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_1:
                setSelected(true, true, true, false, false, false, false, false, false, false, false, false, false,
                        false, false, false, false, false);
                break;
            case R.id.ll_10:
                setSelected(false, false, false, true, true, true, false, false, false, false, false, false, false,
                        false, false, false, false, false);
                break;
            case R.id.ll_20:
                setSelected(false, false, false, false, false, false, true, true, true, false, false, false, false,
                        false, false, false, false, false);
                break;
            case R.id.ll_30:
                setSelected(false, false, false, false, false, false, false, false, false, true, true, true, false,
                        false, false, false, false, false);
                break;
            case R.id.ll_50:
                setSelected(false, false, false, false, false, false, false, false, false, false, false, false, true,
                        true, true, false, false, false);
                break;
            case R.id.ll_100:
                setSelected(false, false, false, false, false, false, false, false, false, false, false, false, false,
                        false, false, true, true, true);
                break;
            case R.id.tv_pay:
                createPayTypeDialog(this);
                break;
        }
    }

    private void setSelected(boolean ll1, boolean tvb1, boolean tv1,
                             boolean ll10, boolean tvb10, boolean tv10,
                             boolean ll20, boolean tvb20, boolean tv20,
                             boolean ll30, boolean tvb30, boolean tv30,
                             boolean ll50, boolean tvb50, boolean tv50,
                             boolean ll100, boolean tvb100, boolean tv100) {
        ll_1.setSelected(ll1);
        tvBobi1.setSelected(tvb1);
        tv_1.setSelected(tv1);

        ll_10.setSelected(ll10);
        tvBobi10.setSelected(tvb10);
        tv_10.setSelected(tv10);

        ll_20.setSelected(ll20);
        tvBobi20.setSelected(tvb20);
        tv_20.setSelected(tv20);

        ll_30.setSelected(ll30);
        tvBobi30.setSelected(tvb30);
        tv_30.setSelected(tv30);

        ll_50.setSelected(ll50);
        tvBobi50.setSelected(tvb50);
        tv_50.setSelected(tv50);

        ll_100.setSelected(ll100);
        tvBobi100.setSelected(tvb100);
        tv_100.setSelected(tv100);
    }

    public Dialog createPayTypeDialog(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_select_pay_type, null);
        dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        dialog.show();
        dialog.setContentView(v, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = (display.getWidth()); // 设置宽度
//        lp.height = display.getHeight() / 2;
        dialog.getWindow().setAttributes(lp);
        TextView tv_cancle = (TextView) v.findViewById(R.id.tv_cancle);
        TextView tv_alipay = (TextView) v.findViewById(R.id.tv_alipay);
        TextView tv_wx = (TextView) v.findViewById(R.id.tv_wx);
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tv_alipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payType = "1";
                dialog.dismiss();
            }
        });
        tv_wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payType = "2";
                dialog.dismiss();
            }
        });
        return dialog;
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }
}
