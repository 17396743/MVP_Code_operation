package com.example.app2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.app2.R;
import com.example.app2.bean.BaseActivity;
import com.example.app2.contract.MainContract;
import com.example.app2.model.BannerBean;
import com.example.app2.presenter.MainPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainContract.IMainPresenter> implements MainContract.IMainView {


    private static final String TAG = ".MainActivity";
    private Banner banner;

    @Override
    protected void initView() {
        //设置控件ID
        banner = findViewById(R.id.banner);
    }

    @Override
    protected void initData() {
        //直接获取网络请求
//        presenter.getBannerData();
    }

    @Override
    protected int getLayoutID() {
        //设置布局页面
        return R.layout.activity_main;
    }

    @Override
    protected MainContract.IMainPresenter getLoginData() {
        //上下文注册
        return new MainPresenter(this);
    }


    @Override
    public void getBannerData(BannerBean bannerBean) {
        //使用数据
        List<BannerBean.DataBean> data = bannerBean.getData();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String title = data.get(i).getTitle();
            strings.add(title);
        }
        banner.setImages(data);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setBannerTitles(strings);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.DataBean bean = (BannerBean.DataBean) path;
                Glide.with(context).load(bean.getImage()).into(imageView);
            }
        }).start();
    }

    @Override
    public void Error(String error) {
        //获取网络报错信息
        Log.e(TAG,error);
    }

    public void btnset(View view) {
        //按钮点击获取网络请求
        presenter.getBannerData();
        //点击按钮后，隐藏按钮
        view.setAlpha(0);
    }
}