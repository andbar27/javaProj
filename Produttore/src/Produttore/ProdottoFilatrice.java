package Produttore;

public class ProdottoFilatrice {
	private String id_filatrice;
	private Prodotto p;
	
	
	protected ProdottoFilatrice(String id_filatrice, Prodotto p) {
		super();
		this.id_filatrice = id_filatrice;
		this.p = p;
	}


	public String getId_filatrice() {
		return id_filatrice;
	}


	public void setId_filatrice(String id_filatrice) {
		this.id_filatrice = id_filatrice;
	}


	public Prodotto getP() {
		return p;
	}


	public void setP(Prodotto p) {
		this.p = p;
	}


	@Override
	public String toString() {
		return "ProdottoFilatrice [id_filatrice=" + id_filatrice + ", p=" + p + "]";
	}
	
}
