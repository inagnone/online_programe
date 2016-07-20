package 剑指offer;
import java.util.ArrayList;

/**
 * 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。

给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
测试样例：

"cdab",4,"abcd",4

返回：true
 * @author inag
 *
 */
public class Rotation {
	 static public boolean chkRotation(String A, int lena, String B, int lenb) {
	        // write code here
		 if(lena != lenb)return false;
		 char a = B.charAt(0);
		 ArrayList<Integer> list = new ArrayList<>();
		 for(int i=0;i<A.length();i++){
			 if(A.charAt(i) == a){
				 list.add(i);
			 }
		 }
		 for(int indexOf:list){
			 String pre = A.substring(0, indexOf);
			 String next = A.substring(indexOf);
			 String n = next+pre;
			 if(n.equals(B)){
				 return true;
			 }else{
				 continue;
			 }
		 }
		 return false;
	 }
	 public static void main(String[] args) {
		System.out.println(chkRotation("cdab", 4, "abcd", 4));
	}
}
