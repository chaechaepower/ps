import java.util.ArrayList;
import java.util.List;

class Solution {
	List<Integer>[] win;
	List<Integer>[] lose;
	boolean[] visited;

	public int solution(int n, int[][] results) {
		win = new ArrayList[n + 1]; // 0사용 x
		for (int i = 1; i < n + 1; i++) {
			win[i] = new ArrayList<>();
		}

		lose = new ArrayList[n + 1]; // 0사용 x
		for (int i = 1; i < n + 1; i++) {
			lose[i] = new ArrayList<>();
		}

		for (int[] result : results) {
			int u = result[0];
			int v = result[1];

			win[u].add(v);
			lose[v].add(u);
		}

		// 정방향 dfs
		int[] winCnt = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			visited = new boolean[n + 1];
			winCnt[i] = dfs(i, win);
		}

		// 역방향 dfs
		int[] loseCnt = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			visited = new boolean[n + 1];
			loseCnt[i] = dfs(i, lose);
		}

		int answer = 0;
		for (int i = 1; i < n + 1; i++) {
			if (winCnt[i] + loseCnt[i] == n - 1) {
				answer++;
			}
		}

		return answer;
	}

	public int dfs(int now, List<Integer>[] graph) {
		visited[now] = true;

		int cnt = 0;

		for (int next : graph[now]) {
			if (visited[next])
				continue;

			cnt += 1 + dfs(next, graph);
		}

		return cnt;
	}
}