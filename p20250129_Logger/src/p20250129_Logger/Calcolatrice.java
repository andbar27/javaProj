package p20250129_Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calcolatrice {
	
	private static Logger log4jlogger = LogManager.getLogger(Calcolatrice.class.getName());

	protected Calcolatrice() {
		super();
	}
	
	public int somma(int a, int b) {
		log4jlogger.info("somma");
		return a + b;
	}
	
	public int sottrazione(int a, int b) {
		log4jlogger.info("sottrazione");
		return a - b;
	}
	
	public int divisione(int a, int b) {
		log4jlogger.info("divisione");
		return a / b;
	}
	
	public int moltiplicazione(int a, int b) {
		log4jlogger.info("moltiplicazione");
		return a * b;
	}

}
