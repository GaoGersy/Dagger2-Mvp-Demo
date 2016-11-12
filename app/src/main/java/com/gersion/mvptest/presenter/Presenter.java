package com.gersion.mvptest.presenter;

import android.os.Handler;
import android.util.Log;

import com.gersion.mvptest.bean.User;
import com.gersion.mvptest.model.ILoginModel;
import com.gersion.mvptest.model.LoginModel;
import com.gersion.mvptest.model.OnLoginListener;
import com.gersion.mvptest.view.ILoginView;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.mvptest.presenter
 * @待完成
 * @创建时间 2016/11/12
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */

//Model 和 View 完成交互的地方
public class Presenter {
    ILoginModel mLoginModel = new LoginModel();
    ILoginView mLoginView ;
    Handler mHandler = new Handler();
    public Presenter(ILoginView loginView){
        mLoginView = loginView;
        Log.d("aa",mLoginView.toString());
    }
    public void login(){
        mLoginView.showLoading();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("aa",mLoginView.getUserName());
                Log.d("aa",mLoginView.getPwd());
                mLoginModel.login(mLoginView.getUserName(), mLoginView.getPwd(), new OnLoginListener() {
                    @Override
                    public void onSuccess(final User user) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mLoginView.hideLoading();
                                mLoginView.onLoginSuccess();
                                mLoginView.toMainActivity(user);
                            }
                        });
                    }

                    @Override
                    public void onFailed() {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mLoginView.hideLoading();
                                mLoginView.onLoginFailed();
                            }
                        });
                    }
                });
            }
        }).start();

    }

    public void clearData(){
        mLoginView.clearUserName();
        mLoginView.clearPwd();
    }
}
