package java_20191205.unicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer {
	private int port;
	public UnicastServer(int port){
		this.port = port;
	}
	public void run(){
		ServerSocket serverSocket = null;
		UnicastServerThread ust = null;
		
		try {
			serverSocket = new ServerSocket(port);
			while(true){
				System.out.println("클라이언트 접속 대기중...");
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트 IP :" + socket.getInetAddress());
			ust = new UnicastServerThread(socket);
			Thread t = new Thread(ust);
			t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new UnicastServer(3000).run();
		
	}

}
