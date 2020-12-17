package com.example.myapplication22.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication22.R;
import com.example.myapplication22.bean.BeanActivity;
import com.example.myapplication22.contract.MainContract;
import com.example.myapplication22.presenter.MainPresenter;

public class MainActivity extends BeanActivity<MainContract.iMainPresenter> implements MainContract.iMainView {


    private static final String TAG = ".MainActivity" ;
    private EditText et_login;
    private EditText et_psd;

    @Override
    protected void initView() {
        et_login = findViewById(R.id.et_login);
        et_psd = findViewById(R.id.et_psd);
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
    public void getloginData(String ssende) {
        Log.d(TAG,ssende);
    }

    public void btnset(View view) {
        if (!TextUtils.isEmpty(getlogin())&&!TextUtils.isEmpty(getssende())){
            presenter.login(getlogin());
        }
    }
}