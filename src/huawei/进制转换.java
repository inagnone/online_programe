package huawei;

import java.util.Scanner;

public class ½øÖÆ×ª»» {
	static int abs(int a,int b){
		int sum = 1;
		
		for(int i=0;i<b;i++){
			sum *= a;
		}
		return sum;
	}
	public static String function(String in){
		String s = in.substring(2);
		int sum = 0;
		for(int i=0;i<s.length();i++){
			char at = s.charAt(i);
			switch (at) {
			case 'A':
				sum += 10 * abs(16,(s.length()-i-1));
				break;
			case 'B':
				sum += 11 * abs(16,(s.length()-i-1));
				break;
			case 'C':
				sum += 12 * abs(16,(s.length()-i-1));
				break;
			case 'D':
				sum += 13 * abs(16,(s.length()-i-1));
				break;
			case 'E':
				sum += 14 * abs(16,(s.length()-i-1));
				break;
			case 'F':
				sum += 15 * abs(16,(s.length()-i-1));
				break;
			default:
				sum += Integer.valueOf(at+"") * abs(16,(s.length()-i-1));
			}
		}
		return String.valueOf(sum);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){
			String in = scanner.next();
			String function = function(in);
			System.out.println(function);
		}
	}
}
