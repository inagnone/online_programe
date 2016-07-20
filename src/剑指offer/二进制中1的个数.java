package 剑指offer;

public class 二进制中1的个数 {
	public int  NumberOf1(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for(int i=0;i<binaryString.length();i++){
        	if(binaryString.charAt(i) == '1'){
        		count++;
        	}
        }
        return count;
    }
}

