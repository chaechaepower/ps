import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
	static char[][] board;
	static int n;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		board = new char[n][n];

		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}

		// 정상
		int normal = 0;
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j, setColors(board[i][j],false));
					normal++;
				}
			}
		}
		
		int color=0;
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j, setColors(board[i][j],true));
					color++;
				}
			}
		}

		System.out.print(normal+" "+color);
	}

	private static void bfs(int i, int j, Set<Character> colorSet) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j });
		visited[i][j] = true;

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

				if (visited[nr][nc]) {
					continue;
				}

				if (colorSet.contains(board[nr][nc])) {
					visited[nr][nc] = true;
					que.offer(new int[] { nr, nc });
				}
			}
		}
	}

	private static Set<Character> setColors(char color, boolean colored) {
		Set<Character> colorSet = new HashSet<>();
		colorSet.add(color);

		if (colored) {
			if(color=='R') colorSet.add('G');
			if(color=='G') colorSet.add('R');
		}

		return colorSet;
	}
}
