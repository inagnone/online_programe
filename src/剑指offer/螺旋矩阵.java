package 剑指offer;

import java.util.ArrayList;
/**
 * 记录当前还剩行数和列数，模拟过程
 * @author inag
 *
 */
public class 螺旋矩阵 {
	static public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		if(matrix == null)return list;
		if(matrix[0].length == 1){
			for(int i=0;i<matrix.length;i++){
				list.add(matrix[i][0]);
			}
			return list;
		}
		int xnum = matrix.length;
		int ynum = matrix[0].length;
		int x=0,y=0;
		int to = 6;
		while(list.size() != matrix.length*matrix[0].length){
			switch (to) {
			case 6:
				
				for(int i=0;i<ynum;i++){
					list.add(matrix[x][y]);
					y++;
				}
				y--;
				x++;
				xnum--;
				to = 2;
				break;
			case 2:
				for(int i=0;i<xnum;i++){
					list.add(matrix[x][y]);
					x++;
				}
				x--;y--;
				ynum--;
				to = 4;
				break;
			case 4:
				for(int i=0;i<ynum;i++){
					list.add(matrix[x][y]);
					y--;
				}
				y++;
				x--;
				xnum--;
				to = 8;
				break;
			case 8:
				for(int i=0;i<xnum;i++){
					list.add(matrix[x][y]);
					x--;
				}
				x++;
				y++;
				ynum--;
				to = 6;
				break;
				
			default:
				break;
			}
		}
		return list;
	}
	public static void main(String[] args) {
		int[][] a = {{1,2},{5,6},{9,10},{13,14}};
		ArrayList<Integer> printMatrix = printMatrix(a);
		System.out.println(printMatrix);
	}
}
