package com.demo.simplenote.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mrsimple on 18/10/17.
 */

public final class TimestampFormator {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private TimestampFormator() {
    }

    public static String format(long ts) {
        return DATE_FORMAT.format(new Date(ts)) ;
    }
}
