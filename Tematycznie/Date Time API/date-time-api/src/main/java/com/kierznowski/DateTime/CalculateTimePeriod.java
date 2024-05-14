package com.kierznowski.DateTime;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class CalculateTimePeriod {

    public void period() {

        LocalDate today = LocalDate.now();

        LocalDate christmas = LocalDate.of(today.getYear(), Month.DECEMBER, 25);

        Period howLongToChristmas = Period.between(today, christmas);

        System.out.println("There is only: " + howLongToChristmas.getMonths() + " months and " + howLongToChristmas.getDays() + " days to Christmas!");



    }

}
