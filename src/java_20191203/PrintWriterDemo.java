package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			fr = new FileReader("C:\\dev\\io\\2019\\12\\test.txt");
			br = new BufferedReader(fr); //stream chainning
			fw = new FileWriter("C:\\dev\\io\\2019\\12\\test-copy2.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true); // true => autoFlush기능 
			
			String readLine = null;
			while((readLine = br.readLine()) != null){ //String값이라서 -1이 아니다. 
				pw.println(readLine);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(fr != null) fr.close();
					if(br != null) br.close();
					//if(fw != null) fw.close();
					if(bw != null) bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

}
