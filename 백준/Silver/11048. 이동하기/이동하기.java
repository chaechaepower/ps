import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[][] map;
	static int[] dr = { -1, 0, -1 };
	static int[] dc = { 0, -1, -1 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][m + 1];
		map = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}

		dp[1][1] = map[1][1];

		System.out.println(recur(n, m));
	}

	private static int recur(int r, int c) {
		if (dp[r][c] == -1) {
			for (int d = 0; d < 3; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 1 || nr >= n + 1 || nc < 1 || nc >= m + 1) {
					continue;
				}

				dp[r][c] = Math.max(dp[r][c], recur(nr, nc) + map[r][c]);
			}
		}

		return dp[r][c];
	}
}
