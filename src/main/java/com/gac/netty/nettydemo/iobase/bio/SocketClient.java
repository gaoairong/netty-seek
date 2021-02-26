package com.gac.netty.nettydemo.iobase.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author gzj
 * @date 2021/2/26 9:47
 */
public class SocketClient {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9000);
        socket.getOutputStream().write("Yeah".getBytes());
        socket.getOutputStream().flush();
        System.out.println("向服务端发送数据结束");

        byte[] bytes = new byte[1024];
        int read = socket.getInputStream().read(bytes);
        System.out.println(read);

        System.out.println("接收服务端数据：" + new String(bytes));
        socket.close();
    }
}
