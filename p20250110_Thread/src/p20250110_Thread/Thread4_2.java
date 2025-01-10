package p20250110_Thread;

public class Thread4_2  extends Thread{
	
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(this.hashCode() + ": i=" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
