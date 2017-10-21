package com.simple.leakfortest;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.AndroidExcludedRefs;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.squareup.leakcanary.internal.DisplayLeakActivity;
import com.squareup.leakcanary.internal.LeakCanaryInternals;

/**
 * see : http://wetest.qq.com/lab/view/175.html
 * Created by mrsimple on 9/3/17.
 */
public final class LeakCanaryForTest {

    public static String sAppPackageName = "";
    private static RefWatcher sWatcher ;

    public static void install(Application application) {
        if (LeakCanary.isInAnalyzerProcess(application)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        Log.e("", "### LeakCanaryForTest install invoked.") ;
        sAppPackageName = application.getPackageName();
        // 设置定制的 LeakDumpService , 将 leak 信息输出到指定的目录
        sWatcher = LeakCanary
                    .refWatcher(application)
                    // 定制 LeakDumpService
                    .listenerServiceClass(LeakDumpService.class)
                    .excludedRefs(AndroidExcludedRefs.createAppDefaults().build())
                    .buildAndInstall();

        // disable DisplayLeakActivity
        LeakCanaryInternals.setEnabled(application, DisplayLeakActivity.class, false);
    }

    /**
     * 手动监控一个对象, 比如在 Fragment 的 onDestroy 函数中 调用 watch 监控Fragment是否被回收.
     * @param target
     */
    public static void watch(Object target) {
        if ( sWatcher != null ) {
            sWatcher.watch(target);
        }
    }
}
