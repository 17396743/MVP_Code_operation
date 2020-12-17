package com.example.myapplication22.contract;

import com.example.myapplication22.model.UserBean;
import com.example.myapplication22.utils.net.INetCallBack;

/**
 * @创建时间 2020/12/17 17:44
 */
public interface MainContract {
    interface iMainModel {
       <T> void getloginData(iMainPresenter mainPresenter,String url, INetCallBack<T> iNetCallBack);
    }

    interface iMainPresenter {
        void login(String login);

        void ssende(String ssende);
    }

    interface iMainView {
        String getlogin();

        String getssende();

        void getLoginData(UserBean userBean);

    }
}
