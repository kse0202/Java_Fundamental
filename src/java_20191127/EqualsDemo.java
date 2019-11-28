package java_20191127;

class Car{
	String modelNumber;
	String color;
	Car(String modelNumber, String color){
		this.modelNumber = modelNumber;
		this.color = color;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((modelNumber == null) ? 0 : modelNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (modelNumber == null) {
			if (other.modelNumber != null)
				return false;
		} else if (!modelNumber.equals(other.modelNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [modelNumber=" + modelNumber + ", color=" + color + "]";
	}
	
}
public class EqualsDemo {
	public static void main(String[] args) {
		Car c1 = new Car("000001","black");
		Car c2 = new Car("000001","black");
		//Car c2 = c1; //hashCode(), equals() 결과값 같다
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1==c2);
		System.out.println(c1.equals(c2));
		System.out.println(c1.toString());
		
	}
	

}
