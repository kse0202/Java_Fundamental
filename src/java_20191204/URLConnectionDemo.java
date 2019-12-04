package java_20191204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=104&oid=469&aid=0000445720");
		URLConnection urlCon = url.openConnection();
		
		//키값을 알고 있으면 서버에 올라와 있는 헤더의 정보를 가지고 올 수 있다. 
		String cacheControl = urlCon.getHeaderField("cache-control");
		String contentType = urlCon.getHeaderField("content-type");
		String date = urlCon.getHeaderField("date");
		
		System.out.printf("cache-control : %s%n", cacheControl);
		System.out.printf("content-type : %s%n", contentType);
		System.out.printf("date : %s%n", date);
		
		//HTML을 가져오긔
		InputStream in = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String readLine = null;
		while((readLine = br.readLine()) != null){
			System.out.println(readLine);
		}
	}

}
