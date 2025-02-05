import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		dp=new int[n+1];
		dp[1]=0;
		
		for(int i=2;i<=n;i++) {
			dp[i]=-1;
		}
		
		System.out.println(recur(n));
	}
	
	static int recur(int n) {
		
		if(dp[n]!=-1) {
			return dp[n];
		}
		
		if(n%2==0 && n%3==0) {
			dp[n]=Math.min(Math.min(recur(n/3), recur(n/2)),recur(n-1))+1;
		}else if(n%2==0) {
			dp[n]=Math.min(recur(n/2), recur(n-1))+1;
		}else if(n%3==0) {
			dp[n]=Math.min(recur(n/3), recur(n-1))+1;
		}else {
			dp[n]=recur(n-1)+1;
		}
		
		return dp[n];
	}
	
}
