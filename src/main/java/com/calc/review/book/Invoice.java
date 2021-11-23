package com.calc.review.book;

import lombok.Data;

import java.util.List;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/3
 */
@Data
public class Invoice {

    private String consumer;

    private List<Performance> performances;
}


