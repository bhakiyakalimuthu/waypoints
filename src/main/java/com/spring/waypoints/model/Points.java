package com.spring.waypoints.model;


public class Points {
    private String timestamp;
    private Position position;
    private float speed;
    private float speed_limit;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed_limit() {
        return speed_limit;
    }

    public void setSpeed_limit(float speed_limit) {
        this.speed_limit = speed_limit;
    }
}
