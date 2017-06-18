package com.sky.locale.web.I18nUtil;

import org.apache.commons.lang.StringUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * NumberFormat国际化工具类 NumberFormat是线程安全的，可以提前初始化
 * Created by gantianxing on 2017/6/8.
 */
public class NumberFormatUtil {

    public static NumberFormat numF; //number型格式
    public static NumberFormat curF; //货币型格式
    public static NumberFormat perF; //百分比型格式
    public static NumberFormat intF; //整型格式

    /**
     * 程序启动时，或者切换语言时调用
     * @param localeStr 如：en
     */
    public static void initLocal(String localeStr){
        Locale locale = null;
        if(StringUtils.isBlank(localeStr)){
            return;
        }
        String [] a = localeStr.split("_");
        if(a.length>1){
            locale = new Locale(a[0],a[1]);
        } else {
            locale = new Locale(localeStr);
        }
        numF = NumberFormat.getInstance(locale);
        curF = NumberFormat.getCurrencyInstance(locale);
        perF = NumberFormat.getPercentInstance(locale);
        intF = NumberFormat.getIntegerInstance(locale);
    }

    /**
     * 字符串类型 转换为 数字类型
     * @param numberStr
     * @return
     * @throws ParseException
     */
    public static Number getNumber(String numberStr) throws ParseException{
        return numF.parse(numberStr);
    }

    /**
     * 数字类型 转换为 字符串类型
     * @param number
     * @return
     */
    public static String getStringNumber(Number number){
        numF.setMinimumFractionDigits(4);//最多保留4个小数
        return numF.format(number);
    }

    /**
     * 把价格字符串转换为 double型
     * 用于从页面读取字符串，保存到数据库
     * @param priceStr 如：$100.00
     * @return 如：100.00
     */
    public static double getNumberCur(String priceStr) throws ParseException {
        return curF.parse(priceStr).longValue();
    }

    /**
     * 把double型转换为指定国家的 价格字符串
     * 用户从数据库读取，输出到页面
     * @param price 如：100.0012
     * @return 如：$100.00 （自动四舍五入 保留两位小数）
     */
    public static String getStringCur(double price){
        return curF.format(price);
    }

    /**
     * 百分比字符串传 double
     * @param perStr
     * @return
     * @throws ParseException
     */
    public static double getNumberPer(String perStr) throws ParseException{
        return perF.parse(perStr).longValue();
    }

    /**
     * 字double 转 百分比字符串
     * @param per
     * @return
     */
    public static String getStringPer(double per){
        perF.setMinimumFractionDigits(2); //保留两位小数
        return perF.format(per);
    }

    /**
     * 字符串 转 number
     * @param intStr
     * @return
     * @throws ParseException
     */
    public static int getNumberInt(String intStr) throws ParseException{
        return intF.parse(intStr).intValue();
    }

    /**
     * int 转 字符串
     * @param i
     * @return
     */
    public static String getStringInt (int i){
        return intF.format(i);
    }


    public static void main(String[] args) throws Exception{
        double price = 111110.0058;

        //initLocal("de_DE"); //德国
        //initLocal("th_TH"); //泰国
        initLocal("zh_CN");  //中国
        System.out.println(getStringNumber(price));
        System.out.println(getStringCur(price));
        System.out.println(getStringPer(0.87344));
        System.out.println(getStringInt(1111111));
        System.out.println("-------分界线------");
        System.out.println(getNumber(getStringNumber(price)));
        System.out.println(getNumberCur(getStringCur(price)));
        System.out.println(getNumberPer(getStringPer(0.87344)));
        System.out.println(getNumberInt(getStringInt(1111111)));

        Locale locale = Locale.CHINA;
    }
}
