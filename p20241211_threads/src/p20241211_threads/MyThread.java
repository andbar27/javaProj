package p20241211_threads;

import java.time.LocalTime;

public class MyThread extends Thread {
    private long num;

    public void run() {
//        while (num-- > 0) {
//            System.out.println("Thread id: " + getId()
//            			+ ". Num: " + num);
//        }
    	while(true) {
    		System.out.println(LocalTime.now());
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

    public MyThread(long num) {
        super();
        this.num = num;
    }

}
