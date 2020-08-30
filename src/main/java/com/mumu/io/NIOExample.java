package com.mumu.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/8/29
 */
public class NIOExample {

    public static void main(String[] args) throws Exception {
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open(); // 服务端开启监听；接收客户端
        ss.bind(new InetSocketAddress(9090));
        ss.configureBlocking(false);  // 重点 OS NONBLOCKING // 只让接受客户端 不阻塞！！！

        while (true) {

            // 接受客户端连接
            Thread.sleep(1000);
            SocketChannel client = ss.accept(); // 不会阻塞 ？ -1 NULL
            // accept 调用内核了： 1 没有客户端连接进来，返回值 ？ 在BIO时一直卡着，但是在NIO，不卡着 返回-1
            // 如果客户端连接进来，accept 返回这个客户端的fd 5 , client object
            // NONBLOCKING 就是代码能往下走了，只是有不同的情况

            if (client == null) {
                System.out.println("null...");
            } else {
                client.configureBlocking(false); //
                int port = client.socket().getPort();
                System.out.println("client..port: " + port);
                clients.add(client);
            }

            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);// 可以 在堆里 堆外

            //遍历已经连接进来的客户端能不能读写数据
            for (SocketChannel socketChannel : clients) {// 串行化  多线程
                int num = client.read(buffer); // >0 -1 0 // 不会阻塞
                if (num > 0) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.limit()];
                    buffer.get(bytes);

                    String b = new String(bytes);
                    System.out.println(client.socket().getPort() + " : " + b);
                    buffer.clear();
                }

            }

        }
    }

}
