package com.gersion.mvptest.model;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.mvptest.model
 * @待完成
 * @创建时间 2016/11/12
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public interface ILoginModel {
    void login(String userName,String pwd,OnLoginListener listener);
}
