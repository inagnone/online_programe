package 剑指offer;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

import structure.TreeNode;

/**
 *  二叉树按广度优先打印
 * @author inag
 *
 */
public class TreePrinter {
	
	static void addqueue(LinkedList<TreeNode> list,TreeNode node){
		if(node.left != null){
			list.add(node.left);
		}
		if(node.right != null){
			list.add(node.right);
		}
	}
	static Vector<Integer> printlevel(LinkedList<TreeNode> list,TreeNode last){
		Vector<Integer> l = new Vector<>();
		int i=0;
		while(!list.peek().equals(last)){
			TreeNode node = list.pop();
			l.add(node.val);
			addqueue(list, node);
		}
		TreeNode node = list.pop();
		l.add(node.val);
		addqueue(list, node);
		return l;
	}
	
	 static public int[][] printTree(TreeNode root) {
	        // write code here
		 if(root == null){
			 return null;
		 }
		 LinkedList<TreeNode> list = new LinkedList<>();
		 list.add(root);
		 TreeNode last = root;
		 Vector<Vector<Integer>> tree = new Vector<>();
		 int i=0;
		 while(!list.isEmpty()){
			 Vector<Integer> alevel = printlevel(list, list.getLast());
			 tree.add(alevel) ;
		 }
		 int[][] result = new int[tree.size()][];
		 int l = 0;
		 for(Vector<Integer> v:tree){
			 int num = 0;
			 int[] resl = new int[v.size()];
			 for(int vv:v){
				 resl[num++] = vv;
			 }
			 result[l++] = resl;
		 }
		 return result;
	 }
	 
	 
	 public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		structure.TreeNode tree = (TreeNode) CreateTree.createtree("1!2!#!3!#!#!4!#!#!");
		int[][] printTree = printTree(tree);
		System.out.println();
	}
}
