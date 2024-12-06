package p20241206_Aerei;

public class Volo {
	public String partenza;
	public String arrivo;
	public String orario;
	public boolean imbarco;
	public Aereo aereo;
	
	public Volo(String partenza, String arrivo, String orario, Aereo aereo) {
		super();
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.orario = orario;
		this.imbarco = false;
		this.aereo = aereo;
	}
	
	public Volo(Aereo aereo) {
		super();
		this.partenza = "roma";
		this.arrivo = "new york";
		this.orario = "12:00";
		this.imbarco = false;
		this.aereo = aereo;
	}
	public Volo() {
		super();
		this.partenza = "roma";
		this.arrivo = "new york";
		this.orario = "12:00";
		this.imbarco = false;
		this.aereo = null;
	}

	public boolean prenota(int n_posti) {
		if(this.imbarco == true)
			return false;
		if(this.aereo.capienza >= n_posti + this.aereo.posti_occupati) {
			aereo.posti_occupati += n_posti;
			return true;
		}
		return false;
	}
	public boolean disdetta(int n_posti) {
		if(this.imbarco == true)
			return false;
		if(0 >= this.aereo.posti_occupati - n_posti) {
			aereo.posti_occupati -= n_posti;
			return true;
		}
		return false;
	}
	
	
	public void imbarca() {
		this.imbarco = true;
	}

	@Override
	public String toString() {
		return "{\n" + this.hashCode() + ":{partenza:" + partenza + ", arrivo:" 
		+ arrivo + ", orario:" + orario + ", imbarco:" + imbarco
				+ ", aereo:" + aereo.toString() + "}\n}\n";
	}
	
	
	
}
