import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int[][] board;
	public static int n, m;

	public static int max = Integer.MIN_VALUE;
	public static int[] dr_plus = { 0, -1, 1, 0 };
	public static int[] dc_plus = { -1, 0, 0, 1 };
	public static int[] dr_multi = { -1, -1, 1, 1 };
	public static int[] dc_multi = { -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			board = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int plusSum = calculateMosquito(i, j, dr_plus, dc_plus);
					int multiSum = calculateMosquito(i, j, dr_multi, dc_multi);
					max = Math.max(max, Math.max(plusSum, multiSum));
				}
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}

	private static int calculateMosquito(int r, int c, int[] dr, int[] dc) { // 노즐 중심 좌표
		int sum = board[r][c];

		for (int i = 1; i < m; i++) {
			for (int k = 0; k < 4; k++) {
				int x = r + dr[k] * i;
				int y = c + dc[k] * i;

				if (x >= 0 && x < n && y >= 0 && y < n) {
					sum += board[x][y];
				}
			}
		}

		return sum;
	}
}
