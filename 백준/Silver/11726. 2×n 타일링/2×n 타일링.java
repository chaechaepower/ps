import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		dp=new Long[n+1];
		
		dp[0]=(long) 0;
		dp[1]=(long)1;
	
		if(n==1) {
			System.out.println(dp[1]);
			return;
		}
		
		dp[2]=(long)2;
		
		System.out.println(recur(n));
	}
	
	static long recur(int n) {
		
		if(dp[n]==null) {
			dp[n]=(recur(n-2)+recur(n-1))%10007;
		}
		return dp[n];
	}

}
