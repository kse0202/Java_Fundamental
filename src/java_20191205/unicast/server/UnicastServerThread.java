package java_20191205.unicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UnicastServerThread implements Runnable{
	private Socket socket;
	public UnicastServerThread(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		try {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			boolean isStop = false;
			while(!isStop){
				String readLine = br.readLine();
				System.out.println(readLine);
				if(readLine.equals("exit")){
					isStop = true;
				}
				bw.write(readLine);
				bw.newLine();
				bw.flush();
			}
			System.out.println("클라이언트가 정상적으로 종료했습니다....");
		} catch (UnknownHostException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("클라이언트가 비정상적으로 종료했습니다....");
			e.printStackTrace();
		}
		
		
		
	}

}
