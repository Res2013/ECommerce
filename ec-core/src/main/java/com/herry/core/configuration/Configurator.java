package com.herry.core.configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Configurator {

    private static final HashMap<String, Object> CONFIGS = new LinkedHashMap<>();

    private Configurator() {}

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    HashMap<String, Object> getConfigs() {
        return CONFIGS;
    }

    @SuppressWarnings("unchecked")
    final <T> T geteConfiguration(Enum<ConfigType> configType) {
        return (T) CONFIGS.get(configType.name());
    }
}
