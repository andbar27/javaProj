package p20241122_Test_ProductApp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProductManager implements Ordinable{
	List<Prodotto> listaProdotti = new LinkedList<Prodotto>();
	
	public void addProduct(Prodotto p) {
		listaProdotti.add(p);
	}
	
	public void viewProduct() {
		for(Prodotto p : this.listaProdotti){
			System.out.println(p);
		}
	}
	
	@Override
	public List<Prodotto> sortByPrice(List<Prodotto> products) {
		int len = this.listaProdotti.size();
		
		List<Prodotto> lp = (List<Prodotto>) this.listaProdotti.subList(0, len);
		
		Collections.sort(lp);
		
		return lp;
	
	}
}
