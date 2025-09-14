import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			int[] volumes=new int[n+1];
			int[] costs=new int[n+1];
			
			for(int i=1;i<n+1;i++) {
				st = new StringTokenizer(br.readLine());
				volumes[i]=Integer.parseInt(st.nextToken());
				costs[i]=Integer.parseInt(st.nextToken());
			}
			
			int[][] dp=new int[n+1][k+1]; //dp[i][j]: 물건을 1~i번까지 고려하여 무게 j를 만드는 최대 가치 수 
			
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<k+1;j++) {
					if(j<volumes[i]) dp[i][j]=dp[i-1][j];
					else dp[i][j]=Math.max(dp[i-1][j-volumes[i]]+costs[i], dp[i-1][j]);
				}
			}
			
			System.out.printf("#%d %d\n",t,dp[n][k]);
		}
	}
}
