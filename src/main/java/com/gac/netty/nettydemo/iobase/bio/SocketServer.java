package com.gac.netty.nettydemo.iobase.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO 同步阻塞，每个客户端对应一个处理线程
 * @author gzj
 * @date 2021/2/26 9:46
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);

        while (true) {
            System.out.println("等待连接。。。");
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了。。。");
            handler(clientSocket);
        }

    }

    private static void handler(Socket clientSocket) throws IOException {

        byte[] bytes = new byte[1024];
        System.out.println("准备read客户端数据。。");
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read结束。。 " + read);
        if (-1 != read) {
            System.out.println("读取到客户端数据：" + new String(bytes, 0, read));
        }

        clientSocket.getOutputStream().write("我是服务端".getBytes());
        clientSocket.getOutputStream().flush();
    }
}
