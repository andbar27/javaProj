import java.util.List;

public class Producer implements Runnable{
//public class Producer extends Thread {
	private final List<Integer> buffer;
	private final int SIZE;
	private int i = 1;
	
	
	public Producer(List<Integer> buffer, int SIZE) {
		super();
		this.buffer = buffer;
		this.SIZE = SIZE;
	}

	private void produce() {
		this.buffer.addLast(i);
		System.out.println("Produce: " + i);
		i++;
	}

	@Override
	public void run() {
		synchronized(buffer) {
			while(true) {
				while(this.buffer.size() < SIZE) 
					produce();
				i=0;
	
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
