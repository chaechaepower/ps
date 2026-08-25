import java.util.Arrays;

class Solution {
	int[][] arr; // 1: 갈 수 있음 0: 물 웅덩이
	int[][] dp;

	public int solution(int m, int n, int[][] puddles) {
		arr = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			Arrays.fill(arr[i], 1);
		}

		for (int i = 0; i < puddles.length; i++) {
			int r = puddles[i][0];
			int c = puddles[i][1];

			arr[r][c] = 0;
		}

		dp = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			Arrays.fill(dp[i], -1);
		}

		dp[1][1] = 1;

		return recur(m, n);
	}

	private int recur(int r, int c) {
		if (r < 1 || c < 1) {
			return 0;
		}

		if (arr[r][c] == 0) {
			return 0;
		}

		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		dp[r][c] = (recur(r - 1, c) + recur(r, c - 1)) % 1_000_000_007;

		return dp[r][c];
	}
}
