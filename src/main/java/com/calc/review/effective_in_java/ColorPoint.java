package com.calc.review.effective_in_java;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/18
 */
public class ColorPoint extends Point{

    private final String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public boolean equals(Object o) {

        if (!(o instanceof  Point)) {
            return false;
        }

        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        return super.equals(o) && ((ColorPoint) o).color.equals(color);
    }
}
