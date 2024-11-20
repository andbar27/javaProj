package p20112024_01_Esercizio;

public class Motociclo extends Automezzo{
	private Integer cilindrata;
	private Integer consumo;
	
	public Motociclo(int numero_ruote, String carburante, Integer cilindrata, Integer consumo) {
		super(numero_ruote, carburante);
		this.cilindrata = cilindrata;
		this.consumo = consumo;
	}
	
	

	public Integer getCilindrata() {
		return cilindrata;
	}



	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}



	public Integer getConsumo() {
		return consumo;
	}



	public void setConsumo(Integer consumo) {
		this.consumo = consumo;
	}



	@Override
	protected Double getMaxSpeed() {
		return 7.0;
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
		return "Motociclo [cilindrata=" + cilindrata + ", consumo=" + consumo + "]";
	}
	
	

}
