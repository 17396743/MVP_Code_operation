package com.example.app2.utils.net;

/**
 * @创建时间 2020/12/17 20:45
 */
public interface INetWorkInterface {
    //设置一个整合网络链接和网络请求的接口
    public <B> void get(String url ,INetCallBack<B> callBack);
}
