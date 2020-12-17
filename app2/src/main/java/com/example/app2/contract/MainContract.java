package com.example.app2.contract;

import com.example.app2.model.BannerBean;
import com.example.app2.utils.net.INetCallBack;

/**
 * @创建时间 2020/12/17 20:37
 */
public interface MainContract {
    interface IMainModel{
        //用于获取网络请求
       <B> void getLoginData(IMainPresenter iMainPresenter, String url,INetCallBack<B> callBack);
    }
    interface IMainPresenter{
        //用于传递网络请求
        void getBannerData();
    }
    interface IMainView{
        //用于使用网络请求返回回来的数据。
        void getBannerData(BannerBean bannerBean);
        void Error(String error);
    }
}
