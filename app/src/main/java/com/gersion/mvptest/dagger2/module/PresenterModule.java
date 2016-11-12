package com.gersion.mvptest.dagger2.module;

import com.gersion.mvptest.MainActivity;
import com.gersion.mvptest.presenter.Presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.mvptest.dagger2.module
 * @待完成
 * @创建时间 2016/11/12
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
@Module
public class PresenterModule {
    private MainActivity mActivity;

    public PresenterModule(MainActivity activity){
        mActivity = activity;
    }
    @Singleton //标记为单例
    @Provides //标记为此处可以提供一个Presenter实例
    Presenter providerPresenter(){
        return new Presenter(mActivity);
    }
}
