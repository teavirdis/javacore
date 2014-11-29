package by.bsuir.houses.server.threaded;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import by.bsuir.houses.server.pool.ConnectionPool;

public class ThreadedServer {
	
	private static final Logger log = Logger.getLogger(ThreadedServer.class);

	public static void start() {
		try {
			ServerSocket serverSocket = new ServerSocket(8981);
			while(true){
				Socket socket = serverSocket.accept();
				ThreadedHandler handler = new ThreadedHandler(socket);
				Thread thread = new Thread(handler);
				thread.start();
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
}
