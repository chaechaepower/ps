import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static boolean[][] visited;
	static int n, m;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}

		visited = new boolean[n][m];
		System.out.println(bfs(0, 0));
	}

	private static int bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];

			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;

				if (nr == n - 1 && nc == m - 1) {
					return board[r][c] + 1;
				}

				if (!visited[nr][nc] && board[nr][nc] == 1) {
					visited[nr][nc] = true;
					board[nr][nc] = board[r][c] + 1;
					que.offer(new int[] { nr, nc });
				}
			}
		}

		return -1;
	}
}
