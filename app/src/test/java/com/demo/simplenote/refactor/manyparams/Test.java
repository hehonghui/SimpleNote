package com.demo.simplenote.refactor.manyparams;

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
        shareSDK.shareToMoment("Hello", "world", "url", "target", "mrsimple", new ShareSDK.ShareListener() {
            @Override
            public void onSuccess() {

            }
        });
    }
}
