import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static char[][] board;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int minTime = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로
		k = Integer.parseInt(st.nextToken());

		board = new char[n][m];
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}

		st = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(st.nextToken()) - 1;
		int startC = Integer.parseInt(st.nextToken()) - 1;
		int targetR = Integer.parseInt(st.nextToken()) - 1;
		int targetC = Integer.parseInt(st.nextToken()) - 1;

		bfs(startR, startC, targetR, targetC);
		System.out.println(minTime);
	}

	private static void bfs(int startR, int startC, int targetR, int targetC) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { startR, startC, 1 }); // r, c, 소요 시간
		int[][] visited = new int[n][m];
		visited[startR][startC] = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int time = cur[2];

			for (int d = 0; d < 4; d++) {
				for (int i = 1; i <= k; i++) {
					int nr = cur[0] + dr[d] * i;
					int nc = cur[1] + dc[d] * i;

					if (nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr][nc] == '#')
						break;

					if (nr == targetR && nc == targetC) {
						minTime = time;
						return;
					}

					if (visited[nr][nc] == 0) { // 방문한 적 없다면
						visited[nr][nc] = time + 1;
						queue.offer(new int[] { nr, nc, time + 1 });
					} 
					else if (time + 1 == visited[nr][nc])
						continue;
					else
						break;
				}
			}
		}
	}
}
