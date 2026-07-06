import java.util.LinkedList;
import java.util.Queue;

class Solution {
	int[] dr = { -1, 0, 0, 1 };
	int[] dc = { 0, -1, 1, 0 };

	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 1 });
		maps[0][0] = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			int dist = cur[2];

			for (int i = 0; i < 4; i++) {
				int nextR = curR + dr[i];
				int nextC = curC + dc[i];

				if (nextR == n - 1 && nextC == m - 1) {
					return dist + 1;
				}

				if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
					continue;
				}

				if (maps[nextR][nextC] == 0) {
					continue;
				}

				queue.offer(new int[] { nextR, nextC, dist + 1 });
				maps[nextR][nextC] = 0;
			}
		}

		return -1;
	}
}