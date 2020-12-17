package com.example.myapplication22.model;

import com.example.myapplication22.contract.MainContract;
import com.example.myapplication22.utils.net.INetCallBack;
import com.example.myapplication22.utils.net.RetrofitUtils;

/**
 * @创建时间 2020/12/17 17:44
 */
public class MainModel implements MainContract.iMainModel {

    @Override
    public <T> void getloginData(MainContract.iMainPresenter mainPresenter, String url, INetCallBack<T> iNetCallBack) {
//        这一行只是测试MVP用的,现在用接口回调了,用不上了
        mainPresenter.ssende("登录成功！");
//        网络请求
        RetrofitUtils.getInstance().get(url,iNetCallBack);
    }
}
