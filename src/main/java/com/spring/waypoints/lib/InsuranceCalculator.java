package com.spring.waypoints.lib;

import com.spring.waypoints.model.CategoryDataPoints;
import com.spring.waypoints.model.Points;

import java.util.ArrayList;
import java.util.List;

public class InsuranceCalculator {

    public List<CategoryDataPoints> map(List<Points> points){
        List<CategoryDataPoints> categoryDataPoints = new ArrayList<>();
        for (int i = 0; i < points.size()-1; i++) {
            CategoryDataPoints dp = new WayPoints(points.get(i)).interpolate(points.get(i+1));
            categoryDataPoints.add(dp);
        }
        return categoryDataPoints;
    }

    public Categories reduce(List<CategoryDataPoints> dataPoints) {
        CategoryDataPoints categoryDataPoints = new CategoryDataPoints();
        Categories categories = new Categories(categoryDataPoints);
        for (CategoryDataPoints dp:dataPoints) {
            categories.addDuration(dp.getDuration());
            categories.addDistance(dp.getDistance());
            categories.addTotalDuration(dp.getTotal_duration());
            categories.addTotalDistance(dp.getTotal_distance());
        }
        return categories;
    }
}
