package p20250207_ESAME_Domanda1;

public class Test {

	public static void main(String[] args) {
		Cliente c1 = new Cliente("01", "Luca", "Bianchi", "lubi@gm.it", "1234");
		Cliente c2 = new Cliente("02", "Fabio", "Rossi", "faro@vr.it", "0000");
		
		String[] negozi1 = {"pam", "conad"}; 
		Televisore t1 = new Televisore("p01", "Sharp Aquos", "Tv conveniente", 220.0, negozi1, 40);
		String[] negozi2 = {"mediaW", "uniE"}; 
		Televisore t2 = new Televisore("p02", "Samsung Top", "Tv top", 740.0, negozi2, 60);
		
		String[] negozi3 = {"deco", "md"}; 
		Smartphone s1 = new Smartphone("p03", "Brondi Uno", "Cell conveniente", 130.0, negozi3, 2);
		Smartphone s2 = new Smartphone("p04", "Iphone 19", "Cell top", 1030.0, negozi2, 60);
		
		// Registro singolo acquisto e stampo il registro vendite
		RegistroVendite rv = new RegistroVendite();
		System.out.println("Registro singolo acquisto e stampo il registro vendite");
		rv.registraAcquisto(c1, t1);
		System.out.println(rv);
		
		// Registro acquisto multiplo e stampo il registro vendite
		System.out.println("Registro acquisto multiplo e stampo il registro vendite");
		Prodotto[] lp = {t2,s2};
		rv.registraAcquisto(c2, lp);
		System.out.println(rv);
		
		// Riempio ancora un po' il registro
		rv.registraAcquisto(c2, s1);
		rv.registraAcquisto(c1, s2);
		System.out.println("\n\nRegistro Finale:");
		System.out.println(rv);
		
		
				
	}

}
