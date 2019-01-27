package com.lgmn.juhe.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件类
 */
@ConfigurationProperties("juhe.service")
public class JuHeSarterServiceProperties {

    /**
     * 实名认证key
     */
    private String realNameKey;

    /**
     * 银行卡三元素key
     */
    private String bankCardKey;

    public String getRealNameKey() {
        return realNameKey;
    }

    public void setRealNameKey(String realNameKey) {
        this.realNameKey = realNameKey;
    }

    public String getBankCardKey() {
        return bankCardKey;
    }

    public void setBankCardKey(String bankCardKey) {
        this.bankCardKey = bankCardKey;
    }
}
