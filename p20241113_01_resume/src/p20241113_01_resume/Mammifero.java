package p20241113_01_resume;

public abstract class Mammifero {
	private Integer freqResp;
	private Integer freqCardio;
	public abstract String Verso();
	public Mammifero(Integer freqResp, Integer freqCardio) {
		super();
		this.freqResp = freqResp;
		this.freqCardio = freqCardio;
	}
	public Mammifero() {
		super();
	}
	@Override
	public String toString() {
		return "Mammifero [freqResp=" + freqResp + ", freqCardio=" + freqCardio + "]";
	}
	public Integer getFreqResp() {
		return freqResp;
	}
	public void setFreqResp(Integer freqResp) {
		this.freqResp = freqResp;
	}
	public Integer getFreqCardio() {
		return freqCardio;
	}
	public void setFreqCardio(Integer freqCardio) {
		this.freqCardio = freqCardio;
	}
	
	
}
