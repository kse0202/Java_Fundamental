package java_20191119;

public class SsnDemo {
	public static void main (String[] args){
		int a1 = 9;
		int a2 = 2;
		int a3 = 0;
		int a4 = 2;
		int a5 = 0;
		int a6 = 2;
		
		int b1 = 2;
		int b2 = 1;
		int b3 = 6;
		int b4 = 9;
		int b5 = 6;
		int b6 = 1;
		int b7 = 3;
		
		//1. 각 자리수를 2부터 9까지 곱하고 다시 2-5까지 곱해서 합을 구함
		int sum = a1*2 + a2*3 + a3*4 + a4*5 + a5*6 + a6*7 + b1*8 +b2*9 + b3*2+ b4*3 + b5*4 + b6*5;
		//2. 총합을 11로 나눈 나머지를 구한다.
		int rest = sum%11;
		//3. 11에서 나머지를 뺀다.
		rest = 11-rest;
		//4. 3의 결과를 다시 10으로 나눈 나머지를 구한다.
		rest = rest%10;
		//5. 4의 결과와 맨 마지막 숫자가 같으면 "정상적인 주민번호" 
		if (rest == b7){
			System.out.println("정상적인 주민번호");
		}else{
			System.out.println("비 정상적인 주민번호");
		}
		//   그렇지 않으면 "비 정상적인 주민번호"로 메세지를 출력한다.
		
		if (rest == b7) {
			System.out.println("정상");

		} else {
			System.out.println("비 정상");

		}
		String ssn = "111111-1111118";
		String[] stringArraySsn = ssn.replace("-", "").split("");
		int[] arraySSn = new int[ssn.length()];
		
		for (int i = 0; i < ssn.length(); i++) {
			try{
		    	arraySSn[i] = Integer.parseInt(stringArraySsn[i]);
			}catch(NumberFormatException nfe){
				System.out.println("배열이상함");
			}
			}
		sum = arraySSn[1]*2 + arraySSn[2]*3 + arraySSn[3]*4 + arraySSn[4]*5 + arraySSn[5]*6 + arraySSn[6]*7 
				+ arraySSn[7]*8 +arraySSn[8]*9 + arraySSn[9]*2+ arraySSn[10]*3 + arraySSn[11]*4 + arraySSn[12]*5;
		//2. 총합을 11로 나눈 나머지를 구한다.
		rest = sum%11;
		//3. 11에서 나머지를 뺀다.
		rest = 11-rest;
		//4. 3의 결과를 다시 10으로 나눈 나머지를 구한다.
		rest = rest%10;
		//5. 4의 결과와 맨 마지막 숫자가 같으면 "정상적인 주민번호" 
		if (rest == arraySSn[13]){
			System.out.println("정상적인 주민번호");
		}else{
			System.out.println("비 정상적인 주민번호");
		}
		
		}
	
}
