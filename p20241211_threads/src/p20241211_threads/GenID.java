package p20241211_threads;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class GenID extends Thread{
		// Mutex
	private static ReentrantLock lock = new ReentrantLock();
	static long id = 0;
	
	public void run() {
		Random rng = new Random();
		while(true) {
			lock.lock();
			System.out.println(id);
			try {
				Thread.sleep(rng.nextInt(100, 800));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			id++;
			lock.unlock();
		}
	}

}
