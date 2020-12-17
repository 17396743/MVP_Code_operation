package com.example.myapplication22.utils.net;

import java.util.HashMap;

/**
 * @创建时间 2020/12/17 18:47
 */
public interface INetWorkInterface {

    public void get(String url);

    public void post(String url);

    public void post(String url, HashMap<String, String> map);

}
