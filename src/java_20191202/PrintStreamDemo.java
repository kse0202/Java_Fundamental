package java_20191202;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStream ps = System.out; //Destination을 출력장치로 연결하겠다는 의미
		ps.println("Hello World!!");
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos =null;
		PrintStream ps1 = null;
		
		try {
			// 바이트 배열이랑 버퍼랑 속도 차이가 안난다. 바이트로 외우고 사용.
			fis = new FileInputStream("c:\\dev\\io\\2019\\12\\pdf.zip");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("c:\\dev\\io\\2019\\12\\pdf-copy.zip");
			bos = new BufferedOutputStream(fos);
			
			ps1 = new PrintStream(bos, true);
			int readByte = 0;
			while((readByte = bis.read()) != -1){
				ps1.write(readByte);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(fis != null) fis.close();
					if(bis != null) bis.close();
					if(ps1 != null) ps1.close(); //닫을 때 순서 유의하기. 안에 있는거 먼저 닫고 밖에 닫기
					if(fos != null) fos.close();
					if(bos != null) bos.close(); 
					
					//객체가 생성이 안됐으면 시작도 안했으니까 닫을 필요도 없다. 객체가 있을때만 닫으라고 if문 사용함.
					//닫는 순서 fis가 bis안에 잇으니까 bis보다 fis가 먼저 닫혀야 한다.
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		

	}

}
