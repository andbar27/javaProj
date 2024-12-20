package p20241220_37;

import java.util.Scanner;

import p20241220_37.SocketServer;

public class Main {
	
	private static String gameMenu() {
		return "C) Chiedi Carta\nS) Stai";
	}

	public static void main(String[] args) {
		SetteEMezzo game = new SetteEMezzo();
		Scanner s = new Scanner(System.in);
		
		// Start
		System.out.println("Start Game: ");
		game.startGame();
		System.out.println(game.printGame());
		
		// Play
		String cmd = "";
		while(!cmd.equals("s")) {
			System.out.println(gameMenu());
			
			cmd = s.nextLine().toLowerCase();
			System.out.println("comando: " + cmd);
			
			if(cmd.equals("c")) {
				game.playerPesca();
				System.out.println(game.printGame());
			}
			
		}
		
		// End
		System.out.println("End Game: ");
		game.endGame();
		s.close();
		
// ---------------------------------------------------------------------
		// Start Server Game!
		
		SocketServer srv = new SocketServer();
		
		srv.Server(32456);
	}

}
