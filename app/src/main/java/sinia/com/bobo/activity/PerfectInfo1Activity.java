package sinia.com.bobo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sinia.com.bobo.R;
import sinia.com.bobo.actionsheetdialog.ActionSheetDialog;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.view.timeselector.TimeSelector;
import sinia.com.bobo.view.timeselector.Utils.DateUtil;

/**
 * Created by 忧郁的眼神 on 2016/11/29 0029.
 */

public class PerfectInfo1Activity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.tv_age)
    TextView tvAge;
    @Bind(R.id.tv_education)
    TextView tvEducation;
    @Bind(R.id.tv_expersince)
    TextView tvExpersince;
    @Bind(R.id.tv_only)
    TextView tvOnly;
    @Bind(R.id.tv_channel)
    TextView tvChannel;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_perfect_info);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @OnClick({R.id.tv_sex, R.id.tv_age, R.id.tv_education, R.id.tv_expersince, R.id.tv_only, R.id.tv_channel, R.id
            .tv_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sex:
                createSexDialog(this, tvSex);
                break;
            case R.id.tv_age:
                selectBirthday();
                break;
            case R.id.tv_education:
                createEducationDialog(this, tvEducation);
                break;
            case R.id.tv_expersince:
                createExperienceDialog(this, tvExpersince);
                break;
            case R.id.tv_only:
                createFullTimeDialog(this, tvOnly);
                break;
            case R.id.tv_channel:
                createChannelDialog(this, tvChannel);
                break;
            case R.id.tv_ok:
                startActivityForNoIntent(PerfectInfo2Activity.class);
                break;
        }
    }

    private void selectBirthday() {
        TimeSelector timeSelector = new TimeSelector(this, "请选择生日",
                new TimeSelector.ResultHandler() {

                    @Override
                    public void handle(String time) {
                        tvAge.setText(time);
                    }
                }, "1949-10-01", DateUtil.getCurYearAndMonth2());
        timeSelector.setScrollUnit(TimeSelector.SCROLLTYPE.YEAR,
                TimeSelector.SCROLLTYPE.MONTH, TimeSelector.SCROLLTYPE.DAY);
        timeSelector.show();
    }

    public void createSexDialog(Context context, final TextView tv) {
        new ActionSheetDialog(context)
                .builder()
                .setTitle("选择性别")
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("男", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("男");
                            }
                        })
                .addSheetItem("女", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("女");
                            }
                        }).show();
    }

    public void createExperienceDialog(Context context, final TextView tv) {
        new ActionSheetDialog(context)
                .builder()
                .setTitle("有无直播经验")
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("有", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("有");
                            }
                        })
                .addSheetItem("无", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("无");
                            }
                        }).show();
    }

    public void createFullTimeDialog(Context context, final TextView tv) {
        new ActionSheetDialog(context)
                .builder()
                .setTitle("是否专职")
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("专职", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("专职");
                            }
                        })
                .addSheetItem("否", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("否");
                            }
                        }).show();
    }

    public void createEducationDialog(Context context, final TextView tv) {
        new ActionSheetDialog(context)
                .builder()
                .setTitle("选择学历")
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("高中", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("高中");
                            }
                        })
                .addSheetItem("专科", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("专科");
                            }
                        })
                .addSheetItem("本科", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("本科");
                            }
                        })
                .addSheetItem("其他", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("其他");
                            }
                        }).show();
    }

    public void createChannelDialog(Context context, final TextView tv) {
        new ActionSheetDialog(context)
                .builder()
                .setTitle("选择直播频道")
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("生活", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("生活");
                            }
                        })
                .addSheetItem("娱乐", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("娱乐");
                            }
                        })
                .addSheetItem("游戏", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("游戏");
                            }
                        })
                .addSheetItem("其他", ActionSheetDialog.SheetItemColor.BLACK,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                tv.setText("其他");
                            }
                        }).show();
    }

    @Override
    protected boolean isOpenStatusBar() {
        return false;
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }
}
