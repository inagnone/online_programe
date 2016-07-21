package 剑指offer;

import structure.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。 
 * @author Administrator
 *
 */
public class RebuildTree {
	//获取子数组
    static int[] getsubarray(int[] a,int start,int end){
        if(start >= a.length ){
            return null;
        }
        int[] result = new int[end-start+1];
        int i,index;
        for(i=start,index=0;i<=end;i++,index++){
            result[index] = a[i];
        }
        return result;
    }
    
    //获取目标元素下标
    static int indexof(int[] a,int target){
        for(int i=0;i<a.length;i++){
            if(a[i] == target){
                return i;
            }
        }
        return -1;
    }
    
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = null;
        root = new TreeNode(pre[0]);
        if(pre.length >1){
            int[] lp = getsubarray(pre,1,indexof(in,pre[0]));
            int[] lin = getsubarray(in,0,indexof(in,pre[0])-1);
            int[] rp = getsubarray(pre,indexof(in,pre[0])+1,pre.length-1);
            int[] rin = getsubarray(in,indexof(in,pre[0])+1,in.length-1);
        	root.left = reConstructBinaryTree(lp,lin);
            root.right = reConstructBinaryTree(rp,rin);
        }else{
            return root;
        }
        return root;
    }
}
