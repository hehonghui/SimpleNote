package com.demo.simplenote.dp.adapter;

/**
 * Created by mrsimple on 18/10/17.
 */
public class ChinaPlug implements PowerPlug {
    @Override
    public void charge() {
        System.out.println("中国的扁平充电器直接连接到电源接口");
    }
}
