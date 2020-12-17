package com.example.app2.bean;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @创建时间 2020/12/17 20:32
 */
public abstract class BaseActivity<B> extends AppCompatActivity {
    public B presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if (presenter == null){
            presenter = getLoginData();
        }
        initView();
        initData();
    }
    protected abstract  void initView();
    protected abstract  void initData();
    protected abstract  int getLayoutID();
    protected abstract B getLoginData();
}
