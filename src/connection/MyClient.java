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
	
	//	Setters
	public void setIp(String ip) {this.ip = ip;}
	public void setPort(int port) {this.port = port;}

	//	Methods
	public void setConnection() throws UnknownHostException, IOException {
		this.socket = new Socket(ip, port);
		this.input = new BufferedReader( new InputStreamReader(this.socket.getInputStream()));
		this.output = new PrintStream(this.socket.getOutputStream());
	}

	//	Main
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		MyClient client = new MyClient();

		try {
			System.out.println("which ip and port do you want to connect?");
			System.out.print("ip: ");
			client.setIp(k.nextLine());
			System.out.print("port: ");
			client.setPort(k.nextInt()); k.nextLine();

			client.setConnection();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}