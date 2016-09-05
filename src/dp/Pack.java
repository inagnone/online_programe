package dp;

import java.util.Scanner;

/**
 * 0/1背包问题
 * @author Administrator
 *
 */
public class Pack {
	
	/**
	 * n个不同价值的宝石放进体积是C的背包中，求能取得的宝石的最大价值
	 * @param value	数组，存放对应下标编号的宝石的价值
	 * @param V	数组，存放对应下标编号的宝石的体积
	 * @param C	背包体积
	 * @return	能获取的最大宝石总价值
	 */
	public static int function(int[] value,int[] V,int C){
		
		//求最大价值
		int[][] result = new int[V.length+1][C+1];
		for(int i=0;i<=V.length;i++){
			for(int j=0;j<=C;j++){
				result[i][j] = i == 0 ? 0:result[i-1][j];	//不把编号为i-1的宝石放进背包
				if(i>0 && j>=V[i-1]){						//把编号为i-1的宝石放进背包
					result[i][j] = result[i][j]>(result[i-1][j-V[i-1]]+value[i-1])?result[i][j]:(result[i-1][j-V[i-1]]+value[i-1]);
				}
			}
		}
		
		//求最终放入背包中的宝石的编号
		int[] x = new int[V.length];
		for(int i=V.length,j=C;i>0;i--){
			if(result[i][j] > result[i-1][j]){	//如果d(i,j)>d(d-1,j)时，必定放入了编号为i的宝石；否则d(i,j)=d(i-1,j)
				x[i-1] = 1;
				j = C-V[i-1];	//已知第i个宝石已经放入了背包，所以前i-1个宝石只能占用C-V[i]的体积
			}
		}
		for(int i=0;i<V.length;i++){
			System.out.print(x[i]+",");
		}
		System.out.println();
		return result[V.length][C];
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int C = scanner.nextInt();
			int[] V = new int[n];
			int[] value = new int[n];
			for(int i=0;i<n;i++){
				V[i] = scanner.nextInt();
				value[i] = scanner.nextInt();
			}
			int i = function(value, V, C);
			System.out.println(i);
		}
	}
}
