//package com.calc.review.p5;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.Callable;
//import java.util.concurrent.FutureTask;
//
///**
// * @author 徐恩晗 xshlxx@126.com
// * @since 2021/10/19
// */
//public class CallableFutureDemo implements Callable<String> {
//
//    @Override
//    public String call() throws Exception {
//
//        System.out.println("Hello Mic");
//        Thread.sleep(3000);
//        return "Mic";
//    }
//
//
//    public static void main(String[] args) throws Exception{
//
////        CallableFutureDemo callableFutureDemo = new CallableFutureDemo();
////
////        FutureTask futureTask = new FutureTask(callableFutureDemo);
////
////        new Thread(futureTask).start();
////
////        // get方法属于阻塞方法
////        System.out.println(futureTask.get());
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = format.format(new Date(1281456000000));
//
//        System.out.println(formattedDate);
//    }
//}
