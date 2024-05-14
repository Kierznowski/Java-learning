package com.kierznowski.TimeZones;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZoneDateTime {
    public void zone() {
        ZonedDateTime local = ZonedDateTime.now();
        Set<String> zones = ZoneId.getAvailableZoneIds();

        for (String zone : zones) {
            System.out.println(zone);
        }

        

        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZonedDateTime newYorkTime = local.withZoneSameInstant(newYorkZone);
        
        System.out.println("Poland time: " + local);
        System.out.println("New York time: " + newYorkTime);
    }

}
