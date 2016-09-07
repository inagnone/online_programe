package huawei;

import java.util.LinkedList;
import java.util.Scanner;

public class 明明的随机数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			LinkedList<Integer> randoms = new LinkedList<>();
			int now;
			for(int i=0;i<n;i++){
				boolean add = true;
				now = scanner.nextInt();
				for(int j = 0;j<randoms.size();j++){
					if(now == randoms.get(j)){
						add = false;
						break;
					}
					if(now < randoms.get(j)){
						randoms.add(j, now);
						add = false;
						break;
					}
				}
				if(add){
					randoms.add(now);
				}
			}
			for(int i=0;i<randoms.size();i++){
				System.out.println(randoms.get(i));
			}
		}
	}
}
