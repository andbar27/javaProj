package p20241122_Test_Fibonacci;

import java.util.HashMap;

public class Fibonacci {

	public static int fibo(int n) {
		if(n <= 0)
			return 0;
		if(n < 2) 
			return 1;
		
		return fibo(n-1) + fibo(n-2);
	}
	
	public static Long fibo(int n, HashMap<Integer, Long> hm) {
		if(n <= 0)
			return 0L;
		if(n < 2) 
			return 1L;
		
		Long n1;
		if(hm.containsKey(n-1)) {
			n1 = hm.get(n-1);
			//System.out.println(n + " n-1 " + (n-1) + " presente");
		}
		else {
			n1 = fibo(n-1, hm);
			hm.put(n-1, n1);
		}
		Long n2;
		if(hm.containsKey(n-2)) {
			n2 = hm.get(n-2);
			//System.out.println(n + " n-2 " + (n-2) + " presente");
		}
		else {
			n2 = fibo(n-2, hm);
			hm.put(n-2, n2);
		}
		
		return n1 + n2;
	}

	
	public static void main(String[] args) {
		for(int i=0; i<10; i++)
			System.out.println(fibo(i));
		
		
		HashMap<Integer, Long> hm = new HashMap<>();
		for(int i=0; i<10; i++)
			System.out.println(fibo(i, hm));
		
		
		System.out.println();
		
		for(int i=0; i<10; i++)
			System.out.println(fibo(i, hm));
		
		hm = new HashMap<Integer, Long>();
		
		System.out.println(fibo(50, hm));

	}

}
