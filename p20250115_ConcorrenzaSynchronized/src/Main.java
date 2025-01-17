
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contocorrente cc = new Contocorrente("db.txt");
		
		ClienteSync c1 = new ClienteSync(cc, 60.0);
		ClienteSync c2 = new ClienteSync(cc, 60.0);
		
		c1.deposito(100.0);
		
		c1.start();
		c2.start();

	}

}
