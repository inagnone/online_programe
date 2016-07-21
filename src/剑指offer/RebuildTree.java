package ��ָoffer;

import structure.TreeNode;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء� 
 * @author Administrator
 *
 */
public class RebuildTree {
	//��ȡ������
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
    
    //��ȡĿ��Ԫ���±�
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
