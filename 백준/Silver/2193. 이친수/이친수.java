import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		dp=new Long[n+1][2]; //뒷자리가 0,1의 개수 
		
		dp[1][0]=(long) 0;
		dp[1][1]=(long) 1;
		
		for(int i=2;i<=n;i++) {
			dp[i][0]=dp[i-1][0]+dp[i-1][1];
			dp[i][1]=dp[i-1][0];
		}
		
		System.out.println(dp[n][0]+dp[n][1]);
	}

}
