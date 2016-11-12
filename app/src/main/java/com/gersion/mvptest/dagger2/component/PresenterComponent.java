package com.gersion.mvptest.dagger2.component;

import com.gersion.mvptest.MainActivity;
import com.gersion.mvptest.dagger2.module.PresenterModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.mvptest.dagger2.component
 * @待完成
 * @创建时间 2016/11/12
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
@Singleton//@Provides 标记为单例，此处也必须加上@Singleton
@Component(modules = PresenterModule.class)//注入的桥梁，以哪个Module注入
public interface PresenterComponent {
    void inject(MainActivity activity);//此处不能写成 void inject(Activity activity); 切记，不然会出错
}
