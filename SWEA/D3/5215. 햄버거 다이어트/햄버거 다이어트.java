import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 재료의 수
			int l = Integer.parseInt(st.nextToken()); // 제한 칼로리

			int[] grade = new int[n + 1]; // 맛
			int[] kal = new int[n + 1]; // 칼로리

			for (int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine());
				grade[i] = Integer.parseInt(st.nextToken());
				kal[i] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[n + 1][l + 1]; // dp[i][j]: 재료를 1~i번까지 고려하여 칼로리 j 이하를 만들 때 최대 점수

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < l + 1; j++) {
					if (kal[i] > j)
						dp[i][j] = dp[i - 1][j];
					else
						dp[i][j] = Math.max(dp[i - 1][j - kal[i]] + grade[i], dp[i - 1][j]);
				}
			}

			System.out.printf("#%d %d\n", t, dp[n][l]);
		}
	}
}
