
public class Pitagora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double c1 = 45.3;
		double c2 = 67.2;
		double ip = Math.sqrt(c1*c1 + c2*c2);
		double area = c1*c2/2;
		double perim = c1+c2+ip;
		System.out.println("ipotenusa: " + ip);
		System.out.println("area: " + area);
		System.out.println("perimetro: " + perim);
		
	}

}
