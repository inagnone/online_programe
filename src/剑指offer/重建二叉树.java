package 剑指offer;

import java.util.ArrayList;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,
 * 5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * @author inag
 *
 */
public class 重建二叉树 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	static int[] subpreleft(int[] array,int index){
	
		int[] sub = new int[index];
		for(int i=0,j=1;i<sub.length;i++,j++){
			sub[i] = array[j];
		}
		return sub;
	}
	static int[] subpreright(int[] array,int index){
		if(index+1 == array.length){
			return null;
		}
		int[] sub = new int[array.length-index-1];
		for(int i=0,j = index+1;i<sub.length;i++,j++){
			sub[i] = array[j];
		}
		return sub;
	}
	static int[] subinleft(int[] array,int index){
		
		int[] sub = new int[index];
		for(int i=0;i<index;i++){
			sub[i] = array[i];
		}
		return sub;
	}
	static int[] subinright(int[] array,int index){
		
		int[] sub = new int[array.length-index-1];
		for(int i=0,j = index+1;i<sub.length;i++,j++){
			sub[i] = array[j];
		}
		return sub;
	}
	static public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		int rootval = pre[0];
		TreeNode root = new TreeNode(rootval);
		if(pre.length == 1){
			return root;
		}
		for(int i=0;i<in.length;i++){
			if(rootval == in[i]){
				if(i == 0){
					root.left = null;
				}else{
					root.left = reConstructBinaryTree(subpreleft(pre, i), subinleft(in, i));					
				}
				if(i == in.length-1){
					root.right = null;
				}else{
					root.right = reConstructBinaryTree(subpreright(pre, i), subinright(in, i));					
				}
			}
		}
        return root;
    }
	
	
	
	
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode node = reConstructBinaryTree(pre, in);
		System.out.println();
	}
}
