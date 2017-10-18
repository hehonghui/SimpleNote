package com.demo.simplenote.dp.singleton;

/**
 * Created by mrsimple on 18/10/17.
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton() ;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public void work() {

    }
}
