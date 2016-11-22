package sinia.com.bobo.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;

import java.io.File;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.UploadFileListener;
import sinia.com.bobo.R;
import sinia.com.bobo.actionsheetdialog.ActionSheetDialog;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.utils.Constants;
import sinia.com.bobo.view.CircleImageView;

/**
 * Created by 忧郁的眼神 on 2016/11/21 0021.
 */

public class PersonalActivity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.img_head)
    CircleImageView imgHead;
    @Bind(R.id.tv_real)
    TextView tvReal;
    @Bind(R.id.tv_email)
    TextView tvEmail;
    @Bind(R.id.tv_tel)
    TextView tvTel;
    @Bind(R.id.tv_qq)
    TextView tvQq;
    @Bind(R.id.tv_level)
    TextView tvLevel;

    private String imgPath, imgUrl;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_personal_center);
        Bmob.initialize(this, Constants.BMOB_KEY);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }

    @OnClick({R.id.img_head, R.id.rl_name, R.id.rl_real, R.id.rl_email, R.id.rl_tel, R.id.rl_qq, R.id
            .rl_level, R.id.tv_logout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_head:
                selectHeadImage();
                break;
            case R.id.rl_name:
                startActivityForNoIntent(ChangeNickNameActivity.class);
                break;
            case R.id.rl_real:
                break;
            case R.id.rl_email:
                break;
            case R.id.rl_tel:
                break;
            case R.id.rl_qq:
                break;
            case R.id.rl_level:
                break;
            case R.id.tv_logout:
                logout();
                break;
        }
    }

    private void selectHeadImage() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(PersonalActivity.this,
                Manifest.permission
                        .CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest
                            .permission.CAMERA},
                    1);
        }
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        final Uri imageUri = Uri.fromFile(file);
        final CompressConfig compressConfig = new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(800)
                .create();
        final CropOptions cropOptions = new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(true)
                .create();
        new ActionSheetDialog(this)
                .builder()
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("拍照选择", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                //从相机拍取照片不裁剪
//                                getTakePhoto().onEnableCompress(compressConfig, true).onPickFromCapture(imageUri);
                                //从相机拍取照片进行裁剪
                                if (ContextCompat.checkSelfPermission(PersonalActivity.this,
                                        Manifest.permission
                                                .CAMERA) != PackageManager.PERMISSION_GRANTED) {
                                    ActivityCompat.requestPermissions(PersonalActivity.this, new String[]{Manifest
                                                    .permission.CAMERA},
                                            1);
                                } else {
                                    getTakePhoto().onEnableCompress(compressConfig, true).onPickFromCaptureWithCrop
                                            (imageUri, cropOptions);
                                }
                            }
                        })
                .addSheetItem("从手机相册选择", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                //从相册选择照片不裁切
//                                getTakePhoto().onEnableCompress(compressConfig, true).onPickFromGallery();
                                //从相册选择照片进行裁剪
                                getTakePhoto().onEnableCompress(compressConfig, true).onPickFromGalleryWithCrop
                                        (imageUri, cropOptions);
                            }
                        }).show();
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    @Override
    public void takeFail(String msg) {
        super.takeFail(msg);
    }

    @Override
    public void takeSuccess(String imagePath) {
        super.takeSuccess(imagePath);
        showImg(imagePath);
        uploadImage(imagePath);
    }

    private void uploadImage(String avataPath) {
        if (avataPath != null) {
            showLoad("正在上传头像");
            final BmobFile file = new BmobFile(new File(avataPath));
            file.upload(this, new UploadFileListener() {

                @Override
                public void onSuccess() {
                    dismiss();
                    imgUrl = file.getFileUrl(PersonalActivity.this);
                    // showToast("图片上传成功");
                }

                @Override
                public void onFailure(int arg0, String arg1) {
                    Log.i("tag", "图片上传失败" + arg1);
                    dismiss();
                }
            });
        }
    }

    private void showImg(String imagePath) {
        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inSampleSize = 2;
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath, option);
        imgPath = imagePath;
        imgHead.setImageBitmap(bitmap);
    }

    private void logout() {
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("提示").setMessage("确定退出此账号？").setPositiveButton
                ("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startLoginActivityForNoIntent(LoginActivity.class);
                        onBackPressed();
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
}
