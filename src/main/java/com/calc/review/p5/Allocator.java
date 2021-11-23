package com.calc.review.p5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/21
 */
public class Allocator {

    private List<Object> list = new ArrayList<>();

    synchronized boolean apply(Object fromLock, Object toLock) {

        if (list.contains(fromLock) || list.contains(toLock)) {
            return false;
        } else {
            list.add(fromLock);
            list.add(toLock);
            return true;
        }
    }

    synchronized void free(Object fromLock, Object toLock) {

        list.remove(fromLock);
        list.remove(toLock);
    }
}
