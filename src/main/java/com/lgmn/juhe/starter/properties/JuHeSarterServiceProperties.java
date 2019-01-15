package com.lgmn.juhe.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件类
 */
@ConfigurationProperties("juhe.service")
public class JuHeSarterServiceProperties {

    /**
     *  聚合key
     */
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
