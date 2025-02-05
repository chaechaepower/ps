import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		dp=new Long[n+1][10];
		
		if(n==1) {
			System.out.println(9);
			return;
		}
		
		dp[2][0]=(long) 1;
		dp[2][1]=(long) 1;
		dp[2][2]=(long) 2;
		dp[2][3]=(long) 2;
		dp[2][4]=(long) 2;
		dp[2][5]=(long) 2;
		dp[2][6]=(long) 2;
		dp[2][7]=(long) 2;
		dp[2][8]=(long) 2;
		dp[2][9]=(long) 1;
		
		if(n>2) {
			for(int i=3;i<=n;i++) {
				dp[i][0]=dp[i-1][1];
				dp[i][9]=dp[i-1][8];
				for(int j=1;j<=8;j++) {
					dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
				}
			}
		}
		
		long result=0;
		for(int i=0;i<10;i++) {
			result+=dp[n][i];
		}
		System.out.println(result%1000000000);
	}


}
