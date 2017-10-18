package com.demo.simplenote.refactor.manyparams.refactor;

/**
 * Created by mrsimple on 18/10/17.
 */

public class Test {


    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        ShareSDK shareSDK = new ShareSDK() ;
        ShareContent content = new ShareContent().setTitle("Hello")
                                                .setContent("world")
                                                .setThumbUrl("url")
                                                .setTargetUrl("target")
                                                .setCreatorName("mrsimple") ;
        shareSDK.shareToMoment(content, new ShareSDK.ShareListener() {
            @Override
            public void onSuccess() {

            }
        });
    }
}
