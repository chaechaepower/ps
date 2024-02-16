import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Knight {
	int r;
	int c;
	int cnt;

	Knight(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Main {
	static int n;
	static int r1, c1; // 현재 위치
	static int r2, c2; // 목적지

	static int[][] board;
	static boolean[][] visited;

	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		visited = new boolean[n][n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());

		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		bfs(r1, c1);
	}

	private static void bfs(int x, int y) {
		Queue<Knight> q = new LinkedList<>();
		q.add(new Knight(x, y, 0));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Knight k = q.poll();

			for (int i = 0; i < 6; i++) {
				int nr = k.r + dr[i];
				int nc = k.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc])
					continue;

				if (nr == r2 && nc == c2) {
					System.out.println(k.cnt + 1);
					return;
				}

				visited[nr][nc] = true;
				q.add(new Knight(nr, nc, k.cnt + 1));

			}
		}
		System.out.println(-1);
	}
}