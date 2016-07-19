package amcat;

/**
 * Ϊ�˽��г��й滮����Ҫ����һ����ס����סլ��Ŀ���þ�ס�ۼ�������ͼ�Ѿ������ã����滮����n��m���������ĳ������Ԫ�����ݶ���һ���֣������丳ֵΪ1������ǿյأ������丳ֵΪ0����ֵΪ1���������絥Ԫ��ɵĴ���Ϊһ������סլ���ԽǷ��õ�ֵΪ1�������򲻱���Ϊͬһ��סլ��
����countHomes�������һ��n��mֻ����0��1�Ķ�ά����grid������n��m�ֱ��ʾ�к��С��÷�������һ����ʾסլ������������
ʾ������/���
TestCase 1
Input:
{ { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } },5,5
Expected Return Value:
1
 * @author Administrator
 *
 */
public class CountHomes {
	static void dfs(int[][] table,int x,int y){
		
		table[x][y] = -1;
		if(y+1<table[0].length){
			if(table[x][y+1] == 1){
				dfs(table,x,y+1);				
			}
		}
		if(x+1 < table.length){
			if(table[x+1][y] == 1){
				dfs(table,x+1,y);
			}
		}
	}
	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, {0,0,0,0} };
		int sum = 0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j] == -1)continue;
				if(grid[i][j] == 1){
					dfs(grid,i,j);
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
}
