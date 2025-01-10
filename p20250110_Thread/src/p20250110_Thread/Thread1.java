package p20250110_Thread;

public class Thread1 extends Thread {
	public static int _ist = 0;
	public int ist;
	
	
	public Thread1() {
		super();
		ist = _ist++;
	}



	public void run() {
		System.out.println("Ciao sono " + ist);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t1 = new Thread1(); 
		Thread1 t2 = new Thread1(); 
		
		t1.start();
		t2.start();
	}
}
