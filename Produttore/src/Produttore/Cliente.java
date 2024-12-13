package Produttore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Cliente extends Thread{
	private LinkedBlockingQueue<ProdottoFilatrice> coda;
	private HashMap<String, List<ProdottoFilatrice>> diz_filatrice;
	private HashMap<String, List<ProdottoFilatrice>> diz_tessuto;

	protected Cliente(LinkedBlockingQueue<ProdottoFilatrice> coda) {
		super();
		this.coda = coda;
		this.diz_filatrice = new HashMap<String, List<ProdottoFilatrice>>();
		this.diz_tessuto = new HashMap<String, List<ProdottoFilatrice>>();
	}
	
	private static void insertInDict(String key, ProdottoFilatrice value, HashMap<String, List<ProdottoFilatrice>> diz){
		if(!diz.containsKey(key)) {
			diz.put(key, new ArrayList<ProdottoFilatrice>());
		}
		diz.get(key).add(value);
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ProdottoFilatrice pf = coda.poll();
			if(pf != null) {
				String id_fil = pf.getId_filatrice();
				String tessuto = pf.getP().getTessuto();
				insertInDict(id_fil, pf, diz_filatrice);
				insertInDict(tessuto, pf, diz_tessuto);
				System.out.println("Cliente: " + diz_filatrice);
				System.out.println("Cliente: " + diz_tessuto);
				try {
					FileWriter writer = new FileWriter("diz_filatrice.txt"); // true per append
					writer.write(diz_filatrice.toString().replaceAll("]],", "]],\n"));
					writer.close();
					FileWriter writer1 = new FileWriter("diz_tessuto.txt"); // true per append
					writer1.write(diz_tessuto.toString().replaceAll("]],", "]],\n"));
					writer1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Cliente [coda=" + coda + "]";
	}
}
