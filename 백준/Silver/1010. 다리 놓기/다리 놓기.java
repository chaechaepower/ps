import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= testN; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			dp = new int[m + 1][n + 1];

			System.out.println(recur(m, n));
		}
	}

	private static int recur(int n, int r) {
		if(n==r || r==0) return dp[n][r] = 1;
		
		if (dp[n][r] == 0) {
			dp[n][r] = recur(n - 1, r - 1) + recur(n - 1, r);
		}

		return dp[n][r];
	}
}
