package by.bsuir.houses.client.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import by.bsuir.houses.model.covers.Request;
import by.bsuir.houses.model.covers.Response;

public class TCPClient {

	private static final int SERVER_PORT = 8080;
	private static final String SERVER_HOST = "localhost";
	private static final Logger log = Logger.getLogger(TCPClient.class);

	public static Response send(Request request) {
		Socket socket = null;
		Response response = null;
		try {
			InetAddress serverHost = InetAddress.getByName(SERVER_HOST);
			socket = new Socket(serverHost, SERVER_PORT);
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			oos.writeObject(request);
			oos.flush();
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			response = (Response) ois.readObject();

		} catch (UnknownHostException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage());
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			}
		}
		return response;
	}

}
