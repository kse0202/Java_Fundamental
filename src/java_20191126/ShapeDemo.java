package java_20191126;

public class ShapeDemo {
	
	public static void run(Shape s){
		s.draw();
	}
	public static void main(String[] args) {
		//Shape s = new Shape(); 추상클래스는 객체 생성이 안된다
		
		Shape s1 = new Rectangle();
		s1.draw();
		
		Shape s2 = new Triagle();
		s2.draw();
		
		run(new Rectangle());
		run(new Triagle());
	}

}
