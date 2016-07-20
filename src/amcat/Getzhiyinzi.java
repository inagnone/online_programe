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
	public static void main(String[] args) {
		System.out.println(findzhiyinzi(7));
	}
}
