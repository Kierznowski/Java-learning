package com.kierznowski.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class ExtractFromDateTime {
    public void extract() {

        LocalDate someDay = LocalDate.of(2000, 10, 12);
        LocalTime someTime = LocalTime.of(12, 34);
        LocalDateTime combinDateTime = someDay.atTime(someTime);
        LocalDateTime combinedTimeDate = someTime.atDate(someDay);

        System.out.println("Time: " + someTime);
        System.out.println("Someday: " + someDay);
        System.out.println("Combined: " + combinDateTime);
        System.out.println("Combined another way: " + combinedTimeDate);

        LocalDate date = combinedTimeDate.toLocalDate();
        LocalTime time = combinDateTime.toLocalTime();

        System.out.println("It was " + date + " at " + time);

        int year = combinDateTime.getYear();
        Month month = combinDateTime.getMonth();
        int hour = combinDateTime.getHour();

        System.out.println("Month: " + month  + "\nYear: " + year + " \nHour: " + hour);
        
    }

}
