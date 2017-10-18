package com.demo.simplenote.refactor.movedown.refactor;

/**
 * Created by mrsimple on 18/10/17.
 */
public class Car extends Vehicle implements Doorable {
    // 其他功能

    public void openDoor() {
        System.out.println("汽车开门");
    }
}
