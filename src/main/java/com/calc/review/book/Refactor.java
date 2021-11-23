package com.calc.review.book;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/3
 */
public class Refactor {

    public static void main(String[] args) {


        Refactor r = new Refactor();

        List<Play> plays = new ArrayList<>();
        // 初始化剧团剧本信息
        plays.add(new Play("Hamlet", "tragedy"));
        plays.add(new Play("As You Like It", "comedy"));
        plays.add(new Play("Othello", "tragedy"));

        Invoice invoice = new Invoice();

        // 初始化账单信息
        List<Performance> performances = new ArrayList<>();
        performances.add(new Performance("hamlet", 55));
        performances.add(new Performance("as-like", 35));
        performances.add(new Performance("othello", 40));

        invoice.setConsumer("BigCo");
        invoice.setPerformances(performances);


        r.statement(invoice, plays);
    }

    public String statement(Invoice invoice, List<Play> plays) {

        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "";
        List<Performance> performances = invoice.getPerformances();

        for (int i = 0; i < performances.size(); i++) {

            Play play = plays.get(i);
            double thisAmount = 0;

            switch (play.getType()) {

                case "tragedy":
                    thisAmount = 40000;
                    if (performances.get(i).getAudience() > 30) {

                        thisAmount += 1000 * (performances.get(i).getAudience() - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (performances.get(i).getAudience() > 20) {

                        thisAmount += 10000 + 500 * (performances.get(i).getAudience() - 20);
                    }
                    thisAmount += 300 * performances.get(i).getAudience();
                    break;

                default:
                    throw new Error("unknown type:" + play.getType());
            }

            // add volume credits
            volumeCredits += Math.max(performances.get(i).getAudience() - 30, 0);

            // add extra credit for every ten comedy attendees
            if ("comedy".equals(play.getType())) {
                volumeCredits += Math.floor(performances.get(i).getAudience() / 5);
            }

            // print line for this order
            result = play.getName() + ": $" +thisAmount/100 + performances.get(i).getAudience() + "seats";
            totalAmount += thisAmount;
        }

        result += "Amount owed is $" + totalAmount/100;
        System.out.println();
        result += "You earned $"+volumeCredits + "credits";
        return result;

    }
}
