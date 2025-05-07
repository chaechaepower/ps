import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testN;t++) {
			int n=Integer.parseInt(br.readLine());
			
			int[][] arr=new int[n+1][n+1];
			
			arr[1][1]=1;
			
			for(int i=2;i<n+1;i++) {
				for(int j=1;j<=i;j++) {
					arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
				}
			}
			
			System.out.println("#"+t);
			
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<=i;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
