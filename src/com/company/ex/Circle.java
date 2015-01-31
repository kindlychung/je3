package com.company.ex;

/**
 * Created by IDEA on 27/01/15.
 */
public class Circle {
    private double radius;
    private double centerX, centerY;

    public Circle(double cx, double cy, double r) {
        centerX = cx;
        centerY = cy;
        radius = r;
    }

    public Circle(double r) {
        this(0.0, 0.0, r);
    }

    public Circle() {
        this(0.0, 0.0, 0.0);
    }

    public void move(double dx, double dy) {
        centerX += dx;
        centerY += dy;
    }

    public double distFromCenter(double px, double py) {
        return Math.sqrt(Math.pow(px - centerX, 2.0) + Math.pow(py - centerY, 2.0));
    }

    public boolean hasPointOn(double px, double py) {
        return (distFromCenter(px, py) == radius) ? true : false;
    }

    public boolean hasPointIn(double px, double py) {
        return (distFromCenter(px, py) <= radius) ? true : false;
    }

    public boolean hasCircleIn(Circle other) {
        double radiusDiff = Math.abs(other.radius - radius);
        double centerDist = distFromCenter(other.centerX, other.centerY);
        return (centerDist <= radiusDiff) ? true : false;
    }
}
