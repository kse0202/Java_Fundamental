package java_20191126;

public class ChildDemo {
	public static void main(String[] args){
		Parent p1 = new Parent();
		p1.age = 55;
		p1.work();
		p1.playBadook();
		
		Child c1 = new Child();
		c1.age=25;
		c1.height = 155.24;
		c1.playBadook();
		c1.playGame();
		c1.work();
		
		Parent p2 = new Child(); //객체의 형변환. new 앞에 (parent) 오토캐스팅 생략되어 있다고 생각
		p2.age=25;
		//p2.height = 155.24; //자식꺼는 호출 불가능
		p2.playBadook();
		//p2.playGame(); //자식꺼는 호출 불가능
		p2.work();//자식의 work()를 호출함 
	}

}
