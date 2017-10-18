package com.demo.simplenote.dp.adapter;

/**
 * Created by mrsimple on 18/10/17.
 */
public class EuropePlug implements PowerPlug {

    PowerPlug mPlug ;

    public EuropePlug(PowerPlug plug) {
        this.mPlug = plug;
    }

    @Override
    public void charge() {
        System.out.println("1. 将扁平的充电器连接到 欧标插头 ");
        System.out.println("2. 欧标的插头连接到电源接口上");
    }
}
