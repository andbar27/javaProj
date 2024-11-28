import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
		/*
		TriangoloRettangolo tr = new TriangoloRettangolo(3,4);
		System.out.println("Ipotenusa: " + tr.getHyp());
		System.out.println("Area: " + tr.getArea());
		System.out.println("Perimetro: " + tr.getPerimetro());
		
		tr.setCat1(5);
		System.out.println(tr);
		
		int[] vint = new int[100];
		for(int i=0; i<100; i++) {
			vint[i] = (i+1) * 2;
		}
		for(int i=0; i<100; i++) {
			vint[i] = (i+1) * 2 - 1;
		}
		double[] vdou = new double[100];
		for(int i=1; i<=100; i++) {
			vdou[i-1] = 1.0 / i;
		}
		
		long[] vlong = new long[100];
		vlong[0] = 1;
		vlong[1] = 1;
		for(int i=2; i<100; i++) {
			vlong[i] = vlong[i-2] + vlong[i-1];
		}
		
		for(int i=0; i<100; i++) {
			vint[i] = (i+1) * 2;
		}
		
		
		
		for(int i = 1; i < 100; i++) {
			System.out.println(fattoriale(i) + " - " + fattoriale2(i));
		}
		*/
		
		byte[] schermo = new byte[8];
        schermo[0] = 0b00000000;
        schermo[1] = 0b00011000;
        schermo[2] = 0b00100100;
        schermo[3] = 0b01100110;
        schermo[4] = 0b01111110;
        schermo[5] = 0b01100110;
        schermo[6] = (byte)0b11100111;
        schermo[7] = 0b00000000;
		
        Disegna2(schermo);
        
        for (int i = 0; i < schermo.length; i++) {
        	schermo[i] ^= 0b11111111;
        }
        
        Disegna2(schermo);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
		int kk = 0;
		switch(input) {
			case "1":
				System.out.println("a");
				break;
			case "2": 
				System.out.println("b");
				break;
			default:
				System.out.println("default");
			case "0": 
				System.out.println("c");
				break;
		}
		
	}
	
	private static void Disegna(byte[] schermo) {
		// TODO Auto-generated method stub
		for(int i = 0; i < schermo.length; i++) {
			byte b = schermo[i];
			for(int j = 0; j < 8; j++) {
				if (((byte)Math.pow(2,j) & b) == 0) {
					System.out.print(" ");
				}
				else {
					System.out.print("+");
				}
			}
			System.out.println();
		}
	}
	private static void Disegna2(byte[] schermo) {
		// TODO Auto-generated method stub
		String lettera = "";
		String riga = "";
		String c = "";
		for(int i = 0; i < schermo.length; i++) {
			riga = "";
			for(int j = 0; j < 8; j++) {
				
				if (((byte)Math.pow(2,j) & schermo[i]) == 0) {
					c = " ";
				}
				else {
					c = "+";
				}
				riga = c + riga;
			}
			lettera = lettera + "\n" + riga;
			System.out.println();
		}
		System.out.println(lettera);
	}

	public static int fattoriale(int n) {
		return (n + 1) * n / 2 +1;
	}
	public static int fattoriale2(int n) {
		int fatt = 1;
		for(int i=n; i>=1; i--) {
			fatt += i;
		}
		return fatt;
	}
	
	
	public static void eratostene(int n) {
		boolean [] vbol = new boolean[n*n*n];
		
	}
	
	public static void stampaInt(int[] vint) {
		for(int v: vint) {
			System.out.println(v);
		}
	}
	public static void stampaInt(long[] vint) {
		for(long v: vint) {
			System.out.println(v);
		}
	}

}
