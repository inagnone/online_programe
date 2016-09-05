package dp;

import java.util.Scanner;

/**
 *  A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly 
 *  alternate between positive and negative. The first difference (if one exists) may be either positive or 
 *  negative. A sequence with fewer than two elements is trivially a zig-zag sequence.For example, 1,7,4,9,2,5 is 
 *  a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. 
 *  In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because its first two differences 
 *  are positive and the second because its last difference is zero.Given a sequence of integers, sequence, 
 *  return the length of the longest subsequence of sequence that is a zig-zag sequence. A subsequence is 
 *  obtained by deleting some number of elements (possibly zero) from the original sequence, leaving the 
 *  remaining elements in their original order. 
 *  
 *  
 *  相邻两数的差是正负相间的序列称为ZigZag,求给定序列的最长ZigZag序列长度
 *  
 * @author Administrator
 *
 */
public class ZigZag {

	 public static int longestZigZag(int[] sequence){
		 if(sequence.length == 0)return 0;
		 int A[] = new int[sequence.length-1];
		 for(int i=1;i<sequence.length;i++){
			 A[i-1] = sequence[i] - sequence[i-1];
		 }
		 
		 int len = 1;
		 int d[] = new int[A.length];
		 for(int i=0;i<d.length;i++){
			 d[i] = 1;
		 }
		 
		 for(int i=1;i<A.length;i++){
			 for(int j=0;j<i;j++){
				 if(A[i]*A[j] <0 && d[i] < d[j]+1){
					 d[i] = d[j] +1;
				 }
			 }
			 if(len < d[i]){
				 len = d[i];
			 }
		 }
		 return len+1;
	 }
	
	public static void main(String[] args) {
		int[] A = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		
		int res = longestZigZag(A);
		System.out.println(res);
		
	}
}
