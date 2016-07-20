package 剑指offer;
import java.util.Scanner;
import java.util.Stack;

import structure.TreeNode;



/**
 * 跟据一个先序字符串生成其对应的二叉树
 * 字符串格式：“1!2!#!3!#!#!4!#!#!”
 * !表示节点结束，#表示节点为空
 * @author inag
 *
 */
public class CreateTree {
	static  TreeNode  createtree(String s){
		String[] nodes = s.split("!");
		int i=0;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(Integer.valueOf(nodes[i++]));
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode now = stack.pop();
			if(!nodes[i].equals("#")){
				TreeNode next = new TreeNode(Integer.valueOf(nodes[i++]));
				if(now.finish == 0){
					now.left = next;
					now.finish++;
					stack.push(now);
					stack.push(next);
				}else{
					now.right = next;
					stack.push(next);
					now.finish++;
				}
			}else{
				i++;
				if(now.finish<1){
					now.finish++;
					stack.push(now);
				}
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		createtree(s);
		System.out.println();
	}
}
