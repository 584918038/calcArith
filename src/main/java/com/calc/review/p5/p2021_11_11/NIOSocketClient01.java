package com.calc.review.p5.p2021_11_11;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/11
 */
public class NIOSocketClient01 {

    public static void main(String[] args) {

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost",8087));
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("hello, hello , hello\n".getBytes());
            // 由读转化成写
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
