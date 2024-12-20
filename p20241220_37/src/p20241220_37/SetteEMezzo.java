package p20241220_37;

public class SetteEMezzo {
	private Mazzo mazzo;
	private Double somma_player;
	private Double somma_banco;
	
	
	public SetteEMezzo() {
		super();
		this.mazzo = new Mazzo(4,10,new String[]{"Denara", "Coppe", "Spade", "Bastoni"});
		this.somma_player = 0.0;
		this.somma_banco = 0.0;
	}
	
	public double getValueCard(Integer simbolo) {
		if(simbolo > 7)
			return 0.5;
		return simbolo;
	}
	
	public void startGame() {
		Double val = getValueCard(mazzo.interpretaSimboloCarta(mazzo.pesca()));
		somma_player = val;
		
		val = getValueCard(mazzo.interpretaSimboloCarta(mazzo.pesca()));
		somma_banco = val;
	}
	
	public void playerPesca() {
		Double val = getValueCard(mazzo.interpretaSimboloCarta(mazzo.pesca()));
		somma_player += val;
	}
	
	public void bancoPesca() {
		Double val = getValueCard(mazzo.interpretaSimboloCarta(mazzo.pesca()));
		somma_banco += val;
	}
	
	public int endGame() {
		System.out.println(printGame());
		
		if(somma_player > 7.5) {
			System.out.println("Banco Vince");
			return 0;
		}
		
		while(somma_player > somma_banco) {
			bancoPesca();
			System.out.println(printGame());
		}
		
		if(somma_banco > 7.5) {
			System.out.println("Player Vince");
			return 1;
		}
		
		System.out.println("Banco Vince");
		return 0;
	}
	
	
	
	public Double getSomma_player() {
		return somma_player;
	}

	public Double getSomma_banco() {
		return somma_banco;
	}
	
	public String printGame() {
		return printGame(false);
	}

	public String printGame(boolean visible) {
		if(visible)
			return "Somma Giocatore: " + somma_player + ", Somma Banco: " + somma_banco;
		return "Somma Giocatore: " + somma_player + ", Somma Banco: ";
	}
}
