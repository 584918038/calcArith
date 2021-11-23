package com.calc.review.effective_in_java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/18
 */
public class ColorMain {

    private static final Set<Point> unitCircle = new HashSet<>();

    static {
        unitCircle.add(new Point(1, 0));
        unitCircle.add(new Point(0, 1));
        unitCircle.add(new Point(-1, 0));
        unitCircle.add(new Point(0, -1));

    }

    public static void main(String[] args) {

//        Point p = new Point(1,2);
//
//        ColorPoint cp = new ColorPoint(1,2,"red");
//
//        System.out.println("p.equals(cp) :" + p.equals(cp));
//
//        System.out.println("cp.equals(p) :" + cp.equals(p));

        ColorPoint p1 = new ColorPoint(1, 2, "red");

        Point p2 = new Point(1, 2);

        ColorPoint p3 = new ColorPoint(1, 2, "blue");

        System.out.println("p1.equals(p2):" + p1.equals(p2));
        System.out.println("p2.equals(p3):" + p2.equals(p3));
        System.out.println("p1.equals(p3):" + p1.equals(p3));
    }

    public static boolean onUnitCircle(Point p) {

        return unitCircle.contains(p);
    }


}
