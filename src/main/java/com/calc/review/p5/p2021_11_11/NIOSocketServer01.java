package com.calc.review.p5.p2021_11_11;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/11
 */
public class NIOSocketServer01 {

    public static void main(String[] args) {

        try {

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 默认是true
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8087));


            while (true) {

                SocketChannel socketChannel = serverSocketChannel.accept();
                // 如果有代码进入这个位置，说明有连接过来
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                socketChannel.read(buffer);
                System.out.println(new String(buffer.array()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
