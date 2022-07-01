package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Utils {

    public static LocalDateTime parseDate(String target) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd").parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).withNano(1);
    }

}
