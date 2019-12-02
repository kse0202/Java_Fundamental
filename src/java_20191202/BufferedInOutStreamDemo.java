package java_20191202;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInOutStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos =null;
		
		try {
			// 바이트 배열이랑 버퍼랑 속도 차이가 안난다. 바이트로 외우고 사용.
			fis = new FileInputStream("c:\\dev\\io\\2019\\12\\pdf.zip");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("c:\\dev\\io\\2019\\12\\pdf-copy.zip");
			bos = new BufferedOutputStream(fos);
			/*
			int readByte = 0;
			long start = System.currentTimeMillis();
			while((readByte = bis.read()) != -1){
				bos.write(readByte);
			}
			bos.flush();  //bufferedOutputStream을 이용한다면 flush가 필요. 마지막 배열에 잇는거 쫙 출력. 아니면 파일 끝은 복사가 안됨
			long end = System.currentTimeMillis();
			
			System.out.printf("경과시간 : %d %n", end - start);*/
			
			int readByteCount = 0;
			byte[] readByte = new byte[1024*8];
			long start = System.currentTimeMillis();
			while((readByteCount = fis.read(readByte)) != -1){
				fos.write(readByte, 0, readByteCount);
			}
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d %n", end - start);
			
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
