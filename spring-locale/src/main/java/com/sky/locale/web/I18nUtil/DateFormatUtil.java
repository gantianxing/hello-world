package com.sky.locale.web.I18nUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gantianxing on 2017/6/8.
 */
public class DateFormatUtil {

    public static void main(String[] args) throws Exception{
        Date date = new Date();
        String dateStr = date.toString();
        System.out.println("获取时间：" +dateStr);

        Locale locale = Locale.GERMANY;//德国
        DateFormat defStyleD = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        DateFormat shortStyleD = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        DateFormat mediumStyleD = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        DateFormat longStyleD = DateFormat.getDateInstance(DateFormat.LONG, locale);
        DateFormat fullStyleD = DateFormat.getDateInstance(DateFormat.FULL, locale);

        System.out.println(defStyleD.format(date));
        System.out.println(shortStyleD.format(date));
        System.out.println(mediumStyleD.format(date));
        System.out.println(longStyleD.format(date));
        System.out.println(fullStyleD.format(date));

        System.out.println("-----分割线 ------");
        DateFormat defStyleT = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
        DateFormat shortStyleT = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
        DateFormat mediumStyleT = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale);
        DateFormat longStyleT = DateFormat.getTimeInstance(DateFormat.LONG, locale);
        DateFormat fullStyleT = DateFormat.getTimeInstance(DateFormat.FULL, locale);

        System.out.println(defStyleT.format(date));
        System.out.println(shortStyleT.format(date));
        System.out.println(mediumStyleT.format(date));
        System.out.println(longStyleT.format(date));
        System.out.println(fullStyleT.format(date));

        System.out.println("-----分割线 parse方法------");

        System.out.println(fullStyleD.parse("Donnerstag, 8. Juni 2017"));
        System.out.println(fullStyleT.parse("21:33 Uhr CST"));

        System.out.println("-----分割线 日期时间格式化处理------");

        DateFormat shortDf = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT,Locale.CHINA);
        System.out.println(shortDf.format(date));
        DateFormat longDF = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,Locale.CHINA);
        System.out.println(longDF.format(date));

        //String 转日期
        String dStr = "2017年6月7日 上午10时13分01秒";
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CHINA);
        String dateS = df.parse(dStr).toString();
        System.out.println("反向解析出的结果：" + dateS);
    }
}
