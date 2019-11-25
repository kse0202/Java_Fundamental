package java_20191121;

public class LotteryDemo {
	public static void main (String[] args){
		//Math.random() => 0보다  크거나 같고 1보다 작은 임의의 숫자 발생 
		
		int[] lotto = new int[6];
	
		
		for(int i = 0; i <lotto.length; i++){
			// Math.random() => 0보다 크거나 같고 1보다 작은 임의의 double 값을 반환
			double random = Math.random();
			// 1부터 45까지 임의값을 temp에 저장한다.
			int temp = (int)(random * 45)+1;
			lotto[i] = temp;
			//int lotto[i] = (int)(random*45)+1; 가능
			
			for (int j = 0; j < i; j++) {
				if (lotto[j] == lotto[i]) {
				i--;
				break;
				}
			}
		}
		//오름차순 정렬
		for (int i = 0; i < lotto.length-1; i++) {
			for (int j = 0; j < lotto.length-(i+1); j++) {
				if(lotto[j]>lotto[j+1]){
					int temp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
				}
				
			}
			
		}
		for(int i : lotto){
		System.out.print(i +"\t");
		}
	}

}
