package eltex.tasks;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class HTTPServer {

    public static void main(String[] args) throws IOException {
    
        String path = "/home/alexey/Летняя школа/EltexCourses/WebServer/res/index.html";

        File file = new File (path);
        Scanner scan = new Scanner (file).useDelimiter("\0");
        String html_doc = scan.next();

        String output = "HTTP/1.0 200 OK\nContent-Length:" + html_doc.length() + "\n\n" + html_doc;

        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket client = server.accept();
            new Thread (() -> {
                try {
                     OutputStream outStream = client.getOutputStream(); 
                     PrintWriter out = new PrintWriter(outStream);
                    out.write(output);
                    out.flush();
                }
                catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }).start();         
       }

    }
}
