package sinia.com.bobo.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.utils.DataCleanManager;

import static java.util.ResourceBundle.clearCache;

/**
 * Created by 忧郁的眼神 on 2016/11/22 0022.
 */

public class SettingsActivity extends BaseActivity {

    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.seekbar_textsize)
    AppCompatSeekBar seekbarTextsize;
    @Bind(R.id.tv_textsize)
    TextView tvTextsize;
    @Bind(R.id.seekbar_alpha)
    AppCompatSeekBar seekbarAlpha;
    @Bind(R.id.tv_alpha)
    TextView tvAlpha;
    @Bind(R.id.tv_top)
    TextView tvTop;
    @Bind(R.id.tv_full)
    TextView tvFull;
    @Bind(R.id.tv_bottom)
    TextView tvBottom;
    @Bind(R.id.tv_cache)
    TextView tvCache;
    @Bind(R.id.img_top)
    ImageView imgTop;
    @Bind(R.id.img_full)
    ImageView imgFull;
    @Bind(R.id.img_bottom)
    ImageView imgBottom;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_settings);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initData();
    }

    private void initData() {
        tvCache.setText(DataCleanManager.getTotalCacheSize(this));
        seekbarTextsize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvTextsize.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        seekbarAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAlpha.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @OnClick({R.id.ll_top, R.id.ll_full, R.id.ll_bottom, R.id.rl_clear, R.id.rl_about, R.id.rl_feedback})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_top:
                tvTop.setSelected(true);
                imgTop.setSelected(true);
                tvBottom.setSelected(false);
                imgBottom.setSelected(false);
                tvFull.setSelected(false);
                imgFull.setSelected(false);
                break;
            case R.id.ll_full:
                tvTop.setSelected(false);
                imgTop.setSelected(false);
                tvBottom.setSelected(false);
                imgBottom.setSelected(false);
                tvFull.setSelected(true);
                imgFull.setSelected(true);
                break;
            case R.id.ll_bottom:
                tvTop.setSelected(false);
                imgTop.setSelected(false);
                tvBottom.setSelected(true);
                imgBottom.setSelected(true);
                tvFull.setSelected(false);
                imgFull.setSelected(false);
                break;
            case R.id.rl_clear:
                clearTempCache();
                break;
            case R.id.rl_about:
                startActivityForNoIntent(AboutUsActivity.class);
                break;
            case R.id.rl_feedback:
                startActivityForNoIntent(FeedBackActivity.class);
                break;
        }
    }

    private void clearTempCache() {
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("提示").setMessage("缓存数据清理后将无法恢复，您确定要清理吗？")
                .setPositiveButton
                        ("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                showToast("清理了缓存" + DataCleanManager
                                        .getTotalCacheSize(SettingsActivity.this));
                                DataCleanManager.clearAllCache(SettingsActivity.this);
                                tvCache.setText(DataCleanManager
                                        .getTotalCacheSize(SettingsActivity.this));
                                dialog.dismiss();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }
}
