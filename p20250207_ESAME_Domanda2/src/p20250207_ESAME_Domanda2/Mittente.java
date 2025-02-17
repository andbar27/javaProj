package p20250207_ESAME_Domanda2;

import java.util.LinkedList;

public class Mittente implements Runnable{
	private Posta p;
	private LinkedList<String> messaggi;
	int tempoDiSleep;
	

	protected Mittente(Posta p, LinkedList<String> messaggi) {
		super();
		this.p = p;
		this.messaggi = messaggi;
		this.tempoDiSleep = 2000;
	}
	
	
	public void setTempoDiSleep(int tempoDiSleep) {
		this.tempoDiSleep = tempoDiSleep;
	}


	@Override
	public void run() {
		int i = 0;
		
		while(true) {
			String messaggio = messaggi.get(i);
			i++;
			if(i == messaggi.size())
				i=0;
			
			synchronized(p) {
				if(p.scriviMessaggio(messaggio)) {
					System.out.println("scritto messaggio: " + messaggio);
					p.notifyAll();
				}else {
					System.out.println("mittente va in wait");
					try {
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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
