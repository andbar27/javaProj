package Produttore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Gestione extends Thread{
	private LinkedBlockingQueue<ProdottoFilatrice> coda;
	private Integer i;

		
	protected Gestione() {
		super();
		this.coda = new LinkedBlockingQueue<ProdottoFilatrice>();
		this.i = 0;
	}

	public LinkedBlockingQueue<ProdottoFilatrice> getCoda() {
		return coda;
	}




	public void run() {
		ObjectMapper obm = new ObjectMapper();
		while(true){
			try {
				Thread.sleep(20 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			ArrayList<String> lista_file = getNomiFile("/tmp", "filatrice");
			Integer lenListaFile = lista_file.size();
			if(i >= lenListaFile) {
				i = 0;
			}
			String percorsoFile = "/tmp/" + lista_file.get(i);
			
			var fin = new File(percorsoFile);
	        try (Scanner scanner = new Scanner(fin)) {
	            while (scanner.hasNextLine()) {
	                String linea = scanner.nextLine();
	                Prodotto p = null;
					try {
						p = obm.readValue(linea, Prodotto.class);
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ProdottoFilatrice pf = new ProdottoFilatrice(percorsoFile, p);
	                try {
						coda.put(pf);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                System.out.println("Gestore: " + pf);
	            }
	            scanner.close();
	            fin.delete();
	        } catch (FileNotFoundException e) {
	            System.out.println("Gestore: File non trovato: " + e.getMessage());
	        } finally {
	        	i++;
	        }
		}
	}

	private ArrayList<String> getNomiFile(String path_dir, String startW) {
		File dir = new File(path_dir);
		ArrayList<String> retList = new ArrayList<String>();
		
		if(dir.isDirectory()) {
			String[] nomiFile = dir.list();
			for(String nome : nomiFile) {
				if(nome.startsWith(startW)) {
					retList.add(nome);
				}
			}
		}
		
		
		return retList;
	}

}
