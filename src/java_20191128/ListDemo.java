package java_20191128;

import java.util.ArrayList;

public class ListDemo {
	public static void main(String[] args) {
		//ArrayList : 순서가 있고, 데이터(객체)의 중복을 허용한다. 
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(new Product(1,"terra",2500));
		list.add(new Product(2, "신라면",1000));
		list.add(new Product(3, "서울우유",3000));

		for(int i = 0; i< list.size(); i++){
			Product temp = list.get(i);
			System.out.println(temp);
		}
		
		//모두 삭제 
	
		for (int i = 0; i < list.size(); i++) {
			list.remove(i--);
		}
		
		//enhanced for loop 출력 가능, 제너릭 사용한 경우에만 
		for (Product temp : list) {
			System.out.println(temp);
		}
	}

}

class Product{
	int number;
	String name;
	double price;
	
	Product(int number, String name, double price){
		this.number = number;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price="
				+ price + "]";
	}
	
}