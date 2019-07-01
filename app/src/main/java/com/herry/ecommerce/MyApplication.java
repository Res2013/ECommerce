package com.herry.ecommerce;

import android.app.Application;

import com.herry.core.configuration.ConfigurationManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ConfigurationManager.init(this);
    }
}
