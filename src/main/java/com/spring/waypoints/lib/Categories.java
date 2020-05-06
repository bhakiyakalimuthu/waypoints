package com.spring.waypoints.lib;

import com.spring.waypoints.model.CategoryDataPoints;


public class Categories {
    private CategoryDataPoints categoryDataPoints;
    public Categories(CategoryDataPoints categoryDataPoints) {
        this.categoryDataPoints = categoryDataPoints;
    }

    public void addDuration(float duration) {
       float dur = this.categoryDataPoints.getDuration() + duration;
       this.categoryDataPoints.setDuration(dur);
    }

    public void addDistance(float distance) {
        float dist = this.categoryDataPoints.getDistance()+distance;
        this.categoryDataPoints.setDistance(dist);
    }

    public void addTotalDuration(float totalDuration){
        float totalDur = this.categoryDataPoints.getTotal_duration()+totalDuration;
         this.categoryDataPoints.setTotal_duration(totalDur);
    }

    public  void addTotalDistance(float totalDistance) {
         float totalDis = this.categoryDataPoints.getTotal_distance()+totalDistance;
         this.categoryDataPoints.setTotal_distance(totalDistance);
    }
    public CategoryDataPoints getCategoryDataPoints(){
        return this.categoryDataPoints;
    }
}
