package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
	// write your code here
        try {

            var serverSocket = new ServerSocket(6789,1);
            serverSocket.setReceiveBufferSize(4096);

            Socket newConnection = serverSocket.accept();

            System.out.println("Someone has connected!");
            System.out.println("Send a message to the client:");

            Scanner scanner = new Scanner(System.in);

            String messageToClient = scanner.nextLine();
            writeMessageToClient(newConnection,messageToClient);

            readMessageFromClient(newConnection);

            System.out.println("Closing the server");
            serverSocket.close();
        }
        catch(Exception e){
            System.out.println("This is an exception:" + e.getLocalizedMessage());
        }

    }

    public static void writeMessageToClient(Socket socketConnection,String message) throws IOException {
        //PrintWriter object will write to the client's output stream across the socket connection it has established
        PrintWriter out = new PrintWriter(socketConnection.getOutputStream(),true);
        out.println(message);
    }

    public static void readMessageFromClient(Socket socketConnection) throws IOException {

        InputStream socketInputStream = socketConnection.getInputStream();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socketInputStream);

        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);

        BufferedReader reader = new BufferedReader(inputStreamReader,socketConnection.getReceiveBufferSize());

        System.out.println("Client sent a message:" + reader.read());
    }


}
