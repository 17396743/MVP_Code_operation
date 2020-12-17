package com.example.app2.contract;

import com.example.app2.model.BannerBean;
import com.example.app2.utils.net.INetCallBack;

/**
 * @创建时间 2020/12/17 20:37
 */
public interface MainContract {
    interface IMainModel{
       <B> void getLoginData(IMainPresenter iMainPresenter, String url,INetCallBack<B> callBack);
    }
    interface IMainPresenter{
        void getBannerData();
    }
    interface IMainView{
        void getBannerData(BannerBean bannerBean);
        void Error(String error);
    }
}
