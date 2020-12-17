package com.example.myapplication22.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication22.R;
import com.example.myapplication22.bean.BeanActivity;
import com.example.myapplication22.contract.MainContract;
import com.example.myapplication22.model.UserBean;
import com.example.myapplication22.presenter.MainPresenter;
import com.example.myapplication22.utils.net.INetCallBack;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BeanActivity<MainContract.iMainPresenter> implements MainContract.iMainView, View.OnClickListener {


    private static final String TAG = ".MainActivity";
    private EditText et_login;
    private EditText et_psd;
    private Banner banner;

    @Override
    protected void initView() {
        et_login = findViewById(R.id.et_login);
        et_psd = findViewById(R.id.et_psd);
        banner = findViewById(R.id.banner);

    }



    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected MainContract.iMainPresenter getLoginData() {
        return new MainPresenter(this);
    }

    @Override
    public String getlogin() {
        return et_login.getText().toString();
    }

    @Override
    public String getssende() {
        return et_psd.getText().toString();
    }

    @Override
    public void getLoginData(UserBean userBean) {
        //网络请求返回
        List<UserBean.DataBean> data = userBean.getData();
        banner.setImages(data);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String title = data.get(i).getTitle();
            titles.add(title);
        }
        banner.setBannerTitles(titles);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                UserBean.DataBean bean = (UserBean.DataBean) path;
                Glide.with(context).load(bean.getImage()).into(imageView);
            }
        }).start();

    }

     // 登录按钮


    public void btnset(View view) {
        if (!TextUtils.isEmpty(getlogin()) && !TextUtils.isEmpty(getssende())) {
            presenter.login(getlogin());
        }
    }


    @Override
    public void onClick(View v) {

    }
}