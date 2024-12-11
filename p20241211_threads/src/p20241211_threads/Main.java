package p20241211_threads;

public class Main {

	public static void main(String[] args) {
//		MyThread th1 = new MyThread(100);
//	    th1.start();
//
//	    MyThread th2 = new MyThread(100);
//	    th2.start();
	    
	    //System.exit(0);

		GenID id1 = new GenID();
	    id1.start();
	    GenID id2 = new GenID();
	    id2.start();
	    GenID id3 = new GenID();
	    id3.start();
	    GenID id4 = new GenID();
	    id4.start();
	}
	
}
