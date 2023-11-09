/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pw2server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Admin
 */
public class ChatServer implements Runnable{
    private Map<Integer, Socket> mapClient = new TreeMap<Integer, Socket>();
    
    @Override
    public void run(){
        try{
            ServerSocket server = new ServerSocket(8887); 
            System.out.println("Server started. Waiting for clients.");
            int nClient = 1;
            Socket client = null;
            
            while(true){
                client = server.accept();
                Thread clientThread = new Thread(new ClientThread(client, this, nClient));
                clientThread.setDaemon(true);
                clientThread.start();
                mapClient.put(nClient, client);
                nClient++;
            }
        } catch(SocketException e){
            System.out.println("SERVER ERROR.");
            System.exit(0);
        }
        catch(IOException e){ //обробка винятків 
            throw new RuntimeException(e);
        }
    }
       
    public void SendMessageForAll(int nClient, String clientMessage) throws IOException{
        PrintWriter out = null;
        List<Integer> keyList = new ArrayList<>(mapClient.keySet());
            for(int n : keyList){
                if(n != nClient){
                    try {
                        out = new PrintWriter(mapClient.get(n).getOutputStream(), true);
                        out.println("Client №" + nClient + ": " + clientMessage);     
                    } catch (SocketException e) {
                        mapClient.get(n).close();
                        mapClient.remove(n);
                        System.out.println("SERVER: Client №" + n + " delete.");
                    }
                }
            }//обробка винятків, видалення сокету проблемного користувача, закриття з'єднань --------------------------------------
            System.out.println("Clients received the message.");
    };
}
