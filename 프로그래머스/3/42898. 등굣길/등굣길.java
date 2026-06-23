class Solution {
	static final int MOD = 1_000_000_007;
	int[][] dp; // n x m
	boolean[][] isPuddle;

	public int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		dp = new int[n + 1][m + 1];
		isPuddle = new boolean[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				dp[i][j] = -1;
			}
		}

		dp[1][1] = 1;

		for (int i = 0; i < puddles.length; i++) {
			int x = puddles[i][0];
			int y = puddles[i][1];

			isPuddle[y][x] = true;
		}

		answer = recur(n, m);
		return answer;
	}

	public int recur(int i, int j) {
		if (i < 1 || j < 1) {
			return 0;
		}
		
		if (isPuddle[i][j]) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		dp[i][j] = (recur(i - 1, j) + recur(i, j - 1)) % MOD;
		return dp[i][j];
	}
}
