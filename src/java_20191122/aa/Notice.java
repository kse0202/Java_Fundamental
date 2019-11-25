package java_20191122.aa;

public class Notice {
	public int number;
	protected String title;
	int hit;
	private String regdate;
	
	
	public static void main(String[] args) {
		//하나의 클래스에선 모두다 된다
		Notice n = new Notice();
		n.number = 10;
		n.title = "title";
		n.hit = 100;
		n.regdate = "2019-11-22";

	}
}
