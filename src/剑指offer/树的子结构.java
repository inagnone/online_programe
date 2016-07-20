package 剑指offer;
import structure.TreeNode;
/**
 * 判断二叉数b是不是二叉数a的子树，如果空树不是子树，任何数也不是空树的子树
 * @author inag
 *
 */
public class 树的子结构 {
	static boolean same(TreeNode a,TreeNode b){
        if((a ==null && b !=null)){
            return false;
        }
        if(a != null && b!= null){
        	if(a.val != b.val) return false;
        }
        if(b == null) return true;
        return same(a.left,b.left) && same(a.right,b.right);
    }
    static public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	boolean resultleft = false,resulright = false;
    	if(root1 == null && root2 != null) return false;
    	if(root2 == null) return false;
    	if(same(root1,root2)){
            return true;
        }else{
            TreeNode next = root1;  
            if(next.left != null){
            	resultleft = HasSubtree(next.left,root2);
            }
            if(resultleft) return resultleft;
            if(next.right != null){
            	resulright = HasSubtree(next.right, root2);
            }
            return resultleft || resulright;           
        }        
    }
    public static void main(String[] args) {
		TreeNode A = CreateTree.createtree("8!8!9!#!#!2!4!#!#!7!#!#!7!#!#!");
		TreeNode B = CreateTree.createtree("8!9!#!#!2!#!#!");
		System.out.println(HasSubtree(A, B));
	}
}
