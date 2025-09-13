import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int n = Integer.parseInt(br.readLine());

			int[][] board = new int[n][n];

			for (int i = 0; i < n; i++) {
				String line = br.readLine();

				for (int j = 0; j < n; j++) {
					board[i][j] = line.charAt(j) - '0';
				}
			}

			/*
			 * 다익스트라 1. 미방문 정점 중 최단 비용인 정점을 선택 2. 해당 정점과 연결된 미방문 정점의 최단 비용을 갱신(경유지 거침 vs 기존
			 * 비용)
			 */

			// 방문 배열, 최소 비용 배열
			boolean[][] visited = new boolean[n][n];

			int[][] minList = new int[n][n];
			for(int i=0;i<n;i++) Arrays.fill(minList[i], Integer.MAX_VALUE);
			minList[0][0] = board[0][0];

			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() { // 0: r, 1:c, 1: 최소 비용
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			pq.offer(new int[] {0,0,board[0][0]});

			int ans = -1;

			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int curR = cur[0];
				int curC = cur[1];

				if (visited[curR][curC]) continue;

				if (curR == n - 1 && curC == n - 1) {
					ans = minList[curR][curC];
					break;
				}

				visited[curR][curC] = true;

				for (int d = 0; d < 4; d++) {
					int nr = curR + dr[d];
					int nc = curC + dc[d];
					
					if(nr<0 || nr>= n || nc<0 || nc>=n) continue;

					if (visited[nr][nc]) continue;

					if (minList[nr][nc] > minList[curR][curC] + board[nr][nc]) {
						minList[nr][nc] = minList[curR][curC] + board[nr][nc];
						pq.offer(new int[] { nr, nc, minList[nr][nc] });
					}
				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
