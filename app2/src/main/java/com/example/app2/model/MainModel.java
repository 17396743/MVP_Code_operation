package com.example.app2.model;

import com.example.app2.contract.MainContract;
import com.example.app2.utils.net.INetCallBack;
import com.example.app2.utils.net.RetrofitUtils;

/**
 * @创建时间 2020/12/17 20:33
 */
public class MainModel implements MainContract.IMainModel {

    @Override
    public <B> void getLoginData(MainContract.IMainPresenter iMainPresenter, String url, INetCallBack<B> callBack) {
        //获取网络工具类
        RetrofitUtils.getInstance().get(url,callBack);
    }
}
