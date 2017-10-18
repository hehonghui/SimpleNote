package com.demo.simplenote.dp.nullobj;

/**
 * Created by mrsimple on 18/10/17.
 */
public class NullObjPushHandler implements PushMsgHandler {

    private static final NullObjPushHandler INSTANCE = new NullObjPushHandler() ;

    private NullObjPushHandler() {
    }

    public static NullObjPushHandler getInstance() {
        return INSTANCE;
    }

    @Override
    public void handlePushMsg(String msg) {
        System.out.println("do nothing !!!!");
    }
}
