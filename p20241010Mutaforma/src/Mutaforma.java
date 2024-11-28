
public class Mutaforma {

	public static void main(String[] args) {
		
		int a = Somma(10, 20);
		System.out.println(a);
		double b = Somma(10.1, 20.2);
		System.out.println(b + "ciao" + 3.2);
		

	}

	private static double Somma(double d, double e) {
		// TODO Auto-generated method stub
		return e+d;
	}

	private static int Somma(int i, int j) {
		// TODO Auto-generated method stub
		return i+j;
	}

}
