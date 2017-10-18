package com.demo.simplenote.refactor.manyparams.refactor;

/**
 * Created by mrsimple on 18/10/17.
 */

 class ShareSDK {

    /**
     *
     * @param content 分享的内容
     */
    public void shareToMoment(ShareContent content, ShareListener listener) {
        System.out.println("分享到朋友圈:  " + content );
        if ( listener != null ) {
            listener.onSuccess();
        }
    }


    /**
     *
     */
    public static interface ShareListener {
        void onSuccess();
    }

}
