package ts;

import java.util.Scanner;

/**
 * ����һ���ַ���s������Դ���ɾ��һЩ�ַ���ʹ��ʣ�µĴ���һ�����Ĵ������ɾ������ʹ�û��Ĵ���أ�
 * �����Ҫɾ�����ַ�������
 * @author Administrator
 *
 */
public class ������� {
	
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
