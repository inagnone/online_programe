package amcat;

/**
 * �������ʹ�ã�LRU�������㷨�ӻ������ջ��������ʹ�õ�Ԫ�أ���������ʱ��������������Ԫ�غ�Ӧ��Ԫ����ӵ����棨���֮ǰ���ڻ����У�����������Ϊ������������ʹ�õ�Ԫ�ء�
�������ٻ�������������һ�������б��򻺴淢�����󣩣�ʹ��LRU���ٻ����㷨������ٻ�������ʧ�ܵĴ�������������������ڸ��ٻ�����ʱ��˵�����ٻ�������ʧ�ܡ�
��ʼ״̬�¸��ٻ����ǿյġ�

����lruCountMiss���������һ������max_cache_size��һ������pages

����������ʹ��LRU�����㷨���������ʧ�ܴ�����
ʾ������/���

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
			// TODO �Զ����ɵĹ��캯�����
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
