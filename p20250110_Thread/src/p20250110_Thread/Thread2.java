package p20250110_Thread;

public class Thread2 implements Runnable{
	
	public void run() {
		System.out.println("Sono un Thread runnable");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t3 = new Thread(new Thread2()); 
		
		t3.start();
	}
}
