package com.kierznowski.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.spi.LocaleServiceProvider;

import javax.annotation.processing.SupportedOptions;
import javax.sound.midi.Soundbank;

public class DateTimeExamples {
    public void examples() {

        LocalDate today = LocalDate.now();
        System.out.println("Today:" + today);

        LocalTime currTime = LocalTime.now();
        System.out.println("Current time: " + currTime);

        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currDateTime);

        LocalDate someday = LocalDate.of(1996, Month.OCTOBER, 5);
        System.out.println("Someday: " + someday);

        LocalTime sometime = LocalTime.of(12, 23);
        System.out.println("Sometime: " + sometime);

        LocalDateTime someDayTime = LocalDateTime.of(1996, Month.OCTOBER, 5, 12, 23, 34);
        System.out.println("Someday and sometime: " + someDayTime);



    }

}
