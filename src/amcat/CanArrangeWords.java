package amcat;

/**
 * 拉姆刚刚开始学习英文字母，对单词排序很感兴趣，他能够迅速确定是否可以将这些单词排列在一个列表中，使得该列表中任何单词的首字母与前一个单词的尾字母相同，力能编写一个计算机程序帮助拉姆进行判断吗？
函数canArrangeWords的输入包含一个整数num和一个单词arr。num表示列表中单词的数目（1<=num<=100），而arr应包含只由’a’-‘z’组成的单词(2<=arr中单词长度<=100)
如果列表中的单词可按照要求的方式排列，返回1；否则返回-1。在这种排列中，列表中的第一个单词可以任意字母开头，不需要满足约束条件。
测试用例：
TestCase 1:Input:4, [abcd,defg,ghij,jkl] Expected Return Value:1
TestCase 2: Input: 4,[ghij,defg,jkl,abcd] Expected Return Value:1
 * @author Administrator
 *
 */
public class CanArrangeWords {
	
	String[] remove(String[] arr,int index){
		String[] a = new String[arr.length-1];
		for(int i=0,j=0;i<arr.length;i++){
			if(i==index)continue;
			a[j] = arr[i];
			j++;
		}
		return a;
	}
	
	String[] add(String[] arr,String targer){
		String[] a;
		if(arr == null){
			a = new String[1];
			a[0] = targer;
		}else{
			a = new String[arr.length+1];			
			for(int i=0;i<arr.length;i++){
				a[i] = arr[i];
			}
			a[arr.length] = targer;
		}
		return a;
	}
	
	boolean put(String[] arr,String[] newarr){
		if(newarr == null){
			for(int i=0;i<arr.length;i++){
				boolean result = put(remove(arr, i), add(newarr, arr[i]));
				if(result)return result;
			}
			return false;
		}else{
			boolean result;
			for(int i=0;i<arr.length;i++){
				if(newarr[newarr.length-1].charAt(newarr[newarr.length-1].length()-1) == arr[i].charAt(0)){
					result =  put(remove(arr, i), add(newarr, arr[i]));
					if(result)return result;
				}
			}
			if(arr.length == 0){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public int CanArrangeWords(String[] arr){
		if(put(arr, null)){
			return 1;
		}else{
			return -1;
		}
	}
	
	public static void main(String[] args) {
		CanArrangeWords demo = new CanArrangeWords();
		String[] a = {"gj","ad","dg","jl"};
		int r= demo.CanArrangeWords(a);
		System.out.println(r);
	}
}
