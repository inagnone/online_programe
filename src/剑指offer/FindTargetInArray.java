package ��ָoffer;

/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * @author Administrator
 *
 */
public class FindTargetInArray {
	    public boolean Find(int [][] array,int target) {
	        if(array.length == 0){
	            return false;
	        }
			for(int i=0;i<array.length;i++){
	            if(array[i] == null || array[i].length ==0)continue;
	            if(array[i][0] <= target && array[i][array[i].length-1] >= target){
	                for(int j=0;j<array[i].length;j++){
	                    if(target == array[i][j]){
	                        return true;
	                    }
	                }
	                
	            }
	        }
	        return false;
	    }
}
