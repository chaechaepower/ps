import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static boolean[][] map;
	public static boolean[][] visited;
	public static int[] hDir = { -1, -1, -1, 0, 1, 1, 1, 0 };
	public static int[] wDir = { -1, 0, 1, 1, 1, 0, -1, -1 };
	public static int h;
	public static int w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 & h == 0) {
				break;
			}

			map = new boolean[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num == 1 ? true : false;
				}
			}

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}

	}

	public static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int i = 0; i < 8; i++) {
			int newR = r + hDir[i];
			int newC = c + wDir[i];

			if (newR >= 0 && newR < h && newC >= 0 && newC < w) {
				if (!visited[newR][newC] && map[newR][newC]) {
					dfs(newR, newC);
				}
			}
		}
	}
}
