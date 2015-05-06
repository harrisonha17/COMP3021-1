package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadHandler implements Runnable{
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	int id;
	public ThreadHandler(Socket client, int count){
		try{
			sock = client;
			id = count;
			InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(isReader);
			writer = new PrintWriter(sock.getOutputStream(), true);
		} catch (Exception e) { e.printStackTrace();}
	}
	@Override
	public void run() {
		String message;
		try{
			while((message = reader.readLine()) != null ){
				if( message.intern() == "quit" )
					break;
				else if ( message.intern() == "visitor")
					writer.println("You're the "+id+" visitor today");
				else
					writer.println("echo: "+message);
			}
			sock.close();
			reader.close();
			writer.close();
		} catch (Exception e) {e.printStackTrace();}
	}
}
