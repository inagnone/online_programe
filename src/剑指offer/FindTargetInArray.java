package 剑指offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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
