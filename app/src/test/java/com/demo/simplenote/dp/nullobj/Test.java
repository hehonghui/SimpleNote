package com.demo.simplenote.dp.nullobj;

/**
 * Created by mrsimple on 18/10/17.
 */

public class Test {

    @org.junit.Test
    public void testPushMsg() throws Exception {
        String msg = "hello";
        PushMsgHandler handler = Factory.create(Factory.UMENG_MSG_TYPE) ;

        if ( handler != null ) {
            handler.handlePushMsg(msg);
        }

        PushMsgHandler handler2 = Factory.create(Factory.GETUI_MSG_TYPE) ;
        if ( handler2 != null ) {
            handler2.handlePushMsg(msg);
        }

        PushMsgHandler handler3 = Factory.create(4) ;
        if ( handler3 != null ) {
            handler3.handlePushMsg(msg);
        }
    }


    @org.junit.Test
    public void testPushMsgWithNullObj() throws Exception {
        String msg = "hello";
        FactoryV2.create(FactoryV2.UMENG_MSG_TYPE).handlePushMsg(msg);
        FactoryV2.create(FactoryV2.GETUI_MSG_TYPE).handlePushMsg(msg);
        FactoryV2.create(4).handlePushMsg(msg);
    }
}
