import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t=1;t<=testN;t++) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			dp = new int[n+1][m+1];
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<m+1;j++) {
					if(i==j) {
						dp[i][j]=1;
					}
					
					if(i==1) {
						dp[i][j]=j;
					}
				}
			}
			
			System.out.println(recur(n,m));
		}		
	}
	
	private static int recur(int n, int m) {
		if(dp[n][m]==0) {
			for(int k=m-1;k>=n-1;k--) {
				dp[n][m]+=recur(n-1,k);
			}
		}
		
		return dp[n][m];
	}
}
