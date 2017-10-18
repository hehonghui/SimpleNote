package com.demo.simplenote.refactor.manyparams;

/**
 * Created by mrsimple on 18/10/17.
 */

public class ShareSDK {

    /**
     *
     * @param title 分享标题
     * @param content 分享的内容
     * @param thumbUrl 分享的图片url
     * @param targetUrl 分享的目标连接
     * @param creatorName 分享者的用户名
     */
    public void shareToMoment(String title, String content, String thumbUrl,
                              String targetUrl, String creatorName, ShareListener listener) {
        System.out.println("分享到朋友圈: 文章标题为: " + title
                + ", 内容为 = " + content);
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
