package dp;


/**
 * 求最长非降子序列
 * @author Administrator
 *
 */
public class LIS {
	
	/**
	 * d(i):求前i位的最长非降字序列
	 * d(i) = max{d(j)+1,1} j<i
	 * @param A
	 * @return
	 */
	public static int function(int[] A){
		int d[] = new int[A.length];
		for(int i=0;i<d.length;i++){
			d[i] = 1;
		}
		int len = 1;
		for(int i=0;i<A.length;i++){
			for(int j=0;j<i;j++){
				if(A[j] <= A[i] && d[i] < d[j]+1){
					d[i] = d[j]+1; 
				}
			}
			if(d[i] > len){
				len = d[i];
			}
		}
		return len;
	}
	
	public static void main(String[] args) {
		
		int[] A = {5, 3, 4, 8, 6, 7};
		System.out.println(function(A));
		
	}
}
