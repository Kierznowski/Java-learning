package com.kierznowski.InstantDuration;

import java.time.*;

public class DurationsInstants {

    public void durInst() {

        Instant timestamp = Instant.now(); 
        System.out.println("Timestamp1: " + timestamp);

        int nanosecondFromLastSecond = timestamp.getNano();
        System.out.println(nanosecondFromLastSecond);

        Duration threeHours = Duration.ofHours(3);

        long seconds = threeHours.minusMinutes(15).getSeconds();
        long minutes = Duration.ofSeconds(seconds).toMinutes();

        System.out.println("3 Hours - 15 minutes in seconds: " + seconds);
        System.out.println("In minutes: " + minutes);
    }
}
