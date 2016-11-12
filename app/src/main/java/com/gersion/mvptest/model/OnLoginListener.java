package com.gersion.mvptest.model;

import com.gersion.mvptest.bean.User;

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
public interface OnLoginListener {
    void onSuccess(User user);
    void onFailed();
}
