package p20250110_Thread;

public class Thread7 extends Thread{
	
	
	public void run() {
		for(int i=0; i<3; i++) {
			System.out.println(this.getState());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread7 t = new Thread7();
		System.out.println(t.getState());
		t.run();
		t.start();
		Thread.sleep(1000);
		System.out.println(t.getState());
	}

}
