package p20250129_Logger;

import org.apache.logging.log4j.*;

public class Log4jDemo {

	private static Logger log4jlogger = LogManager.getLogger(Log4jDemo.class.getName());

	public static void main(String[] args) {
		
		System.out.println("Demo Log4j");
		log4jlogger.info("Log4j Info");
		log4jlogger.debug("Log4j Debug");
		log4jlogger.warn("Log4j Warning");	
		log4jlogger.error("Log4j Error");
		log4jlogger.fatal("Log4j Fatal");

		CalcolatriceLog c = new CalcolatriceLog();

		System.out.println(c.somma(1, 2));
		System.out.println(c.sottrazione(1, 2));
		System.out.println(c.moltiplicazione(1, 2));
		System.out.println(c.divisione(1, 2));

	}

}