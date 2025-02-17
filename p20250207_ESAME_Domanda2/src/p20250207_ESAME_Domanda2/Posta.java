package p20250207_ESAME_Domanda2;

import java.util.LinkedList;
import java.util.List;

public class Posta {
	private List<String> messaggi;

	public Posta() {
		super();
		this.messaggi = new LinkedList<String>();
	}
	
	public String leggiMessaggio() {
		if(messaggi.size() > 0) {
			return messaggi.removeFirst();
		}
		return "";
	}
	
	public boolean scriviMessaggio(String messaggio) {
		if(messaggi.size() < 10) {
			messaggi.addLast(messaggio);
			return true;
		}
		return false;
	}

}
