import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[n][n][3]; // 0은 가로, 1은 세로, 2는 대각선 아래

		dp[0][1][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (map[i][j] == 1) {
					continue;
				}

				//가로 
				if (j - 1 >= 0 && map[i][j - 1] == 0) {
					dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
				} 
				//세로 
				if (i - 1 >= 0 && map[i - 1][j] == 0) {
					dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
				} 
				//대각선 
				if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1] == 0&& map[i ][j - 1] == 0&& map[i - 1][j ] == 0) {
					dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}

		System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
	}
}
