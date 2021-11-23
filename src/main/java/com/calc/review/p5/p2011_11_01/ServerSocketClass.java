package com.calc.review.p5.p2011_11_01;

import com.calc.review.p5.p2011_11_04.ServerSocketThread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/3
 */
public class ServerSocketClass {


    public static void main(String[] args){

        try {
            final int DEFAULT_PORT = 8088;
            ServerSocket serverSocket = null;
            serverSocket = new ServerSocket(DEFAULT_PORT);

            ExecutorService executorService =
                    Executors.newFixedThreadPool(4);
            while (true) {
                // 阻塞操作，等待客户端连接
                Socket socket = serverSocket.accept();
                executorService.submit(new ServerSocketThread(socket));
            }

        } catch (Exception ex) {

        } finally {

        }
    }
}
