package ru.alexey4he.lab_5.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

@Slf4j
public class DateTimeUtil {
    public static SimpleDateFormat getCustomFormat(){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
        return date;
    }
}
