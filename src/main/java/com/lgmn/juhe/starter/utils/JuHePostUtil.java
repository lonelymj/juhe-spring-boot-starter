package com.lgmn.juhe.starter.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class JuHePostUtil {

    /**
     * 发送 POST 请求并解析结果
     *
     * @param map 请求参数
     * @param uri 请求链接
     * @return
     */
    public static JSONObject getPostAssemble(MultiValueMap<String, String> map, String uri) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, httpHeaders);
        JSONObject jsonObject = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, JSONObject.class).getBody();
        return jsonObject;
    }

}
