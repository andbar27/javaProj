import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cliente extends Thread{
	private Contocorrente conto;
	private double somma;

	public Cliente(Contocorrente conto, double somma) {
		super();
		this.conto = conto;
		this.somma = somma;
	}
	
	public boolean prelievo() {
		String file_path = conto.getConto_fp();
		double somma = this.somma;
		double tot = 0.0;

        // Leggere dal file
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            System.out.println("Contenuto del file:");
            line = reader.readLine();
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
	
	public void deposito(double somma) {
		String file_path = conto.getConto_fp();
		double tot = 0;

        // Leggere dal file
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
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
		this.prelievo();
	}
	
	
}
