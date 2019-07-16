package eltex.tasks;

import java.io.IOException;
import java.net.*;

public class Client {

    public static void main(String[] args) {

        try {
            byte [] data = "Hello".getBytes();
            InetAddress addr = InetAddress.getByName("172.21.0.133");
            DatagramPacket pack = new DatagramPacket(data, data.length, addr, 1050);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pack);
            ds.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
