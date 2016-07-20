package 剑指offer;
import java.util.Scanner;

public class Main树的子结构 {
	static class node{
		node pre;
		node[] next;
		int value;
		public node(int v) {
			// TODO Auto-generated constructor stub
			this.value = v;
		}
	}
	
	static boolean equal(node t1,node t2){
		while(t1 != null && t2 != null && t1.value == t2.value && t1.next.length == t2.next.length){
			for(int i=0;i<t1.next.length;i++){
				boolean result = equal(t1.next[i], t2.next[i]);
				if(!result){
					break;
				}
			}
		}
		if(t2 == null){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n,m;
		node[] treeA;
		node[] treeB;
		while(scanner.hasNext()){
			n = scanner.nextInt();
			m = scanner.nextInt();
			
			treeA = new node[n];
			for(int i=0;i<n;i++){
				treeA[i] = new node(scanner.nextInt());
			}
			for(int i=0;i<n;i++){
				int num = scanner.nextInt();
				treeA[i].next = new node[num];
				for(int j=0;j<num;j++){
					int temp = scanner.nextInt();
					treeA[i].next[j] = treeA[temp-1];
					treeA[temp-1].pre = treeA[i];
				}
			}
			
			treeB = new node[m];
			for(int i=0;i<m;i++){
				treeB[i] = new node(scanner.nextInt());
			}
			for(int i=0;i<m;i++){
				int num = scanner.nextInt();
				treeB[i].next = new node[num];
				for(int j=0;j<num;j++){
					int temp = scanner.nextInt();
					treeB[i].next[j] = treeB[temp-1];
					treeB[temp-1].pre = treeB[i];
				}
			}
			
			equal(treeA[0], treeB[0]);
			System.out.println();
		}
	}
}
