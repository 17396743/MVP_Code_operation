package com.example.myapplication22.utils.net;

/**
 * @创建时间 2020/12/17 19:00
 */
public interface INetCallBack<T> {
    public void success(T t);

    public void onFall(String error);

}
