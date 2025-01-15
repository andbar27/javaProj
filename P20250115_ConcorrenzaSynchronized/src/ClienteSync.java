import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClienteSync extends Thread{
	private Contocorrente conto;
	private double somma;

	public ClienteSync(Contocorrente conto, double somma) {
		super();
		this.conto = conto;
		this.somma = somma;
	}
	
	public synchronized boolean prelievo() throws InterruptedException {
		Thread.sleep(200);
		String file_path = conto.getConto_fp();
		double somma = this.somma;
		double tot = 0.0;

        // Leggere dal file
		try (FileReader fw = new FileReader(new File(".").getCanonicalPath() + File.separator + "db.txt");) {
        	BufferedReader reader = new BufferedReader(fw);
            String line;
            System.out.println("Contenuto del file:");
            line = reader.readLine();
            System.out.println(line);
            tot = Double.parseDouble(line);
            if(tot-somma < 0) {
            	System.out.println("Somma non sufficente");
            	return false;
            }
            
            tot = tot-somma;
            System.out.println("Contenuto del file letto con successo");
            
             
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
        }
        
        // Scrivere nel file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            writer.write(Double.toString(tot));
            System.out.println("Contenuto scritto nel file con successo.");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file: " + e.getMessage());
        }
        return true;
	}
	
	public synchronized void deposito(double somma) {
		String file_path = conto.getConto_fp();
		double tot = 0;

        // Leggere dal file
        try (FileReader fw = new FileReader(new File(".").getCanonicalPath() + File.separator + "db.txt");) {
        	BufferedReader reader = new BufferedReader(fw);
            String line;
            System.out.println("Contenuto del file:");
            line = reader.readLine();
            System.out.println(line);
            tot = Double.parseDouble(line);
            tot += somma;
            System.out.println("Contenuto del file letto con successo");
            
             
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
        }
        
        // Scrivere nel file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            writer.write(Double.toString(tot));
            System.out.println("Contenuto scritto nel file con successo.");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file: " + e.getMessage());
        }
	}
	
	public void run() {
		try {
			this.prelievo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
