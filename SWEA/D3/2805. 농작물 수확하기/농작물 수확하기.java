import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testN;t++) {
			int n=Integer.parseInt(br.readLine());
			
			char[][] arr=new char[n][n];
			
			StringTokenizer st;
			for(int i=0;i<n;i++) {
				arr[i]=br.readLine().toCharArray();
			}
			
			int sum=0;
			int mid=n/2;
			
			for(int i=0;i<=mid;i++) {
				for(int j=mid-i;j<=mid+i;j++) {
					sum+=arr[i][j]-'0';
					if(i==mid) {
						continue;
					}
					sum+=arr[n-1-i][j]-'0';
				}
			}
			
			System.out.println("#"+t+" "+sum);
		}
		
		
	}

	
}
