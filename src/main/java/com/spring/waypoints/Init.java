package com.spring.waypoints;

import com.spring.waypoints.lib.InsuranceCalculator;
import com.spring.waypoints.lib.JSONFileReader;
import com.spring.waypoints.model.CategoryDataPoints;
import com.spring.waypoints.model.Points;

import java.io.IOException;

import java.util.List;

public class Init {
    public static void main(String[] args) throws IOException {
        JSONFileReader fileReader = new JSONFileReader();
        List<Points> pointsList = fileReader.fileReader();
        InsuranceCalculator insuranceCalculator = new InsuranceCalculator();
        List<CategoryDataPoints> dp = insuranceCalculator.map(pointsList);
        CategoryDataPoints categoryDataPoints = insuranceCalculator.reduce(dp).getCategoryDataPoints();
        System.out.println(categoryDataPoints);
    }
}
