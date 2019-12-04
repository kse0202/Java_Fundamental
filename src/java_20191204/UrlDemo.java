package java_20191204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class UrlDemo {
	public static void main(String[] args) throws IOException{
		URL url = new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=104&oid=469&aid=0000445720");
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort();
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		System.out.printf("Protocol : %s%n", protocol);
		System.out.printf("Host : %s%n", host);
		System.out.printf("Port : %d%n", port);
		System.out.printf("Path : %s%n", path);
		System.out.printf("Query : %s%n", query);
		System.out.printf("Ref : %s%n", ref);
		
		//HTML가져옴 
		InputStream in = url.openStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String readLine = null;
		while((readLine = br.readLine()) != null){
			System.out.println(readLine);
		}
		
	}

}
