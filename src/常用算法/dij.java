package 常用算法;

public class dij {
	static class dist{
		int length;
		int pre;
	}
	
	/**
	 * 路径信息初始化
	 * @param grap
	 * @return
	 */
	static private dist[] init(int[][] grap){
		dist[] paths = new dist[grap.length];
		for(int i=0;i<grap.length;i++){
			paths[i] = new dist();
			paths[i].length	= grap[0][i];
			if(paths[i].length != Integer.MAX_VALUE){
				paths[i].pre = 0;
			}else{
				paths[i].pre = -1;
			}
		}
		return paths;
	}
	
	/**
	 * 最短路径，德杰特斯拉算法
	 * 
	 * @param grap
	 */
	static void dij(int[][] grap){
		dist[] paths = init(grap);
		int minw,min;
		for(int i=0;i<grap.length;i++){
			minw = Integer.MAX_VALUE;
			min = 0;
			for(int j=1;j<grap.length;j++){
				if(grap[j][j] == 0 && paths[j].length<minw){
					min = j;
					minw = paths[j].length;
				}
			}
			if(min == 0)break;
			grap[min][min] = 1;
			for(int j=1;j<grap.length;j++){
				if(grap[j][j] == 0 && paths[j].length>paths[min].length+grap[min][j]){
					paths[j].length = paths[min].length+grap[min][j];
					paths[j].pre = min;
				}
			}
		}
	}
}
