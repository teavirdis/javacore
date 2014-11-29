package by.bsuir.houses.server.threaded;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import by.bsuir.houses.model.covers.Request;
import by.bsuir.houses.model.covers.Response;
import by.bsuir.houses.server.command.CommandFactory;
import by.bsuir.houses.server.dao.HouseApplicationSQLException;

public class ThreadedHandler implements Runnable {

	private static final Logger log = Logger.getLogger(ThreadedHandler.class);

	private Socket socket;

	public ThreadedHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(socket.getInputStream()));
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(socket.getOutputStream()));
			Request req = (Request) ois.readObject();
			Response resp = CommandFactory.buildCommand(req).execute();
			oos.writeObject(resp);
			oos.flush();
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage());
		} catch (HouseApplicationSQLException e) {
			log.error(e.getMessage());
		}

	}

}
