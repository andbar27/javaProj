
public class Progettino {
	public static void main(String[] args) {
		Computer [] coms = new Computer[10];
		
		for(int i=0; i<10; i++) {
			Computer c = new Computer("ab");
			coms[i] = c;
			System.out.println(c);
		}
	}
}
