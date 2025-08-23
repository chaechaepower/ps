import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] board;
	static boolean[][] visited;
	static int n;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];

			StringTokenizer st;
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] > max) {
						max = board[i][j];
					}
				}
			}

			int ans = Integer.MIN_VALUE;
			for (int i = 1; i < max; i++) { // 1일 ~ max-1일 사이 덩어리 개수
				visited = new boolean[n][n];
				int cnt = 0;

				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						if (!visited[r][c] && board[r][c] > i) {
							bfs(r, c, i);
							cnt++;
						}
					}
				}

				ans = Math.max(ans, cnt);
			}
			
			ans= ans==Integer.MIN_VALUE ? 1: ans;

			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static void bfs(int r, int c, int day) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { r, c }); // r,c
		visited[r][c] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int curR = cur[0];
			int curC = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
					continue;
				}

				if (!visited[nr][nc] && board[nr][nc] > day) {
					visited[nr][nc] = true;
					que.offer(new int[] { nr, nc });
				}
			}
		}
	}
}
