package com.calc.review.p5.p2011_11_08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/8
 */
public class NIOFirstDemo {

    public static void main(String[] args) {

        // 实现一个文件的复制
        try {
            FileInputStream fis = new FileInputStream(new File("/Users/xuenhan/Documents/E/test.txt"));

            FileOutputStream fos = new FileOutputStream(new File("/Users/xuenhan/Documents/E/test_1108.txt"));

            // NIO
            FileChannel readChannel = fis.getChannel();
            FileChannel writeChannel = fos.getChannel();

            // 初始化一个缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 读取数据到缓冲区
            readChannel.read(buffer);
            // 读写转换
            buffer.flip();

            writeChannel.write(buffer);

            // 重置缓冲区
            buffer.clear();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
