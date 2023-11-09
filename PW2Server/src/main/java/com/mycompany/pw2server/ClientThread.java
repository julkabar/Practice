/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pw2server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Admin
 */
public class ClientThread implements Runnable{
    Socket clientSocket;
    ChatServer chatServer;
    int nClient;
    
    public ClientThread(Socket clientSocket, ChatServer chatServer, int number){
        this.clientSocket = clientSocket;
        this.chatServer = chatServer;
        this.nClient = number;
    }
    
    @Override
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            System.out.println("Client №" + nClient + " connected.");
            new PrintWriter(clientSocket.getOutputStream(), true).println("Client №" + nClient + ".");
            String clientMessage = null;
            
            try{
                while(true){
                    clientMessage = in.readLine();
                    if(!"exit".equals(clientMessage)){
                        System.out.println("Client №" + nClient + ": " + clientMessage);
                        chatServer.SendMessageForAll(nClient, clientMessage);
                    }else{
                        in.close();
                        clientSocket.close();
                        System.out.println("SERVER: Client №" + nClient + " exit.");
                        chatServer.SendMessageForAll(nClient, " — exit.");
                        break;
                    }
                }
            }catch(SocketException e){
               in.close();
               clientSocket.close();
               System.out.println("Client №" + nClient + " disconnected.");
            }
        }catch(IOException e){ //обробка винятків, закриття потоку та сокетів --------------------------------------------------
            throw new RuntimeException(e);
        }
    }
}
