package net;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
	public static final int PORT = 3021;

	public static void main(String[] args){
		new MultiThreadServer().go();
	}

	public void go(){
		try{
			ServerSocket server = new ServerSocket(PORT);
			int clientCount = 0;
			while(true){
				Socket client = server.accept();
				++clientCount;
				Thread t = new Thread(new ThreadHandler(client, clientCount));
				t.start();
			}
		}catch(Exception e){
			e.printStackTrace();}
	}
}