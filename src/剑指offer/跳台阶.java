package 剑指offer;

public class 跳台阶 {
	 static public int JumpFloor(int target) {
			int count = 0;
	        if(target>=2){
	            count += JumpFloor(target-2);
	        }
	        if(target>=1){
	            count += JumpFloor(target-1);
	        }
	        if(target == 0) return count+1;
	        return count;
	 }
	 public static void main(String[] args) {
		int a = JumpFloor(6);
		System.out.println(a);
	}
}
