package com.calc.review.effective_in_java;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/18
 */
public class Point {

    private final int x;

    private final int y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {

       if (null == o || o.getClass() != getClass()) {
           return false;
       }

        Point p = (Point)o;
        return p.x == x && p.y == y;
    }
}
