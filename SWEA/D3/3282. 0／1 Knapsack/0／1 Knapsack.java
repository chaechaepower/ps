import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n, k;
	static int[] volumes, credits;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			volumes = new int[n + 1];
			credits = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				volumes[i] = v;
				credits[i] = c;
			}

			dp = new int[n + 1][k + 1]; // i번째 물건까지 확인, 최대 수용 k
			for (int i = 1; i < n + 1; i++) {
				Arrays.fill(dp[i], -1);
			}

			System.out.printf("#%d %d\n", t, recur(n, k));
		}
	}

	private static int recur(int i, int k) {
		if (i < 0) {
			return 0;
		}

		if (dp[i][k] == -1) {
			if (volumes[i] > k) {
				return recur(i - 1, k);
			}

			else {
				dp[i][k] = Math.max(recur(i - 1, k), recur(i - 1, k - volumes[i]) + credits[i]);
			}

		}

		return dp[i][k];
	}
}
