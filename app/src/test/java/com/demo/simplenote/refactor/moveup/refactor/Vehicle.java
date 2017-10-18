package com.demo.simplenote.refactor.moveup.refactor;

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

    public void turn() {
        System.out.println("转弯");
    }
}
