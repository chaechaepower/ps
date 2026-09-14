import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int n, k, answer;
	static int[][] board;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이 K

			// 지도 초기화
			board = new int[n][n];
			int maxHeight = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, board[i][j]);
				}
			}

			visited = new boolean[n][n];
			answer = Integer.MIN_VALUE;

			// 큐에 가장 높은 봉우리 넣음
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == maxHeight) {
						visited[i][j] = true;
						dfs(i, j, board[i][j], 1, false);
						visited[i][j] = false;
					}
				}
			}

			System.out.printf("#%d %d\n", t, answer);
		}
	}

	private static void dfs(int nowR, int nowC, int nowH, int nowL, boolean isCut) {

		answer = Math.max(answer, nowL);

		for (int d = 0; d < 4; d++) {
			int nextR = nowR + dr[d];
			int nextC = nowC + dc[d];

			if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) {
				continue;
			}

			if (visited[nextR][nextC]) {
				continue;
			}

			if (board[nextR][nextC] < nowH) {
				// 그냥 가
				visited[nextR][nextC] = true;
				dfs(nextR, nextC, board[nextR][nextC], nowL + 1, isCut);
				visited[nextR][nextC] = false;
			}

			else if (!isCut && board[nextR][nextC] - k < nowH) {
				visited[nextR][nextC] = true;
				dfs(nextR, nextC, nowH - 1, nowL + 1, true);
				visited[nextR][nextC] = false;
			}
		}
	}

}

/*
 * 가장 긴 등산로(젤 높은 곳에서 낮은 곳으로) 같은 높이에 대해 k만큼 깎을 수 있음
 * 
 */
