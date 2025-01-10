package p20250110_Thread;

public class Thread8 {
	public Thread t;

	protected Thread8(Thread t) {
		super();
		this.t = t;
	}

	@Override
	public String toString() {
		return "Thread8 [t=" + t + ", state:" + t.getState() + "]";
	}
	
	public static void main(String[] args) {
		Thread8 t1 = new Thread8(new Thread());
		Thread8 t2 = new Thread8(new Thread());
		System.out.println(t1);
		System.out.println(t2);
		t1.t.start();
		t2.t.start();
		System.out.println(t1);
		System.out.println(t2);
	}

}
