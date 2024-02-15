import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static boolean[][] map;
	static int dx[] = { -2, -2, 0, 0, 2, 2 };
	static int dy[] = { -1, 1, -2, 2, -1, 1 };
	static int n;
	static int ex;
	static int ey;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		map[sx][sy] = true;

		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		map[ex][ey] = true;

		System.out.println(bfs(sx, sy));
	}

	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y, 0 });
		boolean[][] visit = new boolean[n][n];
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int[] list = q.poll();
			int cx = list[0];
			int cy = list[1];
			int cc = list[2];

			for (int i = 0; i < 6; i++) {
				int nowX = cx + dx[i];
				int nowY = cy + dy[i];
				if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < n) {
					if (!visit[nowX][nowY]) {
						if (nowX == ex && nowY == ey) {
							cc++;
							return cc;
						} else {
							visit[nowX][nowY] = true;
							q.add(new int[] { nowX, nowY, cc + 1 });
						}
					}
				}
			}
		}
		return -1;
	}
}