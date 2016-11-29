package sinia.com.bobo.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.UploadFileListener;
import sinia.com.bobo.R;
import sinia.com.bobo.actionsheetdialog.ActionSheetDialog;
import sinia.com.bobo.base.BaseActivity;
import sinia.com.bobo.utils.Constants;

/**
 * Created by 忧郁的眼神 on 2016/11/29 0029.
 */

public class PerfectInfo2Activity extends BaseActivity {
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.et_idcard)
    EditText etIdcard;
    @Bind(R.id.img_idcard)
    ImageView imgIdcard;
    @Bind(R.id.img1)
    ImageView img1;
    @Bind(R.id.img2)
    ImageView img2;
    @Bind(R.id.img3)
    ImageView img3;

    private String imgPath0, imgPath1, imgPath2, imgPath3;
    private String imageCard = "-1", image1 = "-1", image2 = "-1", image3 = "-1", imgUrl;
    private int imgtype;//第几个图片

    @Override
    protected void initView() {
        setContentView(R.layout.activity_perfect_info_2);
        Bmob.initialize(this, Constants.BMOB_KEY);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected boolean isOpenStatusBar() {
        return false;
    }

    @Override
    protected boolean isSlideFinish() {
        return true;
    }

    @OnClick({R.id.img_idcard, R.id.img1, R.id.img2, R.id.img3, R.id.tv_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_idcard:
                imgtype = 0;
                selectHeadImage();
                break;
            case R.id.img1:
                imgtype = 1;
                selectHeadImage();
                break;
            case R.id.img2:
                imgtype = 2;
                selectHeadImage();
                break;
            case R.id.img3:
                imgtype = 3;
                selectHeadImage();
                break;
            case R.id.tv_ok:
                break;
        }
    }

    private void selectHeadImage() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(PerfectInfo2Activity.this,
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
                                if (ContextCompat.checkSelfPermission(PerfectInfo2Activity.this,
                                        Manifest.permission
                                                .CAMERA) != PackageManager.PERMISSION_GRANTED) {
                                    ActivityCompat.requestPermissions(PerfectInfo2Activity.this, new String[]{Manifest
                                                    .permission.CAMERA},
                                            1);
                                } else {
                                    //从相机拍取照片不裁剪
                                    getTakePhoto().onEnableCompress(compressConfig, true).onPickFromCapture(imageUri);
                                    //从相机拍取照片进行裁剪
//                                    getTakePhoto().onEnableCompress(compressConfig, true).onPickFromCaptureWithCrop
//                                            (imageUri, cropOptions);
                                }
                            }
                        })
                .addSheetItem("从手机相册选择", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                //从相册选择照片不裁切
                                getTakePhoto().onEnableCompress(compressConfig, true).onPickFromGallery();
                                //从相册选择照片进行裁剪
//                                getTakePhoto().onEnableCompress(compressConfig, true).onPickFromGalleryWithCrop
//                                        (imageUri, cropOptions);
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
                    imgUrl = file.getFileUrl(PerfectInfo2Activity.this);
                    // showToast("图片上传成功");
                    if (imgtype == 0) {
                        imageCard = imgUrl;
                    }
                    if (imgtype == 1) {
                        image1 = imgUrl;
                    }
                    if (imgtype == 2) {
                        image2 = imgUrl;
                    }
                    if (imgtype == 3) {
                        image3 = imgUrl;
                    }
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
        if (imgtype == 0) {
            imgPath0 = imagePath;
            imgIdcard.setImageBitmap(bitmap);
        }
        if (imgtype == 1) {
            imgPath1 = imagePath;
            img1.setImageBitmap(bitmap);
        }
        if (imgtype == 2) {
            imgPath2 = imagePath;
            img2.setImageBitmap(bitmap);
        }
        if (imgtype == 3) {
            imgPath3 = imagePath;
            img3.setImageBitmap(bitmap);
        }
    }
}
