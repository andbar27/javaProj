package p20241129_IO;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.util.*;

public class Util {
	private static Random rng = new Random();
	private final static String alfabeto = "abcdefghijklmnopqrstuvwxyz";
	private final static String digit = "0123456789";
	private final static String simboli = "-_.:!?|$%";
	
	
	public static String GetRandomAuthProto() {
		int i = rng.nextInt(4);
		String [] vp = new String[]{"WEP", "WPA", "WPA2", "WPA3"};
		return vp[i];
	}
	
	//Genera un frequenza (Double) compreso tra 1.0*10^9 e 5.0*10^9
	public static Double GetFrequenza() {
		Double k = rng.nextDouble(1000000000.0, 5000000000.0);
		return k;
	}
	
	public static String GetPassword(Boolean isPassword) {
		String all = alfabeto+alfabeto.toUpperCase()+digit;
		if (isPassword) {
			all+=simboli;
		}
		
		//Quanto è lunga una password? tra gli 12 a 24
		int len = rng.nextInt(12,25);
		StringBuilder ret= new StringBuilder();
		for (int i=0; i<len; i++) {
			ret.append(all.charAt(rng.nextInt(all.length())));
		}
		return ret.toString();
	}

	public static BufferedReader OpenFileForReading(String nomeFile) {
		
//		//Crea un file vuoto e basta!
//		try {
//			Files.createFile(Path.of("pippo"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        try {
            BufferedReader reader = Files.newBufferedReader(Path.of(nomeFile));
            return reader;
        } catch (IOException e) {
            return null;
        }
    }

	public static BufferedWriter OpenFileForWriting(String nomeFile) {
        try {
        	Path path = Path.of(nomeFile);
            BufferedWriter writer = Files.newBufferedWriter(
                    path,
                    Files.exists(path)?StandardOpenOption.TRUNCATE_EXISTING:StandardOpenOption.CREATE);
            return writer;
        } catch (Exception ex) {
            return null;
        }
    }
    public static BufferedWriter OpenFileForAppend(String nomeFile) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(
                    Path.of(nomeFile),
                    StandardOpenOption.APPEND);
            return writer;
        } catch (Exception ex) {
            return null;
        }
    }
	
}
