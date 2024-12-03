package p20241129_IO;

public class Wifi {
	private String id;
	private String password;
	private String protocollo;
	private Double frequenza;
	
	public Wifi(String id, String password, String protocollo, Double frequenza) {
		super();
		this.id = id;
		this.password = password;
		this.protocollo = protocollo;
		this.frequenza = frequenza;
	}
	
	public Wifi() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public Double getFrequenza() {
		return frequenza;
	}

	public void setFrequenza(Double frequenza) {
		this.frequenza = frequenza;
	}

	
	public static Wifi MakeWifi() {
		Wifi wifi = new Wifi();
		wifi.password = Util.GetPassword(true);
		wifi.frequenza = Util.GetFrequenza();
		wifi.id = Util.GetPassword(false);
		wifi.protocollo = Util.GetRandomAuthProto();
		
		return wifi;
	}

	
	public static String toStringIntestation() {
		return "" + "id" + "," + "password" + "," + "protocollo" + "," + "frequenza"
				+ "\n";
	}
	
	@Override
	public String toString() {
		return "" + id + "," + password + "," + protocollo + "," + frequenza
				+ "\n";
	}
}
