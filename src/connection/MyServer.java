package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
	//	Attributes
	private static int basePort = 5005;
	private ArrayList<Socket> sockets = new ArrayList<Socket>();
	private ArrayList<ServerSocket> serverSockets = new ArrayList<ServerSocket>();
	private ArrayList<BufferedReader> inputs = new ArrayList<BufferedReader>();
	private ArrayList<PrintStream> outputs = new ArrayList<PrintStream>();
	
	//	Methods
	public void setConnection() throws IOException {
		int port = this.basePort++;
		
		this.serverSockets.add(new ServerSocket(port));
		ServerSocket server = this.serverSockets.get(this.serverSockets.size() - 1);
		
		this.sockets.add(server.accept());
		Socket socket = this.sockets.get(this.sockets.size() - 1);
		socket.setSoLinger(true, 10);
		
		this.inputs.add(new BufferedReader( new InputStreamReader(socket.getInputStream())));
		this.outputs.add(new PrintStream(socket.getOutputStream()));
	}
	
	//	Main
	public static void main(String[] args) {
		MyServer server = new MyServer();
	}
}