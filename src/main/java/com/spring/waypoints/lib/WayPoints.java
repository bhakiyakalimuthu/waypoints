package com.spring.waypoints.lib;

import com.spring.waypoints.model.CategoryDataPoints;
import com.spring.waypoints.model.Points;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WayPoints {
    private Points points;

    public WayPoints(Points points){
        this.points = points;
    }

    public CategoryDataPoints interpolate( Points p) {
        float dur,dist,totalDistance, totalDuration,s0,s1,speedLimit ;
        s0 = this.points.getSpeed();
        s1 = p.getSpeed();
        speedLimit = this.points.getSpeed_limit();
        String t0 = this.points.getTimestamp();
        String t1 = p.getTimestamp();
        totalDuration = timeDifference(t0,t1);
        if (totalDuration == 0){
            totalDistance = 0;
            dur = 0;
            dist = 0;
        }else {
            if (s0 > s1) {
                s0 = s1;
                s1 = s0;
            }
           float a = (s1 - s0) / totalDuration;
           totalDistance =  (s0 + a * totalDuration / 2) * totalDuration;
           if (s1<= speedLimit) {
               dur = 0;
               dist = 0;
           }else {
               if (s1==s0){
                   dur = totalDuration;
                   dist = s0*dur;
               }else {
                   if (s0 > speedLimit) {
                       speedLimit = s0;
                   }
                   dur = (s1 -speedLimit) / a;
                   dist = (speedLimit + a * dur / 2) * dur;
               }
           }
        }
        CategoryDataPoints cp = new CategoryDataPoints();
        cp.setDuration(dur);
        cp.setDistance(dist);
        cp.setTotal_duration(totalDuration);
        cp.setTotal_distance(totalDistance);
        return  cp;
    }

    private long timeDifference(String t1, String t2){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        LocalDateTime dateTime1= LocalDateTime.parse(t1, formatter);
        LocalDateTime dateTime2= LocalDateTime.parse(t2, formatter);

        long diffInSeconds = java.time.Duration.between(dateTime1, dateTime2).getSeconds();
        return diffInSeconds;
    }
}

