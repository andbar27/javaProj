package p20112024_01_Esercizio;

public class CoppiaInt {
	private Integer f;
	private Integer s;
	
	public CoppiaInt(Integer f, Integer s) {
		super();
		this.f = f;
		this.s = s;
	}
	

	public Integer getF() {
		return f;
	}
	public void setF(Integer f) {
		this.f = f;
	}
	public Integer getS() {
		return s;
	}
	public void setS(Integer s) {
		this.s = s;
	}
	

	@Override
	public String toString() {
		return "CoppiaInt [f=" + f + ", s=" + s + "]";
	}
}
