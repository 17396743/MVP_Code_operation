package com.example.myapplication22.contract;

/**
 * @创建时间 2020/12/17 17:44
 */
public interface  MainContract {
    interface iMainModel{
        void getloginData(iMainPresenter mainPresenter);
    }
    interface iMainPresenter{
        void login(String login);
        void ssende(String ssende);
    }
    interface iMainView{
        String getlogin();
        String getssende();
        void getloginData(String ssende);

    }
}
