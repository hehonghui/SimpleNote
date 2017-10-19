package com.demo.simplenote.utils;

import android.app.Application;
import android.util.Log;

import com.demo.simplenote.BuildConfig;

import java.lang.reflect.Method;

/**
 * Created by mrsimple on 19/10/17.
 */
public class TestReflect {
    /**
     * see : http://wetest.qq.com/lab/view/175.html
     */
    public static void setupLeakCanaryForTest(Application application) {
        if (BuildConfig.FLAVOR.contains("monkey")) {
            try {
                Log.e("", "### setupLeakCanaryForTest") ;
                Class canaryClz = Class.forName("com.simple.leakfortest.LeakCanaryForTest") ;
                Method method = canaryClz.getDeclaredMethod("install", Application.class) ;
                method.setAccessible(true);
                method.invoke(null, application) ;
            } catch (Exception e) {
                Log.e("", "### leak canary error : " + e.getMessage()) ;
                e.printStackTrace();
            }
        }
    }
}
