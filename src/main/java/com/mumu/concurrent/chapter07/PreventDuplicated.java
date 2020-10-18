package com.mumu.concurrent.chapter07;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Description 比如为防止某个程序被重复启动，在进程启动时会创建一个lock文件，进程收到中断信号时会删除这个lock文件
 * 我们在mysql服务器、zookeeper 、kafka等系统中都能看的lock文件的存在
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public class PreventDuplicated {

    private final static String LOCK_PATH = "/home/mumu/locks/";

    private final static String LOCK_FILE = ".lock";

    private static final String PERMISSIONS = "rw------";

    public static void main(String[] args) throws IOException {
        // 注入hook线程，在程序退出时删除lock文件
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The program received kill SIGNAL");
            getLockFile().toFile().delete();
        }));

        // 检查是否存在.lock文件
        checkRunning();

        // 简单模拟当前程序正在运行
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkRunning() throws IOException {
        final Path path = getLockFile();
        if (path.toFile().exists()) {
            throw new RuntimeException("The program already running.");
        }
        final Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString(PERMISSIONS);
        Files.createFile(path, PosixFilePermissions.asFileAttribute(posixFilePermissions));
    }

    private static Path getLockFile() {
        return Paths.get(LOCK_PATH, LOCK_FILE);
    }
}
