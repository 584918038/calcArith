package com.calc.review.p5.p2011_11_01;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @since 2021/11/3
 */
public class Client {

    // 服务端的监听
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost",8087);
            // 我想发送一个数据到服务端
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello world".getBytes(StandardCharsets.UTF_8));
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
