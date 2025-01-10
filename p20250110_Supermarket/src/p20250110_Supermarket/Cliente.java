package p20250110_Supermarket;

import java.util.Random;

public class Cliente{
	private static int n_instance = 1;
	public int id;
	
	private int n_prodotti;

	public Cliente() {
		super();
		id = n_instance;
		n_instance++;
		Random r = new Random();
		setN_prodotti(r.nextInt(1,31));
	}
	
	

	public int getN_prodotti() {
		return n_prodotti;
	}

	public void setN_prodotti(int n_prodotti) {
		this.n_prodotti = n_prodotti;
	}
	
	
	public void decrementProdotto() {
		setN_prodotti(getN_prodotti() - 1);
	}

}
