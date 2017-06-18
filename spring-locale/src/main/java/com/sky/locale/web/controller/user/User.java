package com.sky.locale.web.controller.user;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by gantianxing on 2017/6/8.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;//姓名

    private LocalDate birthday;//生日

    private double money;//资产

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
