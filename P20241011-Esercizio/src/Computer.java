
public class Computer {
	
	private static int instances = 0;
	private double prezzo;
	private double peso;
	private double larghezza;
	private double altezza;
	private double profondita;
	private String produttore;
	private int annodiProduzione;
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getLarghezza() {
		return larghezza;
	}
	public void setLarghezza(double larghezza) {
		this.larghezza = larghezza;
	}
	public double getAltezza() {
		return altezza;
	}
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	public double getProfondita() {
		return profondita;
	}
	public void setProfondita(double profondita) {
		this.profondita = profondita;
	}
	public String getProduttore() {
		return produttore;
	}
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	public int getAnnodiProduzione() {
		return annodiProduzione;
	}
	public void setAnnodiProduzione(int annodiProduzione) {
		this.annodiProduzione = annodiProduzione;
	}
	
	public Computer(double prezzo, double peso, double larghezza, double altezza, double profondita, String produttore,
			int annodiProduzione) {
		super();
		this.prezzo = prezzo;
		this.peso = peso;
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.profondita = profondita;
		this.produttore = produttore;
		this.annodiProduzione = annodiProduzione;
		instances++;
	}
	@Override
	public String toString() {
		return "Computer [prezzo=" + prezzo + ", peso=" + peso + ", larghezza=" + larghezza + ", altezza=" + altezza
				+ ", profondita=" + profondita + ", produttore=" + produttore + ", annodiProduzione=" + annodiProduzione
				+ "]";
	}
	
	public static int getInstances() {
		return instances;
	}
	
	
}
