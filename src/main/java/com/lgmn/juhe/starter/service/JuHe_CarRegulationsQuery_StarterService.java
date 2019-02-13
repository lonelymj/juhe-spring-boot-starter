package com.lgmn.juhe.starter.service;

import com.alibaba.fastjson.JSONObject;
import com.lgmn.juhe.starter.utils.JuHePostUtil;
import org.springframework.util.MultiValueMap;

public class JuHe_CarRegulationsQuery_StarterService {

    private final static String CARREGULATIONS_QUERY_URI = "http://v.juhe.cn/sweizhang/query";

    private final static String CITYS_QUERY_URI = "http://v.juhe.cn/sweizhang/citys";

    private String carRegulationsKey;

    public String getCarRegulationsKey() {
        return carRegulationsKey;
    }

    public void setCarRegulationsKey(String carRegulationsKey) {
        this.carRegulationsKey = carRegulationsKey;
    }

    public JuHe_CarRegulationsQuery_StarterService(String carRegulationsKey) {
        this.carRegulationsKey = carRegulationsKey;
    }

    /**
     * 查询车辆违章信息;
     * map 包含信息如下：
     * 必传信息：
     * city （车牌所在地）城市代码
     * hphm 号牌号码 完整7位 ,需要utf8 urlencode*
     * <p>
     * 非必传信息：
     * dtype 返回数据格式：json或xml,默认json
     * callback 返回格式选择jsonp时，必须传递
     * hpzl 号牌类型,默认02:小型车,01:大型车,52:新能源小型车,51:新能源大型车
     * engineno 发动机号 (具体是否需要根据城市接口中的参数填写)
     * classno 车架号 (具体是否需要根据城市接口中的参数填写)
     * <p>
     * 详细接口文档地址：https://www.juhe.cn/docs/api/id/256
     *
     * @param map
     * @return
     */
    public JSONObject postJuHeCarRegulationsQuery(MultiValueMap<String, String> map) {
        map.add("key", carRegulationsKey);
        return JuHePostUtil.getPostAssemble(map, CARREGULATIONS_QUERY_URI);
    }

    /**
     * 获取城市需要必传的参数
     * map 包含信息如下：
     * 非必传：
     * province	默认全部，省份简写，如：ZJ、JS、GD
     * dtype	返回数据格式：json或xml,默认json
     * 详细接口文档：https://www.juhe.cn/docs/api/id/256
     * @param map
     * @return
     */
    public JSONObject postJuHeCarRegulationsCitysQuery(MultiValueMap<String, String> map) {
        map.add("key", carRegulationsKey);
        return JuHePostUtil.getPostAssemble(map, CITYS_QUERY_URI);
    }
}
