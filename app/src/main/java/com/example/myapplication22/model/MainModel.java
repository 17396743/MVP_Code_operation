package com.example.myapplication22.model;

import com.example.myapplication22.contract.MainContract;
import com.example.myapplication22.utils.net.RetrofitUtils;

/**
 * @创建时间 2020/12/17 17:44
 */
public class MainModel implements MainContract.iMainModel {
    @Override
    public void getloginData(MainContract.iMainPresenter mainPresenter) {
        mainPresenter.ssende("登录成功！");

        RetrofitUtils.getInstance().get("");


    }
}
