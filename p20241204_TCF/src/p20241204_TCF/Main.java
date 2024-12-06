package p20241204_TCF;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rng = new Random();
		for(int i = 0; i < 20; i++) {
			Integer num = Dividi(rng.nextInt(10), rng.nextInt(10));
			//System.out.println(num);
		}
		
	}
	
	private static Integer Dividi(int i, int j) {
		Integer q = null;
		try {
			q = i/j;
			System.out.print("ok ");
		} catch (Exception ex) {
			System.out.print("ko ");
			//ex.printStackTrace();
		} finally {
			System.out.print("eh ");
		}
		return q;
	}

}
