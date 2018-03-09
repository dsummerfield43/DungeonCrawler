package Crawler;
import java.io.*;
import java.net.*;

public class udpServer
{
	public static void main(String[] args) throws Exception
	{
		
			
		DatagramSocket ds = new DatagramSocket(8000); //Creates the socket for UDP connection
		
		
		while(true)
		{
		byte [] b = new byte [2048];
		DatagramPacket dp = new DatagramPacket(b,b.length); //Creates the first packet
		ds.receive(dp);  //Receives packet as lower case
		
		byte[] packetData = dp.getData(); // Gets the input from the packet
		String input = new String(packetData); // Changes the byte array to a string that can be worked with
		
		String inputUpper = input.toUpperCase(); // Changes the string to all upper case letters
		
		byte [] b2 = inputUpper.getBytes(); //Creates a second byte with the new all upper case string
		DatagramPacket dp2 = new DatagramPacket(b2, b2.length, dp.getAddress(), dp.getPort()); //Creates the second packet
		
		ds.send(dp2); //Sends the packet back 
		
		} 	
 } 
 }