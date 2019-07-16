package eltex.tasks;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        try (Socket s = new Socket("192.168.1.163", 1025)){
            InputStream inSteam = s.getInputStream();
            OutputStream outStream = s.getOutputStream();
            Scanner in = new Scanner(inSteam);
            PrintWriter out = new PrintWriter(outStream);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
                out.write(line);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
