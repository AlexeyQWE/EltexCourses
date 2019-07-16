package eltex.tasks;

import java.io.IOException;
import java.net.*;

public class Client {

    public static void main(String[] args) {

        try {
            byte [] data = "Hello".getBytes();
            InetAddress addr = InetAddress.getByName("192.168.1.163");
            DatagramPacket pack = new DatagramPacket(data, data.length, addr, 1025);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pack);
            ds.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
