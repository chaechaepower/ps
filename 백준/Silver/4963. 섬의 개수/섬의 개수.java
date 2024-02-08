import java.util.*;
import java.io.*;

class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int dx[] = { -1, 0, 1 };
	static int dy[] = { -1, 0, 1 };
	static int w;
	static int h;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			arr = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && arr[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);

		}

	}

	static void dfs(int x, int y) {

		visited[x][y] = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int nx = x + dx[i];
				int ny = y + dy[j];

				if (nx == 0 && ny == 0)
					continue;

				if (nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

}