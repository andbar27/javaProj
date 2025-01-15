import java.util.List;

public class Consumer implements Runnable{
//public class Consumer extends Thread {
	private List<Integer> buffer;

	public Consumer(List<Integer> buffer) {
		super();
		this.buffer = buffer;
	}
	
	private void consuma() {
		System.out.println("Consuma: " + this.buffer.removeFirst());
	}

	@Override
	public void run() {
		synchronized(buffer) {
			while(true) {
				while(this.buffer.size() > 0)
					consuma();
	
				buffer.notifyAll();
				try {
					buffer.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	

}
