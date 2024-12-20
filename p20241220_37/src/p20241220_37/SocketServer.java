package p20241220_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


class Server extends Thread {
	public static int v_banco = 0;
	public static int v_player = 0;
	Socket socket;
	
	public Server(Socket socket) {
		super();
		this.socket = socket;
	}
	
	private static String gameMenu() {
		return "C) Chiedi Carta\nS) Stai\nBye) Chiudi";
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
			while(true) {
				// Inizializzo il gioco
				SetteEMezzo game = new SetteEMezzo();
				writer.println("Start Game: ");
				game.startGame();
				writer.println(game.printGame());
				writer.println(gameMenu());
				
				
				// Inizio a leggere e a scrivere finché non mi arriva la stringa "bye"
				String cmd;
				
				while ((cmd = reader.readLine().toLowerCase()) != null) {
					System.out.println("Received: " + cmd);
					
					if(cmd.equals("bye")) {
						writer.println("connessione chiusa");
						return;
					}
					
					if(cmd.equals("s")) {
						break;
					}
					
					if(cmd.equals("c")) {
						game.playerPesca();
						writer.println(game.printGame());
						writer.println(gameMenu());
					}
					
					if(game.getSomma_player() > 7.5)
						break;
				}
				
				writer.println("End Game");
				writer.println(game.printGame(true));
				
				if(game.getSomma_player() > 7.5) {
					writer.println("Banco Vince\n\n");
					Server.v_banco++;
					System.out.println("Vittorie Banco: " + Server.v_banco);
					continue;
				}
					
				while(game.getSomma_player() > game.getSomma_banco()) {
					game.bancoPesca();
					writer.println(game.printGame(true));
				}
				
				if(game.getSomma_banco() > 7.5) { 
					writer.println("Player Vince\n\n");
					Server.v_player++;
					System.out.println("Vittorie Player: " + Server.v_player);
					continue;
				}
				
				
				writer.println("Banco Vince\n\n");
				Server.v_banco++;
				System.out.println("Vittorie Banco: " + Server.v_banco);
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
