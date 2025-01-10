package p20250110_Supermarket;
import java.math.BigDecimal;
import java.util.Queue;

public class Commesso extends Thread{
	private static int n_instance = 1; 
	public int id;
	
	private Queue<Cliente> c;
	
	
	
	protected Commesso() {
		super();
		id = n_instance;
		n_instance++;
	}

	
	public Queue<Cliente> getC() {
		return c;
	}

	public void setC(Queue<Cliente> c) {
		this.c = c;
	}


	
	
	public void run() {
		long startTime;
		long exeTime;
		while(true) {
			if(c.isEmpty()) continue;
			
			startTime = System.currentTimeMillis();
			Cliente c1 = c.remove();
			System.out.println("Commesso: " + this.id + " serve Cliente: " + c1.id );
			
			int prodotti = c1.getN_prodotti();
			for(int i=0; i<prodotti; i++) {
				c1.decrementProdotto();
				//System.out.println("Commesso: " + this.id + " serve Cliente: " + c1.id + " sul prodotto numero= " + (prodotti-c1.getN_prodotti()) );
				
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			exeTime = System.currentTimeMillis() - startTime;
			System.out.println("FIN Commesso: " + this.id + " ha servito Cliente: " + c1.id + " in " + exeTime + " millisecondi");
			
		}
		
	}
}
