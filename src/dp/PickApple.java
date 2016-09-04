package dp;

public class PickApple {
	
	public static int function(int [][] apples){
		int[][] S = new int[apples.length][apples.length];
		S[0][0] = apples[0][0];
		for(int i=1;i<apples[0].length;i++){
			S[0][i] = S[0][i-1] + apples[0][i]; 
		}
		for(int i=1;i<apples.length;i++){
			S[i][0] = S[i-1][0] + apples[i][0];
		}
		for(int i=1;i<apples.length;i++){
			for(int j=1;j<apples[i].length;j++){
					if(S[i-1][j] > S[i][j-1]){
						S[i][j] = S[i-1][j] + apples[i][j];
					}else{
						S[i][j] = S[i][j-1] + apples[i][j];
					}
			}
		}
		return S[apples.length][apples.length];
	}
}
