package p20112024_01_Esercizio;

public class Coppia <T1, T2> {
	private T1 f;
	private T2 s;
	
	public Coppia(T1 f, T2 s) {
		super();
		this.f = f;
		this.s = s;
	}
	
	
	public T1 getF() {
		return f;
	}
	public void setF(T1 f) {
		this.f = f;
	}
	public T2 getS() {
		return s;
	}
	public void setS(T2 s) {
		this.s = s;
	}
	
	public void swapCoppia(Coppia<T1,T2> o) {
		T1 temp1 = this.f;
		this.f = o.f;
		o.f = temp1;
		T2 temp2 = this.s;
		this.s = o.s;
		o.s = temp2;
	}
	
	
	@Override
	public String toString() {
		return "Coppia [f=" + f + ", s=" + s + "]";
	}
	
}
