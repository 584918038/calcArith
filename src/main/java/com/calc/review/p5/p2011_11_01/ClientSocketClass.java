package com.calc.review.p5.p2011_11_01;

import java.io.*;
import java.net.Socket;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/3
 */
public class ClientSocketClass {

    public static void main(String[] args) {

        try {
            // 建立一个连接
            Socket socket = new Socket("localhost",8088);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            bufferedWriter.write("我是客户端发送的消息-01\n");
            bufferedWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 获得服务端的回复
            String clientStr = bufferedReader.readLine();

            System.out.println("收到服务端信息: " + clientStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
