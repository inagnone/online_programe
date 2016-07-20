package amcat;

import java.util.ArrayList;
import java.util.List;

public class Getzhiyinzi {
	static List<Integer> findzhiyinzi(int n){
		ArrayList<Integer> list = new ArrayList<>();
		if(n ==1 || n == 2){
			list.add(n);
			return list;
		}
		if(IsZhiShu.iszhishu(n)){
			list.add(n);
			return list;
		}
		int i=0;
		for(i=2;i<n;i++){
			if((n%i==0) && IsZhiShu.iszhishu(i)){
				list.add(i);
				
			}
		}
		return list;
	}
	
	static List<Integer> findyinzi(int n){
		ArrayList<Integer> list = new ArrayList<>();
		if(IsZhiShu.iszhishu(n)){
			list.add(n);
			list.add(1);
			return list;
		}
		for(int i=1;i<n;i++){
			if(n%i == 0	){
				list.add(i);
			}
		}
		return list;
	}
	
	static int checkperfectNumberCheck(int n){
		List<Integer> list = findyinzi(n);
		int sum = 0;
		for(int a:list){
			sum = sum+a;
		}
		if(sum == n){
			return 1;
		}else{
			return -1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(findyinzi(28));
		System.out.println(checkperfectNumberCheck(28));
	}
}
