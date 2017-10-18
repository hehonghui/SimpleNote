package com.demo.simplenote.dp.nullobj;

/**
 * Created by mrsimple on 18/10/17.
 */

public class Factory {
    public static final int UMENG_MSG_TYPE = 1 ;
    public static final int GETUI_MSG_TYPE = 2 ;

    public static PushMsgHandler create(int msgType) {
        // TODO Auto-generated method stub
        PushMsgHandler handler = null;
        switch (msgType) {
            case UMENG_MSG_TYPE:
                handler = new UmengPushHandler();
                break;
            case GETUI_MSG_TYPE:
                handler = new GetuiPushHandler();
                break;
            default:
                handler = null;
                break;
        }
        return handler;
    }
}
