package com.example.myapplication22.utils.net;

import java.util.HashMap;

/**
 * @创建时间 2020/12/17 18:47
 */
public interface INetWorkInterface {

    public <T> void get(String url, INetCallBack<T> callBack);

    public <T> void post(String url, INetCallBack<T> callBack);

    public <T> void post(String url, HashMap<String, String> map, INetCallBack<T> callBack);

}
