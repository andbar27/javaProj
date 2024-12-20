package p20241218_SocketClient;

public class Main {

	public static void main(String[] args) {
		SocketClient client = new SocketClient();
		
		client.run("localhost", 32456);

	}

}
