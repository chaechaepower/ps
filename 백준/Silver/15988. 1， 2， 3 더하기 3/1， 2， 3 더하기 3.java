import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		long[] dp = new long[1000001]; // 1~ 1000000
		Arrays.fill(dp, -1);
		
		dp[1]=1; dp[2]=2; dp[3]=4;
		
		for(int i=4;i<1000001;i++) {
			dp[i]=(dp[i-3]+dp[i-2]+dp[i-1])% 1000000009;
		}

		for (int t = 1; t <= testN; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n] % 1000000009);
		}
	}

}

/*
 * dp[1]=1;
 * dp[2]=1+1 / 2
 * dp[3]=1+dp[2] / 2+dp[1] / 3
 * 
 * dp[n]=dp[n-3]+dp[n-2]+dp[n-1]
 * */
