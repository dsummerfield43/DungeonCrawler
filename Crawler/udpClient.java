package Crawler;
import java.io.*;
import java.net.*; 
import java.util.*;
 
  class udpClient 
 { 
 	public static void main(String[] args) throws Exception 
 	{ 
 		Scanner scan = new Scanner(System.in);
 		
 		InetAddress ip = InetAddress.getByName("localhost");  //uses IPv4 Address
 		
 		DatagramSocket ds = new DatagramSocket(8001); 
 		
 		String input = "w";
 		
 		while(!input.equals("x"))
 		{
 				System.out.println("Enter your new message or press x to exit: "); //Gets user input
 				input = scan.next();
 				
 				byte [] b = input.getBytes();  //Creates a byte using the users input to be sent in a packet
 				DatagramPacket dp = new DatagramPacket(b,b.length,ip,8000); // Creates the packet
 				ds.send(dp);  		//Sends the packet
 				
 				
 				byte [] b2 = new byte [2048];  //Creates a 2nd byte so you can store the new received byte
 				DatagramPacket dp2 = new DatagramPacket(b2,b2.length); // Creates the packet
 		    	ds.receive(dp2);  //Receives packet with output from the server
 				
 				String output = new String(b2); // Changes the output from a byte array to a string
 				System.out.println(output); // Prints the all upper case output
 		}
 	}
}