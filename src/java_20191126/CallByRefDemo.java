package java_20191126;

public class CallByRefDemo {
	
	public static void change(int i, int[] j){
		i = 20;
		j[3] = 400;
	}
	public static void main(String[] args) {
		int a =10;
		int b[] = { 1,2,3,4};
		System.out.println(a);
		System.out.println(b[3]);
		
		change(a,b); // a=> call by value, b=> call by reference 로 호출
		System.out.println(a);
		System.out.println(b[3]);
		
		int[] c;
		//System.out.println(c); c가 메모리에 안올라와 있어서 에러남
		c = new int[4];
		
		int[] d = null;
		System.out.println(d);
		d = new int[4];
		
		int age;
		//int t = age +20; age가 메모리에 없어서 에러 남
		age = 10;
		
	}
}
