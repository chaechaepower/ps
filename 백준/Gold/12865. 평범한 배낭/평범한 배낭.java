import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] items=new int[n+1][2]; //0은 무게, 가치
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0]=Integer.parseInt(st.nextToken());
			items[i][1]=Integer.parseInt(st.nextToken());
		}
		
		int[][] dp=new int[n+1][k+1];
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<k+1;j++) {
				if(items[i][0]>j) {
					dp[i][j]=dp[i-1][j];
					continue;
				}
				
				dp[i][j]=Math.max(dp[i-1][j-items[i][0]]+items[i][1], dp[i-1][j]);
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
