package p20112024_01_Esercizio;

public abstract class Automezzo implements Comparable<Automezzo>{
	private int numero_ruote;
	private String carburante;
	
	protected abstract Double getMaxSpeed();

	public Automezzo(int numero_ruote, String carburante) {
		super();
		this.numero_ruote = numero_ruote;
		this.carburante = carburante;
	}

	public int getNumero_ruote() {
		return numero_ruote;
	}

	public void setNumero_ruote(int numero_ruote) {
		this.numero_ruote = numero_ruote;
	}

	public String getCarburante() {
		return carburante;
	}

	public void setCarburante(String carburante) {
		this.carburante = carburante;
	}
	
	protected abstract Integer getConsumo();

	@Override
	public abstract int compareTo(Automezzo o);

}
