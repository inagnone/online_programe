package amcat;

/**
 * ��ķ�ոտ�ʼѧϰӢ����ĸ���Ե�������ܸ���Ȥ�����ܹ�Ѹ��ȷ���Ƿ���Խ���Щ����������һ���б��У�ʹ�ø��б����κε��ʵ�����ĸ��ǰһ�����ʵ�β��ĸ��ͬ�����ܱ�дһ����������������ķ�����ж���
����canArrangeWords���������һ������num��һ������arr��num��ʾ�б��е��ʵ���Ŀ��1<=num<=100������arrӦ����ֻ�ɡ�a��-��z����ɵĵ���(2<=arr�е��ʳ���<=100)
����б��еĵ��ʿɰ���Ҫ��ķ�ʽ���У�����1�����򷵻�-1�������������У��б��еĵ�һ�����ʿ���������ĸ��ͷ������Ҫ����Լ��������
����������
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
