package com.lgmn.juhe.starter.service;

import com.alibaba.fastjson.JSONObject;
import com.lgmn.juhe.starter.utils.JuHePostUtil;
import org.springframework.util.MultiValueMap;

public class JuHe_BankCard_SarterService {

    private final static String BANKCARD_QUERY_URI = "http://v.juhe.cn/verifybankcard4/query";

    /**
     * 银行卡三元素key
     */
    private String bankCardKey;

    public String getBankCardKey() {
        return bankCardKey;
    }

    public void setBankCardKey(String bankCardKey) {
        this.bankCardKey = bankCardKey;
    }

    public JuHe_BankCard_SarterService(String bankCardKey) {
        this.bankCardKey = bankCardKey;
    }

    /**
     * 银行卡三元素校验
     *
     * @param map 参数需要 realname、idcard、bankcard 三个参数
     * @return
     */
    public JSONObject postJuHeBankCard(MultiValueMap<String, String> map) {
        map.add("key", bankCardKey);
        return JuHePostUtil.getPostAssemble(map, BANKCARD_QUERY_URI);
    }

}
