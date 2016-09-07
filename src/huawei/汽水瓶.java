package huawei;

import java.util.Scanner;

public class ÆûË®Æ¿ {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int sum = 0;
			if(n != 0){
				sum = 0;
				while(n>=3){
					sum += n/3;
					n = n/3+n%3;
				}
				if(n == 2){
					sum++;
				}
				System.out.println(sum);
			}else{
				break;
			}
		}
	}
}
