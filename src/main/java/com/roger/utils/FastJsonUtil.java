package com.roger.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;

public class FastJsonUtil {

    public static JSONObject map2JsonObject(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return new JSONObject();
        }
        String jsonString = JSON.toJSONString(map);
        return JSONObject.parseObject(jsonString);
    }

    public static JSONArray listMap2JsonArray(List<Map<String,Object>> listMap) {
        if(CollectionUtils.isEmpty(listMap)){
            return new JSONArray();
        }
        String jsonString = JSON.toJSONString(listMap);
        return JSONArray.parseArray(jsonString);
    }

}