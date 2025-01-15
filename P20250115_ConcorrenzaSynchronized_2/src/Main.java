import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> li = new LinkedList<Integer>();
		Producer p = new Producer(li, 10);
		Consumer c = new Consumer(li);
		
		Thread tp = new Thread(p);
		Thread tc = new Thread(c);
		//p.start();
		//c.start();
		
		tp.start();
		tc.start();

	}

}
