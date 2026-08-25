import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

			for (int i = 1; i < k + 1; i++) {

				for (int j = 1; j < n + 1; j++) {
					if (volumes[j] > i) {
						dp[j][i] = dp[j - 1][i];
					} else {
						dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - volumes[j]] + credits[j]);
					}
				}
			}

			System.out.printf("#%d %d\n", t, dp[n][k]);
		}
	}
}
