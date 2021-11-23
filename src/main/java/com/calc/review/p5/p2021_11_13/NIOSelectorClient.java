package com.calc.review.p5.p2021_11_13;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/13
 */
public class NIOSelectorClient {

    // 多路复用器
    static Selector selector;

    public static void main(String[] args) {

        try {

            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 9090));
            socketChannel.register(selector, SelectionKey.OP_CONNECT);

            while (true) {

                selector.select();
                // 拿到所有注册到
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {

                    SelectionKey selectionKey = iterator.next();
                    // 避免重复处理
                    iterator.remove();

                    if (selectionKey.isAcceptable()) { // 连接事件

                        handleConnect(selectionKey);
                    } else if (selectionKey.isReadable()) { // 读事件

                        handleRead(selectionKey);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleConnect(SelectionKey key)throws Exception {

        SocketChannel socketChannel =(SocketChannel) key.channel();

        if (socketChannel.isConnectionPending()) {
            socketChannel.finishConnect();
        }

        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("hello server, nio client-01".getBytes()));
        socketChannel.register(selector,SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key) throws Exception{

        SocketChannel socketChannel = (SocketChannel)key.channel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        socketChannel.read(byteBuffer);

        System.out.println("client receive msg:" + new String(byteBuffer.array()));

    }
}
