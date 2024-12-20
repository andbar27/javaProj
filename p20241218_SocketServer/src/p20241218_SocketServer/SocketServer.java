package p20241218_SocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


class Server extends Thread {
	Socket socket;
	
	public Server(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void run() {
		System.out.println("New client connected");
		
		// Handle client in a separate thread
		try (
				// Estraggo il canale di ingresso
				InputStream input = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));

				// Estraggo il canale di uscita
				OutputStream output = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true)) {

			// Inizio a leggere e a scrivere finché non mi arriva la stringa "bye"
			String text;
			
			while ((text = reader.readLine()) != null) {
				System.out.println("Received: " + text);

				// Echo the received message
				writer.println("Server: " + text);

				// Exit condition
				if ("bye".equalsIgnoreCase(text)) {
					System.out.println("Client disconnected");
					break;
				}
			}
			
		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		
	}
	
}



public class SocketServer {
	
	public void Server(int port) {
		// int port = 12345; // Port number

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			// Creo il socket sul quale sarò in "ascolto"
			System.out.println("Server is listening on port " + port);
			while(true) {
				// resta in attesa finché un "client" chiederà di collegarsi
				Socket socket = serverSocket.accept();
				Server server = new Server(socket);
				server.start();
			}
				
		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}