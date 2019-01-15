package com.lgmn.juhe.starter.service;

import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 实现类
 */
public class JuHe_IdCardQuery_SarterService {
    private static String idCardQueryUri = "http://op.juhe.cn/idcard/query";
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public JuHe_IdCardQuery_SarterService(String key) {
        this.key = key;
    }

    /**
     *实名认证
     * @param map 参数需要 idcard、realname 两个参数
     * @return
     */
    public String postJuHeIdcard(MultiValueMap<String, String> map) {
        map.add("key", key);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(idCardQueryUri, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }


}
