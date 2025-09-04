import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[][] costs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1][3];
		costs = new int[n+1][3]; //0은 빨, 1은 초, 2는 파 
		
		for(int i=1;i<n+1;i++) {
			Arrays.fill(dp[i], -1);
		}
		
		StringTokenizer st;
		for(int i=1;i<n+1;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) { 
				costs[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<3;i++) {
			dp[1][i]=costs[1][i];
		}

		int min=Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			min=Math.min(recur(n,i), min);
		}
		
		System.out.println(min);
	}
	
	private static int recur(int n, int i) {
		if(dp[n][i]==-1) {
			if(i==0) {
				dp[n][i]=Math.min(recur(n-1,1), recur(n-1,2))+costs[n][0];
			}
			else if(i==1) {
				dp[n][i]=Math.min(recur(n-1,0), recur(n-1,2))+costs[n][1];
			}
			else {
				dp[n][i]=Math.min(recur(n-1,0), recur(n-1,1))+costs[n][2];
			}
		}
		
		return dp[n][i];
	}
}
