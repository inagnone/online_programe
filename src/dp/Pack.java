package dp;

import java.util.Scanner;

/**
 * 0/1��������
 * @author Administrator
 *
 */
public class Pack {
	
	/**
	 * n����ͬ��ֵ�ı�ʯ�Ž������C�ı����У�����ȡ�õı�ʯ������ֵ
	 * @param value	���飬��Ŷ�Ӧ�±��ŵı�ʯ�ļ�ֵ
	 * @param V	���飬��Ŷ�Ӧ�±��ŵı�ʯ�����
	 * @param C	�������
	 * @return	�ܻ�ȡ�����ʯ�ܼ�ֵ
	 */
	public static int function(int[] value,int[] V,int C){
		
		//������ֵ
		int[][] result = new int[V.length+1][C+1];
		for(int i=0;i<=V.length;i++){
			for(int j=0;j<=C;j++){
				result[i][j] = i == 0 ? 0:result[i-1][j];	//���ѱ��Ϊi-1�ı�ʯ�Ž�����
				if(i>0 && j>=V[i-1]){						//�ѱ��Ϊi-1�ı�ʯ�Ž�����
					result[i][j] = result[i][j]>(result[i-1][j-V[i-1]]+value[i-1])?result[i][j]:(result[i-1][j-V[i-1]]+value[i-1]);
				}
			}
		}
		
		//�����շ��뱳���еı�ʯ�ı��
		int[] x = new int[V.length];
		for(int i=V.length,j=C;i>0;i--){
			if(result[i][j] > result[i-1][j]){	//���d(i,j)>d(d-1,j)ʱ���ض������˱��Ϊi�ı�ʯ������d(i,j)=d(i-1,j)
				x[i-1] = 1;
				j = C-V[i-1];	//��֪��i����ʯ�Ѿ������˱���������ǰi-1����ʯֻ��ռ��C-V[i]�����
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
