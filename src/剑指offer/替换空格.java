package 剑指offer;

public class 替换空格 {
	 static public String replaceSpace(StringBuffer str) {
//		 return str.toString().replace(" ", "%20");
		 for(int i=0;i<str.length();i++){
			 if(str.charAt(i) == ' '){
				 str.replace(i, i+1, "%20");
				 i += 2;
			 }
		 }
		 return str.toString();
	 }
	 public static void main(String[] args) {
		System.out.println(replaceSpace(new StringBuffer("hello world")));
	}
}
