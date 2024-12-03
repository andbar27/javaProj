package p20241129_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws IOException {
		// Locale.setDefault(Locale.JAPAN);
		
		Wifi[] lw = new Wifi[10];
		
		for(int i=0; i<lw.length; i++) {
			lw[i] = Wifi.MakeWifi();
		}
		
		System.out.println(lw + "\n\n");
		
		
		
		// Apro il File in Scrittura
		BufferedWriter fileW = Util.OpenFileForWriting("listaWifiProva.txt");
		
		// Scrivo sul file
		try {
			fileW.write(Wifi.toStringIntestation());
		}
		catch(Exception e) {
			System.out.println("errore scrittura file: " + e);
		}
		for (Wifi w : lw) {
			try {
				fileW.write("" + w);
			}
			catch(Exception e) {
				System.out.println("errore scrittura file: " + e);
			}
		}
		
		// Chiudo il file
		try {
			fileW.close();
		}
		catch(Exception e) {
			System.out.println("errore chiusura file: " + e);
		}
		
		
		// 	Apro il file in lettura
		BufferedReader fileR = Util.OpenFileForReading("listaWifiProva.txt");
		
		// 		Apro una Stream dal file
		Stream<String> linesStream = fileR.lines();
		
		// 			Creo un'iteratore
		Iterator<String> lines = linesStream.iterator();
		
		// Leggo il file 
		System.out.println("intestazione:\n" + lines.next());
		int i = 0;
		Wifi[] lw2 = new Wifi[10];
		while(lines.hasNext()) {
			String line = lines.next();
			System.out.println(line);
			String[] params = line.split(",");
			lw2[i] = new Wifi(params[0], params[1], params[2], Double.valueOf(params[3])); 
			i++;
		}
		
		// 	Chiudo Stream e File
		linesStream.close();
		fileR.close();
	
		// Stampo lista wifi risultante
		System.out.println("\ndeve essere uguale: \n");
		for(Wifi w : lw2) {
			System.out.println(w);
		}
		
		
		Wifi w1 = Wifi.MakeWifi();
		
		
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString = objMapper.writeValueAsString(w1);
		
		System.out.println(jsonString);
		
		
	}
}
