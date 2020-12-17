package com.example.app2.utils.net;

/**
 * @创建时间 2020/12/17 20:45
 */
public interface INetWorkInterface {
    public <B> void get(String url ,INetCallBack<B> callBack);
}
