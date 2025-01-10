
public class Esercizio {

	public static void main(String[] args) {
		Computer c1 = new Computer(1.0, 2.0, 3.0, 4.0, 5.0, "Sony", 2);
		System.out.println(Computer.getInstances());
		Computer c2 = new Computer(1.0, 2.0, 3.0, 4.0, 5.0, "Sony", 2);
		Computer c3 = new Computer(1.0, 2.0, 3.0, 4.0, 5.0, "Sony", 2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1 + "" + c3);
		System.out.println(Computer.getInstances());
		
	}

}
