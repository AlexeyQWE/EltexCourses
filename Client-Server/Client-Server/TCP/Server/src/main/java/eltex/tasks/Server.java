package eltex.tasks;

import java.io.*;
import java.net.*;
        import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket s = new ServerSocket(1025)) {
            Socket client = s.accept();
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);
            out.write("hello");
            out.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
