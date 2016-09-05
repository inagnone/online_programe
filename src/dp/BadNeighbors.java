package dp;

public class BadNeighbors {
	
	static  int maxDonations(int[] donations){
		 int d[][] = new int[donations.length][donations.length];
		 int sum = 0;
		 for(int i=0;i<d.length;i++){
			 d[i][i] = 1;
			 if(i==0){
				 continue;
			 }
			 int sr = donations[i];
			 int index = i;
			 boolean self = true;
			 for(int j=0;j<i;j++){
				 int s = 0;
				 for(int y=0;y<d.length;y++){
					 if(d[j][y] == 1){
						 s += donations[y];
					 }
				 }
				 if(s + donations[i] > sr){
					 if(d[j][i-1] != 1 && d[j][(i+1)%d.length] != 1){
						 sr = s + donations[i];
						 self = true;
						 index = j;
					 }else if(s > sr){
						 sr = s;
						 self = false;
						 index = j;
					 }
				 }
			 }
			 for(int x = 0;x<d.length;x++){
				 d[i][x] = d[index][x];
			 }
			 if(self){
				 d[i][i] = 1;
			 }
		 }
		 for(int i=0;i<d.length;i++){
			 int s = 0;
			 for(int j=0;j<d.length;j++){
				 if(d[i][j] == 1){
					 s += donations[j];
				 }
			 }
			 if(sum < s){
				 sum = s;
			 }
		 }
		 return sum;
	 }
	 
	 public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		int i = maxDonations(A);
		System.out.println(i);
	}
}
