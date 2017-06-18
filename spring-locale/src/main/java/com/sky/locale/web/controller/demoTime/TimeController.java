package com.sky.locale.web.controller.demoTime;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by gantianxing on 2017/6/7.
 */
public class TimeController {

    public static void main(String[] args) throws Exception{
        Locale l1 = new Locale("en");
        Locale l2 = new Locale("en","US");
        Locale l3 = new Locale("en","US","special");
        Locale l4 = new Locale("th");

        System.out.println(l3.getDisplayLanguage(Locale.JAPAN));
        System.out.println(l3.getDisplayLanguage(l4));

        // 机器已经安装的语言环境数组
        Locale[] allLocale = Locale.getAvailableLocales();
        // 返回 ISO 3166 中所定义的所有两字母国家代码
        String[] str1 = Locale.getISOCountries();
        // 返回 ISO 639 中所定义的所有两字母语言代码
        String[] str2 = Locale.getISOLanguages();

        //日期转String
        Date date = new Date();
        String dateStr = date.toString();
        System.out.println("获取时间：" +dateStr);
        DateFormat shortDf = DateFormat.getDateTimeInstance(SimpleDateFormat.SHORT,SimpleDateFormat.SHORT,Locale.CHINA);
        System.out.println(shortDf.format(date));
        DateFormat longDF = DateFormat.getDateTimeInstance(SimpleDateFormat.LONG,SimpleDateFormat.LONG,Locale.CHINA);
        System.out.println(longDF.format(date));

        //String 转日期
        String dStr = "2017年6月7日 上午10时13分01秒";
        DateFormat df = DateFormat.getDateTimeInstance(SimpleDateFormat.LONG, SimpleDateFormat.LONG, Locale.CHINA);
        String dateS = df.parse(dStr).toString();

        System.out.println("反向解析出的结果：" + dateS);

        DateFormat sdf = new SimpleDateFormat();

        numdf();
        msgf();
        msgNum();
    }

    public static void numdf() throws Exception{

        Locale locale=new Locale("zh","CN");

        Locale locale2=new Locale("en","US");

        NumberFormat ft=NumberFormat.getCurrencyInstance(locale2);
        double amt=123456.7812;
        System.out.println("xxxxxxxxxxxx");
        System.out.println(ft.format(amt));
        System.out.println(ft.parse(ft.format(amt)));
    }

    public static void msgf(){
        Object[] objects={new Date(),"美国","晴朗"};//指定date或time，传入Date 实例
        //只指定应用对象：objects
        MessageFormat mf= new MessageFormat("当前时间：{0,date,full}，地点：{1}，天气：{2}",Locale.CHINA);
        String result=mf.format(objects);
        System.out.println(result);
    }

    public static void msgNum() {
        Object[] objects={1111.11,2111.11};//指定date或time，传入Date 实例
        MessageFormat mf= new MessageFormat("当前价格：{0,number,percent}，原价：{1,number,currency}",new Locale("en"));
        String result=mf.format(objects);
        System.out.println(result);
    }

}
