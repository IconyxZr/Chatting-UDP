/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/**
 *
 * @author ASUS
 */
public class Client {
    public static void main(String[] args) throws SocketException, IOException {
        
      BufferedReader clientRead =new BufferedReader(new InputStreamReader(System.in));
      InetAddress IP = InetAddress.getByName("10.8.5.62");
      DatagramSocket clientSocket = new DatagramSocket();
      
      while(true) {
      byte[] sendbuffer = new byte[1024]; 
      byte[] receivebuffer = new byte[1024]; 
      System.out.print("\nClient: "); 
      String clientData = clientRead.readLine(); 
      DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP, 9876);
      clientSocket.send(sendPacket);
      
      if(clientData.equalsIgnoreCase("bye")) {
          System.out.println("Connection ended by client");
          break;
      }
      DatagramPacket receivePacket = new DatagramPacket(receivebuffer, receivebuffer.length);
      clientSocket.receive(receivePacket);
      String serverData = new String(receivePacket.getData()); 
      System.out.print("\nServer: " + serverData); 
      }
      clientSocket.close();
    }
}
