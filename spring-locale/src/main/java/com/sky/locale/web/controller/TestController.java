package com.sky.locale.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by gantianxing on 2017/6/5.
 */
@Controller
@RequestMapping("/free")
public class TestController {

    @RequestMapping("/test")
    public String sayHello(ModelMap model){
        System.out.println("say hi ……");
        model.put("name", "test");

        return "/test1";
    }

    @RequestMapping("/test2")
    public String test2(ModelMap model){
        System.out.println("say hi ……");
        model.put("name", "test");
        return "/test";
    }

    private void testLocale(){
        //创建泰国Locale
        Locale th = new Locale("th","TH");

        //第二种方式
        Locale locale = Locale.US;

        //第三章 获取本地
        Locale def = Locale.getDefault();

        //在springmvc中不直接使用
        ResourceBundle rb = ResourceBundle.getBundle("message",th);
    }

    public static void main(String[] args) {
        Locale lc = Locale.CHINA; //汉语中国地区
        //Locale lc = new Locale("en");//英语地区
        ResourceBundle rb = ResourceBundle.getBundle("messages",lc);
        System.out.println(rb.getString("productname.required.product.name"));
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
        MessageFormat mf= new MessageFormat("当前价格：{0,number,percent}，原价：{1,number,currency}",Locale.US);
        String result=mf.format(objects);
        System.out.println(result);
    }
}
