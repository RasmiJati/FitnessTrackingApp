/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author rasmi
 */
public class DateUtil {

    public Date parseStringToDateOnly(String userInput) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date datelogged = removeTime(dateFormat.parse(userInput));
            return datelogged;
        } catch (ParseException e) {
            System.out.println("Error parsing the date. Make sure to use the correct format (yyyy-MM-dd).");
            System.out.println("Invalid date format.");
            return null;
        }
    }

    private static Date removeTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Set time components to zero
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public LocalDate parseStringToDate(String userInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (isValidDate(userInput, "yyyy-MM-dd")) {
            LocalDate date = LocalDate.parse(userInput, formatter);
            return date;
        }
        return null;
    }

    // Method to validate the date format using a regular expression
    private static boolean isValidDate(String date, String pattern) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";

        return date.matches(regex) && date.length() == pattern.length();
    }
}
