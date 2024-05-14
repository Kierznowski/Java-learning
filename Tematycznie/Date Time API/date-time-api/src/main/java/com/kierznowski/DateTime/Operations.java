package com.kierznowski.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Operations {
    public void operation() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();
        LocalTime timeStamp = LocalTime.now();

        LocalDateTime future = now.plusYears(3)
                                    .plusDays(2)
                                    .plusHours(12);

        System.out.println("now: " + now);
        System.out.println("Future: " + future);

        boolean isBefore = future.isBefore(now);
        boolean isAfter = future.isAfter(now);

        System.out.println("Future is before now? " + isBefore);
        System.out.println("Future is after now? " + isAfter);
    }
}
