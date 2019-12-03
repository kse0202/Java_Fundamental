package java_20191203;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingThread extends Thread{
	private String fileName;
	public CrawlingThread(String fileName){
		this.fileName = fileName;
	}
	@Override
	public void run() {
		int count=0;
		while(true){
			count++;
			String name = fileName.substring(0,fileName.lastIndexOf("."));
			String extension = fileName.substring(fileName.lastIndexOf("."));
			String fileName2 = name + count +extension;
			FileWriter fw = null;
			BufferedWriter bw = null;
			PrintWriter pw = null;
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
			String endDate = sdf.format(c.getTime());
			String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=201701101&end="+endDate;
			Document doc = null;
			
			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// url과 연결하기
			
			Elements elements = doc.select(".cmc-table__table-wrapper-outer table tbody tr"); //연결할데서 가지고 올 데이터가 있는 영역 설정
		
			
			//c:\dev\io\2019\12\crawling.txt = >저장하기
			
			try {
				//네트워크에서 가져온 데이터를 사용할 거라서 FileWriter, bufferedReader가 필요 없다. 이건 파일 읽을 때 사용.
				fw = new FileWriter("c:\\dev\\io\\2019\\12\\"+fileName);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw, true); //개행 안해도 되서 씀. 이거로 외워
				pw.println("Date\t\tOpen\t\tHigh\t\tLow\t\tClose\t\tVolume\t\tCap"); // 파일에 띄울 제목들
				//이게 while이랑 같은 역할. 엘리먼츠에 있는거 한줄 씩 콘솔에 출력하고 동시에 파일에 입력함. 
				//하나씩 쪼개서 넣는 이유 = 엑셀로 넣을때 한칸에 하나씩 넣으려고. 분리함
				for(int i =0; i <elements.size();i++){
					
					Element trElement = elements.get(i);
					String date = trElement.child(0).text();
					String open = trElement.child(1).text();
					String high = trElement.child(2).text();
					String low = trElement.child(3).text();
					String close = trElement.child(4).text();
					String volume = trElement.child(5).text();
					String cap = trElement.child(6).text();
					String format = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s%n", date, open,high,low,close,volume,cap);
					pw.print(format);
					
				}
			} catch (IOException e) { //파일 익셉션 없는 이유는 파일을 읽어서 하는게 아니라서......
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{ // 닫는거는 맨 마지막에 연거 하나만 닫으면 된다. 
				if(pw != null) pw.close();
			}
			try {
				Thread.sleep(1000*10); //1000 => 1초 = 밀리세컨즈이다.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end while
		
	}

}
