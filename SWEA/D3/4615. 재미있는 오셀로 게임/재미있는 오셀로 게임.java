import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] dirR = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dirC = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] board = new int[n + 1][n + 1];

			// initialize
			board[n / 2][n / 2] = 2;
			board[n / 2][n / 2 + 1] = 1;
			board[n / 2 + 1][n / 2] = 1;
			board[n / 2 + 1][n / 2 + 1] = 2;

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());

				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());

				board[r][c] = color;

				for (int i = 0; i < 8; i++) {
					int nr = r + dirR[i];
					int nc = c + dirC[i];
					List<int[]> toFilp = new ArrayList<>();

					while (nr >= 1 && nr <= n && nc >= 1 && nc <= n) {
						if (board[nr][nc] == 0) {
							break;
						}

						if (board[nr][nc] == color) {
							// 뒤집음
							for (int[] pos : toFilp) {
								board[pos[0]][pos[1]] = color;
							}
							break;
							
						} else {
							toFilp.add(new int[] { nr, nc });
						}
						
						nr += dirR[i];
						nc += dirC[i];
					}
				}
			}

			int wCount = 0; // 2
			int bCount = 0; // 1

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (board[i][j] == 1) {
						bCount++;
					} else if (board[i][j] == 2) {
						wCount++;
					}
				}
			}

			System.out.printf("#%d %d %d\n", t, bCount, wCount);
		}
	}

}
