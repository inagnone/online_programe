package amcat;

/**
 * 最近最少使用（LRU）缓存算法从缓存中收回最近最少使用的元素（当缓存满时）。当缓存请求元素后，应将元素添加到缓存（如果之前不在缓存中），并将其作为缓存中最近最多使用的元素。
给定高速缓存的最大容量和一个整数列表（向缓存发出请求），使用LRU高速缓存算法计算高速缓存请求失败的次数。当请求的整数不在高速缓存中时，说明高速缓存请求失败。
初始状态下高速缓存是空的。

方法lruCountMiss的输入包含一个整数max_cache_size和一个数组pages

函数将返回使用LRU缓存算法算出的请求失败次数。
示例输入/输出

TestCase 1
Input:
3, { 7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0},16
Expected Return Value:
11

TestCase 2
Input:
2, { 2,3,1,3,2,1,4,3,2 },9
Expected Return Value:
8
 * @author Administrator
 *
 */
public class lruCountMiss {
	class window{
		int[] window;
		int len;
		public window(int size) {
			// TODO 自动生成的构造函数存根
			window = new int[size];
			len = 0;
		}
	}
	int contain(int[] window,int len,int target){
		for(int i=0;i<len;i++){
			if(window[i] == target){
				return i;
			}
		}
		return -1;
	}
	
	int[] move(int[] window,int len,int targetindex){
		for(int i=targetindex-1;i>=0;i--){
			window[i+1] = window[i];
		}
		return window;
	}
	
	int[] add(int[] window,int len,int target){
		if(len==0){
			window[0] = target;
			return window;
		}else if(len < window.length){
			for(int i=len-1;i>=0;i--){
				window[i+1] = window[i];
			}
			window[0] = target;
			return window;
		}else{
			window = move(window,len,len-1);
			window[0] = target;
			return window;
		}
	}
	
	int put(window window,int target){
		int index = contain(window.window, window.len, target);
		if( index!= -1){
			window.window = move(window.window,window.len,index);
			window.window[0] = target;
			return 0;
		}else{
			if(window.len < window.window.length){
				add(window.window, window.len, target);
				window.len++;
			}else{
				add(window.window,window.len,target);
			}
			return 1;
		}
	}
	int lruMissCount(int[] page, int max_lru_size, int len){
		window window = new window(max_lru_size);
		int index = 0;
		int sum = 0;
		for(int i=0;i<len;i++){
			sum = sum + put(window, page[i]);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		lruCountMiss demo = new lruCountMiss();
		int[]  a = { 2,3,1,3,2,1,4,3,2 };
		System.out.println(demo.lruMissCount(a, 2, 9));
	}
}
