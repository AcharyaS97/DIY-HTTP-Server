package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
	// write your code here
        try {
            createAndWriteToSocket();
        }
        catch(Exception e){
            System.out.println("This is an exception: " + e.getLocalizedMessage());
        }

    }

    public static void createAndWriteToSocket() throws IOException, InterruptedException {

        var serverSocket = new ServerSocket(6789,1);
        Scanner s = new Scanner(System.in);
        Socket newConnection = serverSocket.accept();

        System.out.println("Someone has connected!");

        //PrintWriter object will write to the client's output stream across the socket connection it has established
        PrintWriter out = new PrintWriter(newConnection.getOutputStream(),true);

        out.println("I'm sending something back to the client!");

        s.nextLine();
        int count = 0;
        while(count != 30){
            Thread.sleep(2000);
            out.println(count);
            count+=1;
        }

        s.nextLine();
    }



}
