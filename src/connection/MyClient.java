package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
//	Attributes
	private Socket socket;
	private BufferedReader input;
	private PrintStream output;
	private String ip;
	private int port;
	
//	Constructor
	public MyClient(String ip, int port) {
		try {
			this.socket = new Socket(ip, port);
			this.input = new BufferedReader( new InputStreamReader(this.socket.getInputStream()));
			this.output = new PrintStream(this.socket.getOutputStream());
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	Main
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.println("which ip and port do you want to connect?");
		System.out.print("ip: ");
		String ip = k.nextLine();
		System.out.print("port: ");
		int port = k.nextInt(); k.nextLine();
		
		MyClient client = new MyClient(ip, port);
	}
}