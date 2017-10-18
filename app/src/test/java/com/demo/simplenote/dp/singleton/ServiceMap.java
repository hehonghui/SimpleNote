package com.demo.simplenote.dp.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrsimple on 18/10/17.
 */
public class ServiceMap {

    private static final Map<String, Object> INSTANCE = new HashMap<>();

    public ServiceMap() {
        INSTANCE.put("123", "123-obj") ;
        INSTANCE.put("456", "456-obj") ;
    }

    public static Object getService(String name) {
        return INSTANCE.get(name);
    }
}
