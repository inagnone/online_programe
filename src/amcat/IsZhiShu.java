package amcat;

public class IsZhiShu {
	static boolean iszhishu(int num){
		if(num == 1 || num ==2)return true;
		for(int i=2;i*i<=num;i++){
			if(num %i ==0){
				return false;
			}
		}
		return true;
	}
}
