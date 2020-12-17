package com.example.myapplication22.presenter;

import android.util.Log;

import com.example.myapplication22.contract.MainContract;
import com.example.myapplication22.model.MainModel;
import com.example.myapplication22.model.UserBean;
import com.example.myapplication22.utils.net.INetCallBack;
import com.example.myapplication22.utils.net.URLConstant;

/**
 * @创建时间 2020/12/17 17:45
 */
public class MainPresenter implements MainContract.iMainPresenter {
    private MainContract.iMainView mainView;
    private MainContract.iMainModel mainModel;

    public MainPresenter(MainContract.iMainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModel();
    }
    //        URL就在P层确定,不要从Activity中传递过来
    @Override
    public void login(String login) {
        mainModel.getloginData(this, URLConstant.NEWLIST,new INetCallBack<UserBean>() {
            @Override
            public void success(UserBean userBean) {
                mainView.getLoginData(userBean);
            }

            @Override
            public void onFall(String error) {

            }
        });
    }

    @Override
    public void ssende(String ssende) {
        Log.i("tag",ssende);
    }
}
