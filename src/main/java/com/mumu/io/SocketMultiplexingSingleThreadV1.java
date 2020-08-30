package com.mumu.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description 多路复用器 单线程版本
 * @Author Created by Mumu
 * @Date on 2020/8/29
 */
public class SocketMultiplexingSingleThreadV1 {

    private ServerSocketChannel server = null;
    private Selector selector = null;
    int port = 9090;

    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            selector = Selector.open();

            server.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        initServer();
        System.out.println("服务器启动了...");
        while (true) {

            Set<SelectionKey> keys = selector.selectedKeys();
            System.out.println(keys.size() + "  size");

            while (true) {
                try {

                    while (selector.select() > 0) {

                        Set<SelectionKey> selectionKeys = selector.selectedKeys(); // 返回有状态的 fd集合
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();

                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            iterator.remove();
                            if (key.isAcceptable()) {
                                acceptHandler(key);
                            } else if (key.isReadable()) {
                                readHandler(key);
                            }

                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        }
    }

    private void readHandler(SelectionKey key) {

    }

    private void acceptHandler(SelectionKey key) {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        try {
            SocketChannel client = ssc.accept();
            client.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocate(8192);

            client.register(selector, SelectionKey.OP_READ, buffer);
            System.out.println("-----------------------------------");
            System.out.println("新客户端： " + client.getRemoteAddress());
            System.out.println("-----------------------------------");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

    }
}
