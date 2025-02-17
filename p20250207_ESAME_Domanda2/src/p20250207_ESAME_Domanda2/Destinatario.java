package p20250207_ESAME_Domanda2;

public class Destinatario implements Runnable{
	Posta p;
	int tempoDiSleep;

	public Destinatario(Posta p) {
		super();
		this.p = p;
		this.tempoDiSleep = 0;
	}
	
	
	public void setTempoDiSleep(int tempoDiSleep) {
		this.tempoDiSleep = tempoDiSleep;
	}



	@Override
	public void run() {
		while(true) {
			
			synchronized (p) {
				String messaggio = p.leggiMessaggio();
				p.notifyAll();
				if(messaggio == "") {
					System.out.println("destinatario va in wait");
					try {
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("letto: " + messaggio);
				}
			}
			try {
				//Thread.sleep(1500);
				Thread.sleep(tempoDiSleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	

}
