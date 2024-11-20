package p20112024_01_Esercizio;

public class Autovettura extends Automezzo{
	private Integer cilindrata;
	private Integer consumo;
	
	

	public Autovettura(int numero_ruote, String carburante, int cilindrata, int consumo) {
		super(numero_ruote, carburante);
		this.cilindrata = cilindrata;
		this.consumo = consumo;
	}



	public Integer getCilindrata() {
		return cilindrata;
	}



	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}



	public Integer getConsumo() {
		return consumo;
	}



	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}



	@Override
	public Double getMaxSpeed() {
		// TODO Auto-generated method stub
		return 5.5;
	}



	@Override
	public int compareTo(Automezzo o) {
		int ret = this.getMaxSpeed().compareTo(o.getMaxSpeed());
		if(ret == 0)
			ret = this.getConsumo().compareTo(o.getConsumo());
		return ret;
	}



	@Override
	public String toString() {
		return "Autovettura [cilindrata=" + cilindrata + ", consumo=" + consumo + ", getMaxSpeed()=" + getMaxSpeed()
				+ ", getNumero_ruote()=" + getNumero_ruote() + ", getCarburante()=" + getCarburante() + "]";
	}
	
	

}
