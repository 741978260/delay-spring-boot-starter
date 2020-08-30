package com.mumu.io;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description BIO每连接对应每线程
 * @Author Created by Mumu
 * @Date on 2020/8/29
 */
public class BIOExample {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("step1: new ServerSocket(9090)");

        while (true) {
            Socket client = serverSocket.accept(); // 阻塞1
            System.out.println("step2: client\t" + client.getPort());

            new Thread(() -> {
                InputStream inputStream = null;
                try {
                    inputStream = client.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        String dataLine = br.readLine();// 阻塞2
                        if (!StringUtils.isEmpty(dataLine)) {
                            System.out.println(dataLine);
                        } else {
                            client.close();
                            break;
                        }
                    }
                    System.out.println("客户端断开");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();

        }
    }
}
