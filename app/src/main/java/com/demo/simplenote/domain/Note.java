package com.demo.simplenote.domain;

/**
 * Created by mrsimple on 17/10/17.
 */

public class Note {
    public long modifyTimeStamp ;
    public String title = "";
    public String content = "";

    @Override
    public String toString() {
        return "Note{" + "title='" + title + '\'' + '}';
    }
}
