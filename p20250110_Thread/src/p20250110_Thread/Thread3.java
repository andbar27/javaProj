package p20250110_Thread;

public class Thread3 implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(this.hashCode() + ": i=" + i);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Thread3());
		Thread t2 = new Thread(new Thread3());
		
		t1.start();
		t2.start();
	}
	

}
