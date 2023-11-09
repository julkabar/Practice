/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pw2client;

/**
 *
 * @author Admin
 */
public class PW2Client {

    public static void main(String[] args) {
        ConnectInputMessage connectWithServer = new ConnectInputMessage();
        Thread tConnectInputMessage = new Thread(connectWithServer);
        tConnectInputMessage.start();

        ReceiveMessageFromServer receiveMessage =
                new ReceiveMessageFromServer(connectWithServer.getInputStreamServer());
        Thread tReceiveMessage = new Thread(receiveMessage);
        tReceiveMessage.start();
    }
}
