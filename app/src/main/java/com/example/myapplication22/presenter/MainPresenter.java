package com.example.myapplication22.presenter;

import com.example.myapplication22.contract.MainContract;
import com.example.myapplication22.model.MainModel;

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

    @Override
    public void login(String login) {
        mainModel.getloginData(this);
    }

    @Override
    public void ssende(String ssende) {
        mainView.getloginData(ssende);
    }
}
