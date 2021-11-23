package com.calc.review.p5.p2011_11_01;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @since 2021/11/3
 */
public class Server {

    // 服务端的监听
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8087);
            Socket socket = serverSocket.accept();

            // 从网络上拿到一个数据输入流
            InputStream inputStream = socket.getInputStream();

            int len = 0;
            byte[] buff = new byte[1024];

            while ((len = inputStream.read(buff)) != -1) {

                System.out.println(new String(buff,0,len, StandardCharsets.UTF_8));
            }
            inputStream.close();
            socket.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
