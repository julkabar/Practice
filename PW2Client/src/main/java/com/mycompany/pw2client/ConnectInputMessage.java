/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pw2client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ConnectInputMessage implements Runnable{
    private Socket serverConnect;
    private InputStream inputStreamServer;

    public ConnectInputMessage() {
        try {
            serverConnect = new Socket("localhost", 8887);
            inputStreamServer = serverConnect.getInputStream();
        } catch(ConnectException e){
            System.out.println("SERVER NOT FOUND");
            System.exit(0);
        } 
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMessage;

        while (true) {
            try {
                serverMessage = in.readLine();
                if (serverMessage != null) {
                    System.out.println(serverMessage + '\n');
                    break;
                }
            } catch(NullPointerException e){
                System.out.println("IN: NO CONNECTION");
                break;
            }
            catch (IOException e) { //реалізувати обробку винятків
                throw new RuntimeException(e);
            }
        }

        PrintWriter out = null;
        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));

        String userMessage = null;

        while (true) {
            System.out.println("Enter message: ");
            try {
                userMessage = inputUser.readLine();
                out = new PrintWriter(serverConnect.getOutputStream(), true);
                out.println(userMessage);
            } catch(NullPointerException e){
                System.out.println("OUT: NO CONNECTION");
                break;
            }
            catch (IOException e) { //реалізувати обробку винятків
                throw new RuntimeException(e);
            }
        } 
    }

    public InputStream getInputStreamServer() {
        return inputStreamServer;
    }
}
