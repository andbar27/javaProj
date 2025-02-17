package p20250207_ESAME_Domanda2;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		String[] messaggi = {"ciao", "messaggio2", "ao", "bella", "buonasera",
				"quinto", "sesto", "terzultimo", "penultimo", "ultimo"};
		LinkedList<String> lm = new LinkedList<>(Arrays.asList(messaggi));
		Posta p = new Posta();
		Mittente m = new Mittente(p, lm);
		Destinatario d = new Destinatario(p);

		Thread tm = new Thread(m);
		Thread td = new Thread(d);
		
		m.setTempoDiSleep(0);
		tm.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.setTempoDiSleep(2000);
		
		System.out.println("tempi di sleep (mittente lento) \n");
		
		
		td.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\n cambio i tempi di sleep (destinatario lento) \n");
		m.setTempoDiSleep(0);
		d.setTempoDiSleep(2000);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\n cambio i tempi di sleep (vanno veloci uguale)\n");
		m.setTempoDiSleep(2);
		d.setTempoDiSleep(2);
	}

}
