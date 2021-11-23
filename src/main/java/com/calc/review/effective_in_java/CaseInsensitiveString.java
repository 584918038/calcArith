package com.calc.review.effective_in_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/17
 */
public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // 违反对称性
//    @Override
//    public boolean equals(Object o) {
//
//        if (o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        }
//
//        if (o instanceof String) {
//            return s.equalsIgnoreCase((String)o);
//        }
//        return false;
//    }

    public boolean equals(Object o) {

        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString)o).s.equalsIgnoreCase(s);

    }

    public static void main(String[] args) {

        // 违反对称性
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println("cis.equals(s): " + cis.equals(s));
        System.out.println("s.equals(cis): " + s.equals(cis));

        List<CaseInsensitiveString> list = new ArrayList<>();

        list.add(cis);

        System.out.println("list.contains(s):" + list.contains(s));
    }
}
