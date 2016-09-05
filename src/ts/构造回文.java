package ts;

import java.util.Scanner;

/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
输出需要删除的字符个数。
输入描述:
输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
输出描述:
对于每组数据，输出一个整数，代表最少需要删除的字符个数。
输入例子:
abcda
google
输出例子:
2
2
 * @author Administrator
 *
 */
public class 构造回文 {
	
	static public int funtion(String in){
		StringBuilder builder = new StringBuilder(in);
		StringBuilder reverse = builder.reverse();
		int max = 0;
		int result = 0;
		int n,i,j;
		for(n=0;n<builder.length();n++){
			max = 0;
			int at = 0;
			for(i=n,j=n;i<builder.length();i++){
				for(j=at;j<in.length();j++){
					if(builder.charAt(i) == in.charAt(j)){
						max++;
						at = j+1;
						break;
					}
				}
				if(at > in.length()-1 || i>=builder.length()){
					break;
				}
			}
			if(max > result){
				result = max;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String in = scanner.next();
			System.out.println(in.length()-funtion(in));
		}
		
	}
}
