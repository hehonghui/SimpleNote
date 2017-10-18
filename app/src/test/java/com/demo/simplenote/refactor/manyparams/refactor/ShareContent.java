package com.demo.simplenote.refactor.manyparams.refactor;

/**
 * Created by mrsimple on 18/10/17.
 */
public class ShareContent {
    String title;
    String content;
    String thumbUrl;
    String targetUrl;
    String creatorName;

    public ShareContent setTitle(String title) {
        this.title = title;
        return this;
    }

    public ShareContent setContent(String content) {
        this.content = content;
        return this;
    }

    public ShareContent setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public ShareContent setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
        return this;
    }

    public ShareContent setCreatorName(String creatorName) {
        this.creatorName = creatorName;
        return this;
    }

    @Override
    public String toString() {
        return "ShareContent{" + "title='" + title + '\'' + ", content='" + content + '\'' + ", thumbUrl='" +
                thumbUrl + '\'' + ", targetUrl='" + targetUrl + '\'' + ", creatorName='" + creatorName + '\'' + '}';
    }
}
