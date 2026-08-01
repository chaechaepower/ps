import java.util.ArrayList;
import java.util.List;

class Solution {
	List<Integer>[] graph;
	boolean[] visited;
	int count;
	int answer = Integer.MAX_VALUE;

	public int solution(int n, int[][] wires) {

		graph = new ArrayList[n + 1];
		for (int j = 1; j < n + 1; j++) {
			graph[j] = new ArrayList<>();
		}

		for (int j = 0; j < wires.length; j++) {
			int u = wires[j][0];
			int v = wires[j][1];

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 0; i < wires.length; i++) {
			int u = wires[i][0]; // 제외
			int v = wires[i][1];

			visited = new boolean[n + 1];

			count = 0;
			dfs(1, u, v);
			answer = Math.min(answer, Math.abs(count - (n - count)));
		}

		return answer;
	}

	public void dfs(int now, int u, int v) {
		visited[now] = true;
		count++;

		for (int next : graph[now]) {
			if (visited[next])
				continue;
			
			if((now==u && next==v) || (now==v && next==u)) {
				continue;
			}

			dfs(next, u, v);
		}
	}
}
