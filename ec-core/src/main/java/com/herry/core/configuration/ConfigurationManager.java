package com.herry.core.configuration;

import android.content.Context;

import java.util.HashMap;

/**
 * @author Herry
 */
public class ConfigurationManager {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getConfigs();
    }
}
