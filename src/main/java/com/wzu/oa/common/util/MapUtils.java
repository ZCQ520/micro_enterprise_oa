package com.wzu.oa.common.util;


import java.util.HashMap;
import java.util.Map;

/**
 * 描述：Map工具类
 * 创建人：yoan
 * 创建日期：17/8/15
 */
public class MapUtils {
    private Map<String, Object> map = new HashMap();


    public static MapUtils build() {
        return new MapUtils();
    }

    public MapUtils put(String key, Object val) {
        this.map.put(key, val);
        return this;
    }

    public MapUtils remove(String key) {
        this.map.remove(key);
        return this;
    }

    public MapUtils clear() {
        this.map.clear();
        return this;
    }

    public MapUtils setMap(Map<String, Object> map) {
        this.map = map;
        return this;
    }

    public Map<String, Object> map() {
        return this.map;
    }
}
