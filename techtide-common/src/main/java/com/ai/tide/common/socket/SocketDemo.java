package com.ai.tide.common.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/23 15:58
 **/
public class SocketDemo {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.baidu.com", 8080);
            Scanner in = new Scanner(s.getInputStream(), "UTF-8");
            while (in.hasNext()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
