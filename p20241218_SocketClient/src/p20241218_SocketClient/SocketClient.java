package p20241218_SocketClient;

//Simple Java Socket Client
import java.io.*;
import java.net.*;

public class SocketClient {
	public void run(String hostname, int port) {

		try (Socket socket = new Socket(hostname, port);
				OutputStream output = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true);
				InputStream input = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

			System.out.println("Connected to the server");

			// Sending messages to the server
			writer.println("Hello Server");
			String response = reader.readLine();
			System.out.println(response);

			writer.println("bye");
			response = reader.readLine();
			System.out.println(response);

		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O error: " + ex.getMessage());
		}
	}
}