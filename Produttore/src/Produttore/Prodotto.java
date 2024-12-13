package Produttore;

public class Prodotto {
	private String tessuto;
	private Integer metri;
	
	protected Prodotto(String tessuto, Integer metri) {
		super();
		this.tessuto = tessuto;
		this.metri = metri;
	}

	protected Prodotto() {
		super();
	}

	public String getTessuto() {
		return tessuto;
	}

	public void setTessuto(String tessuto) {
		this.tessuto = tessuto;
	}

	public Integer getMetri() {
		return metri;
	}

	public void setMetri(Integer metri) {
		this.metri = metri;
	}

	@Override
	public String toString() {
		return "Prodotto [tessuto=" + tessuto + ", metri=" + metri + "]";
	}
	
	

}
