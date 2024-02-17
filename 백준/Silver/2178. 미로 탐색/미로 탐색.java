import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
	int c;
	int r;
	int cnt;

	Point(int c, int r, int cnt) {
		this.c = c;
		this.r = r;
		this.cnt = cnt;
	}
}

public class Main {
	static int n, m;

	static int[][] maze;
	static boolean[][] visited;
	static int[] dc = { -1, 0, 0, 1 };
	static int[] dr = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maze = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			for (int j = 1; j <= m; j++) {
				maze[i][j] = s.charAt(j - 1) - '0';
			}
		}

		bfs(1, 1);

	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 1));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nc = p.c + dc[i];
				int nr = p.r + dr[i];

				if (nc < 1 || nr < 1 || nc > n || nr > m)
					continue;

				if (visited[nc][nr] || maze[nc][nr] == 0)
					continue;

				if (nc == n && nr == m) {
					System.out.println(p.cnt + 1);
					return;
				}

				visited[nc][nr] = true;
				q.add(new Point(nc, nr, p.cnt + 1));

			}
		}
		System.out.println(-1);
	}
}