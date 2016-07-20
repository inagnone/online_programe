package 剑指offer;

public class 二维数组中的查找 {
    public boolean Find(int [][] array,int target) {
		int indexi = array.length-1;
        if(array == null) return false;
         if(array.length == 0) return false;
        while(indexi >=0 ){
            if(array[indexi] == null || array[indexi].length == 0){
                indexi--;
                continue;
            }
            if(array[indexi][0] <= target){
                for(int t:array[indexi]){
                    if(t == target) return true;
                }
            }
            indexi--;
        }
        return false;
    }
}
