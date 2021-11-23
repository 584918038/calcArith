package com.calc.review.p5.p2021_11_09;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/9
 */
public class MMAPDemo {

    public static void main(String[] args) throws Exception{

        FileChannel inChannel = FileChannel.open(Paths.get("/Users/xuenhan/Downloads/格家新人介绍PPT模板.pptx"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("/Users/xuenhan/Downloads/格家新人介绍PPT模板_MMAP.pptx"),StandardOpenOption.READ,StandardOpenOption.CREATE,StandardOpenOption.WRITE);

        MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        byte[] bytes = new byte[inMappedBuffer.limit()];

        inMappedBuffer.get(bytes);
        outMappedBuffer.put(bytes);

        inChannel.close();
        outChannel.close();
    }
}
