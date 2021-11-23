package com.calc.review.p5.p2011_11_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/4
 */
public class ServerSocketThread implements Runnable{

    Socket socket;

    public ServerSocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        System.out.println("客户端：" + socket.getPort() + "已连接");
        BufferedReader bufferedReader = null;
        try{

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 获得客户端的输入信息
            String clientStr = bufferedReader.readLine();

            System.out.println("收到客户端的请求信息: " + clientStr);
            Thread.sleep(20000);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            bufferedWriter.write("我已经收到了消息\n");

            bufferedWriter.flush();
        }catch (Exception ex) {

        }


    }
}
