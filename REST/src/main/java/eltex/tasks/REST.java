package eltex.tasks;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class REST {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8082);
        while (true) {
            Socket client = server.accept();
            new Thread (() -> {
                try {
                    InputStream inStream = client.getInputStream();
                    Scanner in = new Scanner(inStream);
                    String client_request = in.nextLine();
                    System.out.println(client_request);
                    String output = "HTTP/1.1 200 OK\n\nHello!";
                    OutputStream outStream = client.getOutputStream(); 
                    PrintWriter out = new PrintWriter(outStream);
                    out.write(output);
                    out.flush();
                    client.close();
                }
                catch (IOException e) {
                    System.err.println(e.getMessage());
                }

            }).start();         
       }

    }
}   
