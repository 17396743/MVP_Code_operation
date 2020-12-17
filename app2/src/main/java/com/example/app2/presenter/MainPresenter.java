package com.example.app2.presenter;

import com.example.app2.contract.MainContract;
import com.example.app2.model.BannerBean;
import com.example.app2.model.MainModel;
import com.example.app2.utils.net.INetCallBack;
import com.example.app2.utils.net.URLConstant;

/**
 * @创建时间 2020/12/17 20:33
 */
public class MainPresenter implements MainContract.IMainPresenter {
    private MainContract.IMainView mainView;
    private MainContract.IMainModel mainModel;

    public MainPresenter(MainContract.IMainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModel();
    }
    //        URL就在P层确定,不要从Activity中传递过来
    @Override
    public void getBannerData() {
        mainModel.getLoginData(this, URLConstant.NEWURL, new INetCallBack<BannerBean>() {
            @Override
            public void onBean(BannerBean bannerBean) {
                //获取网络请求
                mainView.getBannerData(bannerBean);
            }

            @Override
            public void onError(String error) {
                mainView.Error(error);
            }
        });
    }
}
