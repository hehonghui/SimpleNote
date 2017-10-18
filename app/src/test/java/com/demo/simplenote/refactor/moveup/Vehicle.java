package com.demo.simplenote.refactor.moveup;

/**
 * Created by mrsimple on 18/10/17.
 */

public abstract class Vehicle {

    public void start() {
        System.out.println("启动车子");
    }

    public void stop() {
        System.out.println("停车");
    }

    public void openDoor() {
        System.out.println("开门");
    }
}
