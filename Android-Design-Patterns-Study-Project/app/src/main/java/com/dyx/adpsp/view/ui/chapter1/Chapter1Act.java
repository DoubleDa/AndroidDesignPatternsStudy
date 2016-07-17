package com.dyx.adpsp.view.ui.chapter1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyx.adpsp.R;
import com.dyx.adpsp.constants.Constants;
import com.dyx.adpsp.models.chapter1.Room;
import com.dyx.adpsp.models.chapter1.Tenement;
import com.dyx.adpsp.mylibrary.chapter1.ImageLoader;
import com.dyx.adpsp.mylibrary.chapter1.MemoryDiskCache;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/16 下午10:56
 * alter person：dayongxin
 * alter time：16/7/16 下午10:56
 * alter remark：
 */
public class Chapter1Act extends Activity {
    @Bind(R.id.iv_test)
    ImageView ivTest;
    @Bind(R.id.et_price)
    EditText etPrice;
    @Bind(R.id.et_area)
    EditText etArea;
    @Bind(R.id.but_calculate)
    Button butCalculate;
    @Bind(R.id.tv_show_result)
    TextView tvShowResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //获取ImageLoader对象
        ImageLoader mImageLoader = new ImageLoader();
        /**
         * 设置缓存
         */
        //内存缓存
        //mImageLoader.setImageCache(new MemoryCache());
        //SD缓存
        //mImageLoader.setImageCache(new DiskCache());
        //二级缓存
        mImageLoader.setImageCache(new MemoryDiskCache());
        mImageLoader.displayImage(Constants.URL_TEST_IMG, ivTest);
    }

    @OnClick(R.id.but_calculate)
    public void onClick() {
        String price = etPrice.getText().toString().trim();
        String area = etArea.getText().toString().trim();
        if (tvShowResult != null) {
            tvShowResult.setText("");
        }
        if (!price.equals("") && !area.equals("")) {
            Room room = Tenement.rentRoom(Float.valueOf(area), Float.valueOf(price));
            if (room != null) {
                tvShowResult.setText("面积：" + room.getRoomArea() + "\n" + "价格：" + room.getRoomPrice());
            } else {
                tvShowResult.setText(getString(R.string.tv_no_result));
            }
        }
    }
}
