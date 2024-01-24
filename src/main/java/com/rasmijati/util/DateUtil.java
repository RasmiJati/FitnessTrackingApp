/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author rasmi
 */
public class DateUtil {

    String s;

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
