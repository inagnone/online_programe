package dp;

public class AvoidRoads {
	static public boolean contain(String beginx,String beginy,String endx,String endy,String[] bad){
		if(bad.length == 0)return false;
		for(int i=0;i<bad.length;i++){
			String[] index = bad[i].split(" ");
			if(index[0].equals(beginx) && index[1].equals(beginy)){
				if(index[2].equals(endx) && index[3].equals(endy)){
					return true;
				}
			}
			if(index[2].equals(beginx) && index[3].equals(beginy)){
				if(index[0].equals(endx) && index[1].equals(endy)){
					return true;
				}
			}
		}
		return false;
	}
	
	static public long numWays(int width, int height, String[] bad){
		long[][] S = new long[width+1][height+1];
		S[0][0] = 1;
		boolean flag = true;
		for(int i=1;i<=width;i++){
			if(flag && !contain(String.valueOf(0),String.valueOf(i-1),String.valueOf(0),String.valueOf(i),bad)){
				S[i][0] = 1;
			}else{
				flag = false;
			}
		}
		flag = true;
		for(int i=0;i<=height;i++){
			if(flag && !contain(String.valueOf(i-1),String.valueOf(0),String.valueOf(i),String.valueOf(0),bad)){
				S[0][i] = 1;
			}else{
				flag = false;
			}
		}
		
//		for(int i=0;i<bad.length-1;i+=2){
//			Integer x = Integer.valueOf(bad[i]);
//			Integer y = Integer.valueOf(bad[i+1]);
//			S[x][y] = 0;
//		}
		
		for(int i=1;i<=width;i++){
			for(int j=1;j<=height;j++){
				if(!contain(String.valueOf(i),String.valueOf(j-1),String.valueOf(i),String.valueOf(j),bad)){
					S[i][j] += S[i][j-1];
				}
				if(!contain(String.valueOf(j-1),String.valueOf(j),String.valueOf(j), String.valueOf(i), bad)){
					S[i][j] += S[j-1][j];
				}
			}
		}
		return S[width][height];
	}
	
	public static void main(String[] args) {
		String[] s = {"0 0 1 0", "1 2 2 2", "1 1 2 1"};
		System.out.println(numWays(2, 2, s));
	}
}
