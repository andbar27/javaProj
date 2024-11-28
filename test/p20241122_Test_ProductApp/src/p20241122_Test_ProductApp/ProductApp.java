package p20241122_Test_ProductApp;

import java.util.Comparator;
import java.util.List;

public class ProductApp {

	public static void main(String[] args) {
		ProductManager pa = new ProductManager();
		
		ProdottoAbbigliamento p1 = new ProdottoAbbigliamento("a1", 1000.0, "abbigliamento invernale");
		ProdottoAbbigliamento p2 = new ProdottoAbbigliamento("a2", 1500.0, "bbigliamento invernale");
		ProdottoAbbigliamento p3 = new ProdottoAbbigliamento("a3", 701.0, "abbigliamento invernale");
		ProdottoAbbigliamento p4 = new ProdottoAbbigliamento("a4", 251.0, "abbigliamento invernale");
		ProdottoElettronica e1 = new ProdottoElettronica("b1", 500.0, "b1");
		ProdottoElettronica e2 = new ProdottoElettronica("b2", 501.0, "b2");
		ProdottoElettronica e3 = new ProdottoElettronica("b3", 1000.0, "b3");
		ProdottoElettronica e4 = new ProdottoElettronica("b4", 750.0, "b4");
		
		pa.addProduct(p1);
		pa.addProduct(p2);
		pa.addProduct(p3);
		pa.addProduct(p4);
		pa.addProduct(e1);
		pa.addProduct(e2);
		pa.addProduct(e3);
		pa.addProduct(e4);
		
		System.out.println("Lista prodotti:");
		pa.viewProduct();
		
		
		System.out.println("\nOrdinati per prezzo base:");
		
		List<Prodotto> lp = pa.sortByPrice(pa.listaProdotti);
		
		for(Prodotto p : lp){
			System.out.println(p);
		}
		
		lp.sort(new Comparator<Prodotto>() {
			public int compare(Prodotto p1, Prodotto p2) {
				return p1.calculateDiscount().compareTo(p2.calculateDiscount());
			}
		});
		
		System.out.println("\nOrdinati per prezzo scontato:");
		
		for(Prodotto p : lp){
			System.out.println(p + " prezzo_scontato=" + p.calculateDiscount());
		}
		
	}

}
