package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
	// write your code here
        try {
            createSocket();
        }
        catch(Exception e){
            System.out.println("This is an exception: " + e.getLocalizedMessage());
        }

    }

    public static void createSocket() throws IOException {

        var serverSocket = new ServerSocket(6789,1);

        Socket newConnection = serverSocket.accept();

        System.out.println("Someone has connected!");

        Scanner s = new Scanner(System.in);

        s.nextLine();




    }

}
