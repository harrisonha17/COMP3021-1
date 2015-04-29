package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BlogServer {
	public static final int PORT = 3021;

	public static void main(String[] args){
		try(
				ServerSocket server = new ServerSocket(PORT);
				Socket client = server.accept();
				BufferedReader in = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
				){
			String inputLine;
	    	System.out.println("Some client connected!");
		    while ((inputLine = in.readLine()) != null) {
		    	System.out.println("Receiving data from client...");
		    	System.out.println(inputLine);
		    }
		    in.close();
		    client.close();
		    server.close();
		}catch(Exception e){
			e.printStackTrace();}
	}
}
