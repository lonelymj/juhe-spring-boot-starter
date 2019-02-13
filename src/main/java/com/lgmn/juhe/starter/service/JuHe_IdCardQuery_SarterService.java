package com.lgmn.juhe.starter.service;

import com.alibaba.fastjson.JSONObject;
import com.lgmn.juhe.starter.utils.JuHePostUtil;
import org.springframework.util.MultiValueMap;

/**
 * 实现类
 */
public class JuHe_IdCardQuery_SarterService {

    private final static String IDCARD_QUERY_URI = "http://op.juhe.cn/idcard/query";

    /**
     * 实名认证key
     */
    private String realNameKey;

    public String getRealNameKey() {
        return realNameKey;
    }

    public void setRealNameKey(String realNameKey) {
        this.realNameKey = realNameKey;
    }

    /**
     * 实名认证
     *
     * @param realNameKey
     */
    public JuHe_IdCardQuery_SarterService(String realNameKey) {
        this.realNameKey = realNameKey;
    }

    /**
     * 实名认证
     *
     * @param map 参数需要 idcard、realname 两个参数
     * @return
     */
    public JSONObject postJuHeIdcard(MultiValueMap<String, String> map) {
        map.add("key", realNameKey);
        return JuHePostUtil.getPostAssemble(map, IDCARD_QUERY_URI);
    }

}
