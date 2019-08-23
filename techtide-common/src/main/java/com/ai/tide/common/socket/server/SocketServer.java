package com.ai.tide.common.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/23 16:27
 **/
public class SocketServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);

            Socket incoming = serverSocket.accept();

            InputStream inputStream = incoming.getInputStream();

            OutputStream outputStream = incoming.getOutputStream();

            Scanner in = new Scanner(inputStream, "UTF-8");

            PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"),true);
            out.println("Hello! Enter BYE to exit.");

            boolean done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println("Echo: " + line);
                if (line.trim().equals("BYE"))
                    done = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
