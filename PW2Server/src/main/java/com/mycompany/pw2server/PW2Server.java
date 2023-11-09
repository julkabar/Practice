/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pw2server;

/**
 *
 * @author Admin
 */
public class PW2Server {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        Thread tChatServer = new Thread((Runnable) chatServer);
        tChatServer.start();
    }
}
