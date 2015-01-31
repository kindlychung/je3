package com.company;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by IDEA on 26/01/15.
 */
public class Rect {
    public int x1, y1, x2, y2;
    public Rect(int x1, int y1, int x2, int y2) {
        this.x1 = min(x1, x2);
        this.y1 = min(y1, y2);
        this.x2 = max(x1, x2);
        this.y2 = max(y1, y2);
    }

    public Rect(int width, int height) {
        x1 = y1 = 0;
        x2 = width;
        y2 = height;
    }

    public Rect() {
        x1 = y1 = x2 = y2 = 0;
    }

    public void move(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    // This is pure and can be mathematically proven
    public Rect union(Rect r) {
        int minX = min(this.x1, r.x1);
        int minY = min(this.y1, r.y1);
        int maxX = max(this.x2, r.x2);
        int maxY = max(this.y2, r.y2);
        return new Rect(minX, minY, maxX, maxY);
    }

    // This is pure and can be mathematically proven
    public Rect intersection(Rect r) throws Exception {
        int interX1 = max(this.x1, r.x1);
        int interY1 = max(this.y1, r.y1);
        int interX2 = min(this.x2, r.x2);
        int interY2 = min(this.y2, r.y2);
        if((interX1 > interX2) || (interY1 > interY2)) {
            throw new Exception("No intersection for these Rect objects.");
        }
        return new Rect(interX1, interY1, interX2, interY2);
    }

    public boolean isInside(Rect r) {
        return (r.x1 <= this.x1) && (r.y1 <= this.y1) && (r.x2 >= this.x2) && (r.y2 >= this.y2);
    }

    public String toString() {
        return String.format("(%d, %d) (%d, %d)", x1, y1, x2, y2);
    }

}



//// test
////////////////////////////////
//public class Main {
//    public static void main(String[] args) throws Exception {
//        Rect r1 = new Rect(1, 1, 4, 4);
//        Rect r2 = new Rect(2, 3, 5, 6);
//        Rect u = r1.union(r2);
//        Rect i = r1.intersection(r2);
//        System.out.println(r1);
//        System.out.println(r2);
//        System.out.println(u);
//        System.out.println(i);
//        if(i.isInside(u)) {
//            System.out.println("Intersection is inside Union, of course.");
//        }
//    }
//}
