package java_20191127;

import java.util.ArrayList;

public class WrapperDemo {
	public static void main(String[] args) {
		//자바 1.4 버전에서는 primitive data type을 collection에 넣을 수가 없었다. 
		//primitive data type을 객체화 할 수 있는 wrapper class로 변환하여 저장.
		ArrayList list = new ArrayList();
		list.add(new Integer(1));
		list.add(new Integer(2));//list에 넣을 때 객체를 만들어서 넣는다.
		Integer i1 = (Integer)list.get(0);
		Integer i2 = (Integer)list.get(1); //list에서  꺼내올 때 객체로 가져온다.
		int a = i1.intValue()+i2.intValue(); // 연산할때 프리미티브로 바꾸기 위해 intValue()메서드를 이용한다.
		
		//java 1.5 or java 5.0 이후
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1); //auto-boxing
		list1.add(2);
		Integer i3 = list1.get(0);//제너릭으로 어레이 리스트에 인티저 객체만 넣었기 때문에 캐스팅 할 필요 없다. 이미 인티저 오브젝트
		Integer i4 = list1.get(1);
		int b = i3 + i4; //auto-unboxing
		
		String str = 10 +""; //저급한 방법.....
		String str1 = String.valueOf(10);
		
		//문자열을 int로 바꿀때!!!!
		int d = Integer.parseInt("100"); 
		String temp = "12.35";
		double d4 = Double.valueOf(temp); //오토 언박싱 에러가 안난다
		double d5 = 45.12;
		System.out.println(d4+d5);
		double d6 = Double.parseDouble(temp);
		System.out.println(d5+d6);
		
	}

}
