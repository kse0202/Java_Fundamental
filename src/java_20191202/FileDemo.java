package java_20191202;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileDemo {
	public static void main(String[] args) {
		//디렉토리 만드는법 = 폴더 만들기
		File f1 = new File("c:\\dev\\io\\2019\\12");
		boolean isSuccess = f1.mkdirs();
		System.out.println(isSuccess);
		
		File f2 = new File(f1,"jdk-11.0.5_windows-x64_bin.exe");//(경로,파일명) or (경로\\파일명)
		long fileSize = f2.length();
		System.out.println(fileSize);
		long lastModified = f2.lastModified();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(lastModified);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DATE);
		
		System.out.printf("%d 년  %d 월 %d 일", year, month, day);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd a hh:mm:ss E요일");
		String date = sdf.format(c.getTime());
		System.out.println(date);
		
		File f3 = new File("c:\\");
		//list() : c드라이브에 있는 모든 파일과 디렉토리를 String[]배열로 반환
		String[] list = f3.list();
		for (String temp : list) {
			File f4 = new File(f3,temp);
			if(f4.isDirectory()){
				System.out.println("디렉토리 : " + temp);
			}else if(f4.isFile()){
				System.out.println("파일 : " + temp);
			}else{
				System.out.println("? : " +temp);
			}
			
		}
		File f5 = new File(f1, "jdk.exe");
		f2.renameTo(f5);
		
		File f6 = new File(f1, "a.txt");
		try {
			f6.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//파일 이름, 파일 경로(자기 포함), 파일 경로(내 위에까지)
		System.out.println(f6.getName());
		System.out.println(f6.getPath());
		System.out.println(f6.getParent());
		
		//확장자는 남기고 현재 시간으로 파일 명 바꾸기
		String extension = f6.getName().substring(f6.getName().lastIndexOf("."));
		System.out.println(extension);
		File f7 = new File(f1, System.currentTimeMillis()+extension);
		f6.renameTo(f7);
		
		//파일 삭제하기
		f7.delete();
	}

}
