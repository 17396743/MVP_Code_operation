package com.example.app2.utils.net;

/**
 * @创建时间 2020/12/17 20:45
 */
public interface INetCallBack<B> {
    //设置在一个接口里面，有两个存储的接口供他人继承
    public void onBean(B b);
    public void onError(String error);
}
