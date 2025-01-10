package p20250110_Supermarket;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) {
		Queue<Cliente> lista_clienti = new LinkedList<Cliente>();
		
		for(int i=0; i<30; i++) {
			lista_clienti.add(new Cliente());
		}
		for(int i=0; i<3; i++) {
			Commesso c = new Commesso();
			c.setC(lista_clienti);
			c.start();
		}
	}

}
