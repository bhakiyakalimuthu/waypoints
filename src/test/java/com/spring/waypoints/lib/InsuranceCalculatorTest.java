package com.spring.waypoints.lib;

import com.spring.waypoints.model.CategoryDataPoints;
import com.spring.waypoints.model.Points;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class InsuranceCalculatorTest {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(InsuranceCalculatorTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }

    @Test
    public void TestMapWithSameDuration(){
        String t = "2018-10-22T12:00:25.000Z";
        List<Points> p = new ArrayList<>();
        Points p1 = new Points();
        Points p2 = new Points();
        p1.setSpeed(10);
        p1.setTimestamp(t);
        p1.setSpeed_limit(5);
        p2.setSpeed(15);
        p2.setTimestamp(t);
        p2.setSpeed_limit(5);
        p.add(p1);
        p.add(p2);
        InsuranceCalculator cal = new InsuranceCalculator();
        List<CategoryDataPoints> cp = cal.map(p);
        assertEquals(cp.get(0).getDistance(),0);
        assertEquals(cp.get(0).getDuration(),0);
        assertEquals(cp.get(0).getTotal_distance(),0);
        assertEquals(cp.get(0).getTotal_duration(),0);
    }
    @Test
    public void TestMapWithDifferentDuration(){
        String t1 = "2018-10-22T12:00:20.000Z";
        String t2 = "2018-10-22T12:00:25.000Z";
        List<Points> p = new ArrayList<>();
        Points p1 = new Points();
        Points p2 = new Points();
        p1.setSpeed(10);
        p1.setTimestamp(t1);
        p1.setSpeed_limit(5);
        p2.setSpeed(15);
        p2.setTimestamp(t2);
        p2.setSpeed_limit(5);
        p.add(p1);
        p.add(p2);
        InsuranceCalculator cal = new InsuranceCalculator();
        List<CategoryDataPoints> cp = cal.map(p);
        assertEquals(cp.get(0).getTotal_duration(),5.0);
        assertEquals(cp.get(0).getTotal_distance(),62.5);
    }

    @Test
    public void TestReduce(){
        String t1 = "2018-10-22T12:00:20.000Z";
        String t2 = "2018-10-22T12:00:25.000Z";
        List<Points> p = new ArrayList<>();
        Points p1 = new Points();
        Points p2 = new Points();
        p1.setSpeed(10);
        p1.setTimestamp(t1);
        p1.setSpeed_limit(5);
        p2.setSpeed(15);
        p2.setTimestamp(t2);
        p2.setSpeed_limit(5);
        p.add(p1);
        p.add(p2);
        InsuranceCalculator cal = new InsuranceCalculator();
        List<CategoryDataPoints> cp = cal.map(p);
        Categories c =  cal.reduce(cp);
        CategoryDataPoints cdp = c.getCategoryDataPoints();
        assertEquals(cdp.getTotal_duration(),5.0);
        assertEquals(cp.get(0).getTotal_distance(),62.5);
    }
}