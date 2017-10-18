package com.demo.simplenote.dp.singleton;

/**
 * Created by mrsimple on 18/10/17.
 */
public class SingletonDCL {

    private static SingletonDCL mInstance = null ;

    public static SingletonDCL getInstance() {
        if (mInstance == null) {
            synchronized (Singleton.class) {
                if (mInstance == null) {
                    mInstance = new SingletonDCL();
                }
            }
        }
        return mInstance;
    }

    public void work() {

    }
}
