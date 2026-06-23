class Solution {
	static final int MOD = 1_000_000_007;
	int[][] dp; // n x m

	public int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		dp = new int[m + 1][n + 1];

		dp[1][1] = 1;

		for (int i = 0; i < puddles.length; i++) {
			int x = puddles[i][0];
			int y = puddles[i][1];
			dp[x][y] = -1;
		}

		for (int x = 1; x <= m; x++) {
			for (int y = 1; y <= n; y++) {
				if(x==1 && y==1) {
					continue;
				}
				
				if (dp[x][y] == -1) {
					dp[x][y] = 0;
					continue;
				}

				dp[x][y] = (dp[x - 1][y] + dp[x][y - 1]) % MOD;
			}
		}

		answer = dp[m][n];
		return answer;
	}
}