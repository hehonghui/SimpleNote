package com.demo.simplenote.dp.nullobj;

/**
 * Created by mrsimple on 18/10/17.
 */
public class GetuiPushHandler implements PushMsgHandler {
    @Override
    public void handlePushMsg(String msg) {
        System.out.println("handle getui push msg");
    }
}
