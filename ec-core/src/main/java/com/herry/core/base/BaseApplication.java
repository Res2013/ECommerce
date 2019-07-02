package com.herry.core.base;

import android.app.Application;
import android.content.Context;

import com.herry.core.common.ActivityManage;

public class BaseApplication extends Application {

    //全局唯一的context
    private static BaseApplication application;

    //Activity管理器
    private ActivityManage activityManage;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        activityManage = new ActivityManage();
        initARouter();
        initLogger();
        initCrashManage();
    }

    /**
     * 初始化崩溃管理器
     */
    private void initCrashManage() {

    }


    /**
     * 初始化日志打印框架
     */
    private void initLogger() {

    }

    /**
     * 初始化路由
     */
    private void initARouter() {

    }

    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        exitApp();
    }

    /**
     * 获取全局唯一上下文
     *
     * @return BaseApplication
     */
    public static BaseApplication getApplication() {
        return application;
    }


    /**
     * 退出应用
     */
    public void exitApp() {
        activityManage.finishAll();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * 返回Activity管理器
     */
    public ActivityManage getActivityManage() {
        if (activityManage == null) {
            activityManage = new ActivityManage();
        }
        return activityManage;
    }
}
