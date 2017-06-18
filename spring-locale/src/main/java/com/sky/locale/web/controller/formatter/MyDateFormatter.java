package com.sky.locale.web.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class MyDateFormatter implements Formatter<LocalDate> {

    private DateTimeFormatter formatter;
    private String datePattern;

    public MyDateFormatter(String datePattern) {
        this.datePattern = datePattern;
        formatter = DateTimeFormatter.ofPattern(datePattern);
    }

    @Override
    public String print(LocalDate date, Locale locale) {
        System.out.println(date.format(formatter));
        return date.format(formatter);
    }

    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {
        System.out.println("formatter.parse. s:" + s + ", pattern:" + datePattern);
        try {
            return LocalDate.parse(s, DateTimeFormatter.ofPattern(datePattern));
        } catch (DateTimeParseException e) {
            // the error message will be displayed in <form:errors>
            throw new IllegalArgumentException(
                    "invalid date format. Please use this pattern\""
                            + datePattern + "\"");
        }
    }
}