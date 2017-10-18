package com.demo.simplenote.dp.singleton;

/**
 * Created by mrsimple on 18/10/17.
 */

public class Test {
    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        Object obj = ServiceMap.getService("123") ;

        Singleton.getInstance().work();
        SingletonDCL.getInstance().work();
        SingletonEnum.INSTANCE.work();
    }
}
