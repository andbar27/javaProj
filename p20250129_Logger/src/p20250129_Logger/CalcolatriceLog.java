package p20250129_Logger;

import java.util.logging.Logger;

public class CalcolatriceLog {
	
	private static final Logger logger = Logger.getLogger(CalcolatriceLog.class.getName());

	protected CalcolatriceLog() {
		super();
	}
	
	public int somma(int a, int b) {
		logger.info("somma");
		return a + b;
	}
	
	public int sottrazione(int a, int b) {
		logger.info("sottrazione");
		return a - b;
	}
	
	public int divisione(int a, int b) {
		logger.info("divisione");
		return a / b;
	}
	
	public int moltiplicazione(int a, int b) {
		logger.info("moltiplicazione");
		return a * b;
	}

}
