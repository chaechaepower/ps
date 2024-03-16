import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min = 10000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		visited = new boolean[n][n];

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 구분
		int idx = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					dfs(i, j, idx);
					idx++;
				}
			}
		}

		// 섬과 섬 사이 최소 거리

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) { // 각 섬의 모든 점에 대해 최소거리 조사
					bfs(i, j, map[i][j]);
				}
			}
		}

		System.out.println(min);

	}

	static void bfs(int r, int c, int islandNum) {
		Queue<Point> que = new LinkedList<>();
		boolean[][] check = new boolean[n][n];

		que.add(new Point(r, c, 0));
		check[r][c] = true;

		while (!que.isEmpty()) {
			Point pos = que.poll();

			for (int i = 0; i < 4; i++) {
				int pr = pos.r + dr[i];
				int pc = pos.c + dc[i];

				if (pr < 0 || pr >= n || pc < 0 || pc >= n) {
					continue;
				}

				if (map[pr][pc] == 0 && !check[pr][pc]) { // 바다&&방문하지 않음
					check[pr][pc] = true; // 이거 안하면 메모리 초과 뜸. 큐에 같은 위치가 중복으로 들어갈 수 있음.
					que.add(new Point(pr, pc, pos.cnt + 1));
				} else if (map[pr][pc] != islandNum && map[pr][pc] != 0) { // 다른 섬 && 바다가 아님!(이 조건 추가 안해서 답 안나왓ㅜ)
					if (pos.cnt < min) {
						min = pos.cnt;
					}
					return;
				}
			}

		}
	}

	static void dfs(int r, int c, int islandNum) {
		visited[r][c] = true;
		map[r][c] = islandNum;

		for (int i = 0; i < 4; i++) {
			int pr = r + dr[i];
			int pc = c + dc[i];

			if (pr < 0 || pr >= n || pc < 0 || pc >= n) {
				continue;
			}

			if (map[pr][pc] != 0 && !visited[pr][pc]) {
				dfs(pr, pc, islandNum);
			}
		}
	}
}

class Point {
	int r;
	int c;
	int cnt; // 다른 섬으로의 거리

	public Point(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}