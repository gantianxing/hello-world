package com.sky.locale.web.controller.user;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    private DateTimeFormatter formatter;
    private String localStr;

    public LocalDateFormatter(String localStr) {
        this.localStr = localStr;
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd",new Locale(localStr));
    }

    @Override
    public String print(LocalDate date, Locale locale) {
        System.out.println(date.format(formatter));
        return date.format(formatter);
    }

    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {
        System.out.println("formatter.parse. s:" + s + ", pattern:" + localStr);
        try {
            return LocalDate.parse(s, formatter);
        } catch (DateTimeParseException e) {
            // the error message will be displayed in <form:errors>
            throw new IllegalArgumentException(
                    "invalid date format. Please use this pattern\""
                            + localStr + "\"");
        }
    }
}