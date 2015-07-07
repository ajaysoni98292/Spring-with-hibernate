package com.spring.example.utils;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * (non-JavaDoc)
 * @author ajay
 */
public class DateUtils {

    // This method is used when i am trying to store the current time in DB.
    // This will stored in the UTC time zone and specific date format.

    public static String getCurrentTime() {

        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constant.DATE_FORMAT);
        return dateTime.toString(dateTimeFormatter);
    }
}
