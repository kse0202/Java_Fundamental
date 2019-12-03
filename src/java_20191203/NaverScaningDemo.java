package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NaverScaningDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/");
		InputStream in = url.openStream();
		
		//1. InputStream을 InputStreamReader로 스트림 체이닝 한다.
		//2. InputStreamReader를 BufferedReader로 스트림 체이닝한다.
		//3. BufferedReader로 읽은 정보(HTML)를 C:\dev\io\2019\12\naver.html 파일로 저장한다.
		
		InputStreamReader isr = null;
		isr = new InputStreamReader(in);
		BufferedReader br = null;
		br = new BufferedReader(isr);
		FileWriter fw = null;
		fw = new FileWriter("C:\\dev\\io\\2019\\12\\naver.html");
		BufferedWriter bw = null;
		bw = new BufferedWriter(fw);
		
		String readLine = null;
		while((readLine = br.readLine()) != null){
			bw.write(readLine);
			bw.newLine();
		}
		bw.flush();
		
		if(isr != null) isr.close();
		if(br != null) br.close();
		if(in != null) in.close();
		if(fw != null) fw.close();
		if(bw != null) bw.close();
	
		
	}

}
