package p20250110_Thread;

public class Thread5 extends Thread{
	private boolean param;
	
	
	
	protected Thread5(boolean param) {
		super();
		this.param = param;
	}

	public void run() {
		int i;
		if(param) {
			for(i = 100; i>=90; i--) {
				System.out.println(this.hashCode() + ": i=" +i);
			}
		} else {
			for(i = 1; i<=10; i++) {
				System.out.println(this.hashCode() + ": i=" +i);
			}
		}
			
		
	}
	
	public static void main(String[] args) {
		Thread5 t1 = new Thread5(true);
		Thread5 t2 = new Thread5(false);
		
		t1.start();
		t2.start();
	}

}
