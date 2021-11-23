package com.calc.review.p5.p2021_11_13;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/13
 */
public class NIOSelectorServer {

    // 多路复用器
    static Selector selector;

    public static void main(String[] args) throws Exception{

        try {

            // 创建一个多路复用器
            selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 多路复用器的情况下，必须设置为非阻塞false
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(9090));

            // 把我们当前的serverSocketChannel注册到多路复用器上面,监听连接事件
            SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {

                // 阻塞
                selector.select();
                // 拿到所有注册到
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {

                    SelectionKey selectionKey = iterator.next();
                    // 避免重复处理
                    iterator.remove();

                    if (selectionKey.isAcceptable()) { // 连接事件

                        handleAccept(selectionKey);
                    }else if (selectionKey.isReadable()) { // 读事件

                        handleRead(selectionKey);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleAccept(SelectionKey selectionKey) throws Exception{

        ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();

        // 一定存在连接
        SocketChannel socketChannel  = serverSocketChannel.accept();
        // 设置非阻塞
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("hello Client-01 Selector".getBytes()));
        // 这里注册的是SocketChannel的读事件
        socketChannel.register(selector,SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey selectionKey) throws Exception{

        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        System.out.println("server receive Msg" + new String(byteBuffer.array()));
    }
}
