package amcat;

/**
 * 为了进行城市规划，需要计算一个居住区的住宅数目。该居住聚集区俯视图已经制作好，并规划成了n×m个网格。如果某个网格单元具有屋顶的一部分，则向其赋值为1，如果是空地，则向其赋值为0。由值为1的相邻网络单元组成的簇认为一个单独住宅。对角放置的值为1的网格则不被视为同一个住宅。
方法countHomes输入包括一个n×m只包含0和1的二维数组grid，其中n和m分别表示行和列。该方法返回一个表示住宅总数的整数。
示例输入/输出
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
